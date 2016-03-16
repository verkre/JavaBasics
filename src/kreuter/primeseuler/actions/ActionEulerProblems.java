package kreuter.primeseuler.actions;

import kreuter.primeseuler.actions.eulerproblems.Ep75;
import kreuter.primeseuler.actions.eulerproblems.Ep3;
import kreuter.primeseuler.actions.eulerproblems.Ep7;
import kreuter.primeseuler.actions.eulerproblems.Ep4;
import kreuter.primeseuler.actions.eulerproblems.Ep2;
import java.util.ArrayList;
import kreuter.primeseuler.database.EulerSolutionsConnector;
import kreuter.primeseuler.userinterface.ViewTUI;

/**
 * This class manages the Project Euler problem objects, and basically acts as a
 * sub-controller (shows a sub-menu for the problems).
 */
public class ActionEulerProblems extends Action {

    private ArrayList<Action> availableEulerProblems;

    public ActionEulerProblems(EulerSolutionsConnector esc) {
        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
        this.availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ActionExitToMainMenu());
        availableEulerProblems.add(new Ep2(esc));
        availableEulerProblems.add(new Ep3(esc));
        availableEulerProblems.add(new Ep4(esc));
        availableEulerProblems.add(new Ep7(esc));
        availableEulerProblems.add(new Ep75(esc));
    }

    public ActionEulerProblems() {
        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
        this.availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ActionExitToMainMenu());
        availableEulerProblems.add(new Ep2());
        availableEulerProblems.add(new Ep3());
        availableEulerProblems.add(new Ep4());
        availableEulerProblems.add(new Ep7());
        availableEulerProblems.add(new Ep75());
    }
        

    @Override
    public String getInfoText() {
        throw new UnsupportedOperationException("Override me if an info text is needed in this subclass.");
    }

    @Override
    public void execute() {
        while (new ViewTUI().displayAndChooseFromMenu(getEulerProblems())) {
        }
    }

    public ArrayList<Action> getEulerProblems() {
        return availableEulerProblems;
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        // do nothing, no input needed here
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Override me if a solution string is needed in this subclass.");
    }

}
