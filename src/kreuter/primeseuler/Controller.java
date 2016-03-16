package kreuter.primeseuler;

import kreuter.primeseuler.actions.ActionListPrimeFactors;
import kreuter.primeseuler.actions.ActionListPrimesBelow;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.actions.ActionExit;
import kreuter.primeseuler.actions.ActionListPrimes;
import kreuter.primeseuler.actions.ActionEulerProblems;
import kreuter.primeseuler.actions.ActionCheckPrime;
import java.util.ArrayList;
import java.util.List;
import kreuter.primeseuler.database.DbConnection;
import kreuter.primeseuler.database.EulerSolutionsConnector;

public class Controller {
    
    private ActionEulerProblems actionEulerProblems;
    private List<Action> eulerProblems;
    private EulerSolutionsConnector esc;
    
    public Controller() {
        DbConnection dbConnection = new DbConnection();
        if (dbConnection.connect()) {
            this.esc = new EulerSolutionsConnector(dbConnection);
            this.actionEulerProblems = new ActionEulerProblems(esc);
        } else {
            this.actionEulerProblems = new ActionEulerProblems();
        }
        this.eulerProblems = actionEulerProblems.getEulerProblems();
    }
    
    public List<Action> getActions() {
        return collectActionObjects();
    }
    
    public List<Action> getEulerProblemActions() {
        return eulerProblems;
    }
    
    /**
     * Collect all Actions that should appear in the main menu in an ArrayList.
     * @return an ArrayList of Action objects
     */
    private ArrayList<Action> collectActionObjects() {
        // these are only instantiated once at the start of the program - so there is no need to declare them as 
        // class attributes (as with the EulerProblem objects in the sub-menu)
        // except the actionEulerProblems that establishes the DB connection.
        // if it weren't a class attribute, it would be instantiated twice (once here, once to collect its own
        // actions).
        ArrayList<Action> availableActionObjects = new ArrayList<>();
        availableActionObjects.add(new ActionExit());
        availableActionObjects.add(new ActionCheckPrime());
        availableActionObjects.add(new ActionListPrimeFactors());
        availableActionObjects.add(new ActionListPrimes());
        availableActionObjects.add(new ActionListPrimesBelow());
        availableActionObjects.add(actionEulerProblems);
        return availableActionObjects;
    }
    
    // TODO
        // possible PE problems that have to do with primes:
        // -- problem 10: method to find all primes up to upperBound (first, learn to handle large numbers)
        // -- problem 35: iterate over list of primes, permutate numbers (convert to string and back?) then check for primeness
        // -- problem 41: permutations of 9 (8..) digits, check for primeness and find largest
        // -- problem 49: 
        // -- problem 50: add up sub-lists of prime list and check result for primeness

}
