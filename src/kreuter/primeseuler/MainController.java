package kreuter.primeseuler;

import kreuter.primeseuler.interfaces.Controller;
import kreuter.primeseuler.actions.ActionListPrimeFactors;
import kreuter.primeseuler.actions.ActionListPrimesBelow;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.actions.ActionTUIExit;
import kreuter.primeseuler.actions.ActionListPrimes;
import kreuter.primeseuler.actions.ActionEpSubcontroller;
import kreuter.primeseuler.actions.ActionCheckPrime;
import java.util.ArrayList;
import java.util.List;
import kreuter.primeseuler.database.DbConnection;
import kreuter.primeseuler.database.EulerSolutionsConnector;

public class MainController implements Controller {
    
    private ActionEpSubcontroller actionEulerProblems;
    private List<Action> eulerProblems;
    private EulerSolutionsConnector esc;
    
    public MainController() {
        this.actionEulerProblems = new ActionEpSubcontroller(this);
        DbConnection dbConnection = new DbConnection();
        if (dbConnection.connect()) {
            this.esc = new EulerSolutionsConnector(dbConnection);
            this.actionEulerProblems = new ActionEpSubcontroller(this);
        } else {
            this.actionEulerProblems = new ActionEpSubcontroller();
        }
        this.eulerProblems = actionEulerProblems.getMenuItems();
    }
    
    @Override
    public ArrayList<Action> getMenuItems() {
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
        availableActionObjects.add(new ActionTUIExit());
        availableActionObjects.add(new ActionCheckPrime());
        availableActionObjects.add(new ActionListPrimeFactors());
        availableActionObjects.add(new ActionListPrimes());
        availableActionObjects.add(new ActionListPrimesBelow());
        availableActionObjects.add(actionEulerProblems);
        return availableActionObjects;
    }

    public EulerSolutionsConnector getEsc() {
        return esc;
    }
}
