package kreuter.primeseuler.actions.eulerproblems;

import kreuter.primeseuler.utils.Logger;
import kreuter.primeseuler.actions.Action;
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
        this.solutionWasComputed = false;
        this.url = url;
        this.problemNumber = problemNumber;
    }
    
    // overload constructor to take a db connection. if it is present, 
    // objects can read their solutions from the db.
    public EulerProblem(String problemNumber, String description, String url, EulerSolutionsConnector esc) {
        this(problemNumber, description, url);
        this.esc = esc;
    }
    
    @Override
    public abstract String getInfoText();
    
    @Override
    public abstract String getSolutionString();
    // TODO why do these have to be here and are not passed on directly to the subclasses of this class
    
    /**
     * Compute the solution that is represented by the object by calling the appropriate methods.
     * @return The solution as a long int.
     */
    public abstract long solve();
    
    public void printUrl() {
        System.out.println("Find details on this problem here: " + url);
    }
    
    /**
     * Get the solution by either getting it from the database or from the object
     * attribute if it was already computed once, or by calling the solve() method.
     * When the solution is computed for the first time, the solution attribute is set
     * and the solution is written to the database (if available).
     * @return The solution to the problem from projecteuler.com that is represented by the object as a long integer.
     */
    public long getSolution() {
        if (esc != null && esc.getDbConnection().isConnected()) {
            if (esc.isInDB(problemNumber)) {
                Logger.writeToLogFile("getting solution to " + getTitle() + " from db");
                String solutionStringFromDb = esc.getSolutionForProblem(problemNumber);
                // not checking whether the solution attribute was already set in the object - just setting it (again).
                solution = new Long(solutionStringFromDb);
                solutionWasComputed = true;
            } else if (solutionWasComputed) {
                // if it is not in DB, but was already computed - not sure if this can happen, but who knows.
                Logger.writeToLogFile("writing solution to " + getTitle() + " to db");
                esc.insert(problemNumber, solution.toString());
            } else {
                solution = solve();
                solutionWasComputed = true;
                Logger.writeToLogFile("writing solution to " + getTitle() + " to db");
                esc.insert(problemNumber, solution.toString());
            }
        }
        if (esc != null && esc.getDbConnection().isConnected() == false) {
            Logger.writeToLogFile("Lost database connection");
        }
        // if esc == null, there is no db connection. compute and set solution if it is not set yet:
        if (!solutionWasComputed) {
            solution = solve();
            solutionWasComputed = true;
        }
        return solution;
    }
    
    @Override
    public void execute() {
        System.out.println(getSolutionString());
        printUrl();
        writeToLogFile();
    }

}
