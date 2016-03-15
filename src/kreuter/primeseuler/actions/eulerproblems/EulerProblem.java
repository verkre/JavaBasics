package kreuter.primeseuler.actions.eulerproblems;

import java.sql.Connection;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.database.DbConnection;
import kreuter.primeseuler.database.EulerSolutionsConnector;

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
        this(problemNumber, description, url);
        this.esc = esc;
    }
    
    @Override
    public abstract String getInfoText();
    
    @Override
    public abstract String getSolutionString();
    // TODO why do these have to be here and is not passed on directly to the subclasses of this class
    
    
    /**
     * @param esc the esc to set
     */
    public void setEsc(EulerSolutionsConnector esc) {
        this.esc = esc;
    }
    // TODO use this instead of overloaded constructor
 
    public abstract long solve();
    
    public void printUrl() {
        System.out.println("Find details on this problem here: " + this.url);
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public long getSolution() {
        if (this.esc != null) {
            if (esc.getSolutionForProblem(problemNumber) != null) {
                // TODO extract method to check if problem is already in db, put it in esc
                System.out.println("getting solution from db");
                String solutionStringFromDb = esc.getSolutionForProblem(problemNumber);
                solution = new Long(solutionStringFromDb);
                solutionWasComputed = true;
            } else if (solutionWasComputed) {
                // insert it into the db
                System.out.println("writing solution to db");
                esc.insert(problemNumber, solution.toString());
            } else {
                solution = solve();
                solutionWasComputed = true;
                System.out.println("writing solution to db");
                esc.insert(problemNumber, solution.toString());
            }
        }
        // if there is no db connection:
        if (!solutionWasComputed) {
            solution = solve();
            solutionWasComputed = true;
        }
        return solution;
    }

}
