package kreuter.primeseuler.actions;

import java.sql.SQLException;
import kreuter.primeseuler.actions.eulerproblems.Ep75;
import kreuter.primeseuler.actions.eulerproblems.Ep3;
import kreuter.primeseuler.actions.eulerproblems.Ep7;
import kreuter.primeseuler.actions.eulerproblems.Ep4;
import kreuter.primeseuler.actions.eulerproblems.Ep2;
import java.util.ArrayList;
import kreuter.primeseuler.database.DbConnection;
import kreuter.primeseuler.database.EulerSolutionsConnector;
import kreuter.primeseuler.userinterface.ViewTUI;

/**
 * This class manages the Project Euler problem objects, and basically acts as a
 * sub-controller (shows a sub-menu for the problems).
 */
public class ActionEulerProblems extends Action {

    private Ep2 ep2Object;
    private Ep3 ep3Object;
    private Ep4 ep4Object;
    private Ep7 ep7Object;
    private Ep75 ep75Object;

    private Long inputNumber = null;

    public ActionEulerProblems() {
        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
        DbConnection dbConnection = new DbConnection();
        // TODO if db connection is not possible, the ensuing exception is caught in its constructor.
        // is there a better way?
        // establish db connection in controller and pass it to this action
        // replace ep instance attributes by a list (as one instance attribute)
        if (dbConnection.isConnected()) {
            EulerSolutionsConnector esc = new EulerSolutionsConnector(dbConnection.getConnection());
            ep2Object = new Ep2(esc);
            ep3Object = new Ep3(esc);
            ep4Object = new Ep4(esc);
            ep7Object = new Ep7(esc);
            ep75Object = new Ep75(esc);
        } else {
            ep2Object = new Ep2();
            ep3Object = new Ep3();
            ep4Object = new Ep4();
            ep7Object = new Ep7();
            ep75Object = new Ep75();
        }
    }

    @Override
    public String getInfoText() {
        return "...";
        // this should never be called
    }

    @Override
    public void execute() {
        while (new ViewTUI().displayAndChooseFromMenu(collectEulerProblems())) {
        }
    }

    /**
     * Make a list of all the available problems that should show up in the
     * sub-menu, plus the exit-back-to-main Action.
     *
     * @return An ArrayList of EulerProblem objects
     */
    public ArrayList<Action> collectEulerProblems() {
        ArrayList<Action> availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ActionExitToMainMenu());
        availableEulerProblems.add(ep2Object);
        availableEulerProblems.add(ep3Object);
        availableEulerProblems.add(ep4Object);
        availableEulerProblems.add(ep7Object);
        availableEulerProblems.add(ep75Object);
        return availableEulerProblems;
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        // do nothing, no input needed here
    }

    @Override
    public String getSolutionString() {
        return "";
        // this should never be called
    }

}
