package jbcourseproject.actions;

import jbcourseproject.actions.eulerproblems.Ep75;
import jbcourseproject.actions.eulerproblems.Ep3;
import jbcourseproject.actions.eulerproblems.Ep7;
import jbcourseproject.actions.eulerproblems.Ep4;
import jbcourseproject.actions.eulerproblems.Ep2;
import java.util.ArrayList;
import jbcourseproject.database.DbConnection;
import jbcourseproject.database.EulerSolutionsConnector;
import jbcourseproject.userinterface.ViewTUI;

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

//    private EulerSolutionsConnector esc;
    private Long inputNumber = null;

//    public ActionEulerProblems() {
//        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
//        ep2Object = new Ep2();
//        ep3Object = new Ep3();
//        ep4Object = new Ep4();
//        ep7Object = new Ep7();
//        ep75Object = new Ep75();
//    }
    public ActionEulerProblems() {
        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
        try {
            EulerSolutionsConnector esc = new EulerSolutionsConnector(new DbConnection().getConnection());
            ep2Object = new Ep2(esc);
            ep3Object = new Ep3(esc);
            ep4Object = new Ep4(esc);
            ep7Object = new Ep7(esc);
            ep75Object = new Ep75(esc);
        } catch (NullPointerException ex) {
            ep2Object = new Ep2();
            ep3Object = new Ep3();
            ep4Object = new Ep4();
            ep7Object = new Ep7();
            ep75Object = new Ep75();
            // but isn't this using exceptions to control the program flow
            // which would better be achieved by an if/else or something?
        }
    }

    @Override
    public String getInfoText() {
        return "...";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
