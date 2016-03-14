package jbcourseproject.actions.eulerproblems;

import java.sql.Connection;
import jbcourseproject.actions.Action;
import jbcourseproject.database.DbConnection;
import jbcourseproject.database.EulerSolutionsConnector;

/**
 * This is a superclass for all the "Project Euler" problems which show up in their
 * own sub-menu. They are different from the other Actions in that no user interaction
 * (asking for input number) is required. Once their solution was computed for the first time,
 * it is cached and the cached value is returned if the user chooses the same problem again.
 * Additionally to the description and the execute() method defined in the Action superclass,
 * this class has attributes and methods for computing, caching and getting the solution, as well
 * as for printing the URL of the respective projecteuler.com page.
 */
public abstract class EulerProblem extends Action {

    private Long solution;
    private boolean solutionWasComputed;
    private String url;
    private EulerSolutionsConnector esc;
    private String problemNumber;
    
    public EulerProblem(String problemNumber, String description, String url) {
        super("Problem " + problemNumber, description, false);
        // passes the first constructor argument to the constructor of the superclass (Action)
        this.solutionWasComputed = false;
        this.url = url;
        this.problemNumber = problemNumber;
    }
    
    // overload constructor to take a db connection. if it is present, solutions can be read from the db.
    public EulerProblem(String problemNumber, String description, String url, EulerSolutionsConnector esc) {
        super("Problem " + problemNumber, description, false);
        this.solutionWasComputed = false;
        this.url = url;
        this.problemNumber = problemNumber;
        this.esc = esc;
        System.out.println(esc);
    }
    
    @Override
    public abstract String getInfoText();
    
    @Override
    public abstract String getSolutionString();
    // TODO why do these have to be here and is not passed on directly to the subclasses of this class
    
    public abstract long solve();
    
    public void printUrl() {
        System.out.println("Find details on this problem here: " + this.url);
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public long getSolution() {
        if (this.esc != null) {
            if (esc.getSolutionForProblem(this.problemNumber) != null) {
                System.out.println("getting solution from db");
                String solutionStringFromDb = esc.getSolutionForProblem(this.problemNumber);
                this.solution = new Long(solutionStringFromDb);
                return this.solution;
            } else {
                // compute solution and insert it into the db
                this.solution = this.solve();
                this.solutionWasComputed = true;
                System.out.println("writing solution to db");
                esc.insert(problemNumber, solution.toString());
            }
        }
        // if there is no db connection:
        if (!this.solutionWasComputed) {
            this.solution = this.solve();
            this.solutionWasComputed = true;
        }
//        else {
//            System.out.println("\n...getting cached solution...");
//        }
        return this.solution;
        
        // TODO change this method: try to get the solution from the database
        // if there is no connection or if solution is not in the db, compute it
        // and write it in the db (if there is a connection).
    }
    
//    public String getSolutionFromDB() {
//        Connection connection = new DbConnection().getConnection();
//    }
}
