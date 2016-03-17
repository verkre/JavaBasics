package kreuter.primeseuler.actions;

import kreuter.primeseuler.actions.eulerproblems.Ep75;
import kreuter.primeseuler.actions.eulerproblems.Ep3;
import kreuter.primeseuler.actions.eulerproblems.Ep7;
import kreuter.primeseuler.actions.eulerproblems.Ep4;
import kreuter.primeseuler.actions.eulerproblems.Ep2;
import java.util.ArrayList;
import kreuter.primeseuler.MainController;
import kreuter.primeseuler.interfaces.Controller;
import kreuter.primeseuler.actions.eulerproblems.Ep67;
import kreuter.primeseuler.database.EulerSolutionsConnector;
import kreuter.primeseuler.userinterface.ViewTUI;

/**
 * This class manages the Project Euler problem objects, and basically acts as a
 * sub-controller (shows a sub-menu for the problems).
 */
public class ActionEpSubcontroller extends Action implements Controller {

    private ArrayList<Action> availableEulerProblems;
    private ActionGUIWelcomeEp epWelcomeScreen;

    public ActionEpSubcontroller(MainController controller) {
        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
        this.availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ActionTUIExitToMainMenu());
        availableEulerProblems.add(new Ep2(controller.getEsc()));
        availableEulerProblems.add(new Ep3(controller.getEsc()));
        availableEulerProblems.add(new Ep4(controller.getEsc()));
        availableEulerProblems.add(new Ep7(controller.getEsc()));
        availableEulerProblems.add(new Ep67(controller.getEsc()));
        availableEulerProblems.add(new Ep75(controller.getEsc()));
        epWelcomeScreen = new ActionGUIWelcomeEp(controller.getEsc());
    }

    public ActionEpSubcontroller() {
        super("Project Euler Problems", "show the solution to a problem from Project Euler", false);
        this.availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ActionTUIExitToMainMenu());
        availableEulerProblems.add(new Ep2());
        availableEulerProblems.add(new Ep3());
        availableEulerProblems.add(new Ep4());
        availableEulerProblems.add(new Ep7());
        availableEulerProblems.add(new Ep67());
        availableEulerProblems.add(new Ep75());
        epWelcomeScreen = new ActionGUIWelcomeEp();
    }
        

    @Override
    public String getInfoText() {
        throw new UnsupportedOperationException("Override me if an info text is needed in this subclass.");
    }

    @Override
    public void execute() {
        while (new ViewTUI().displayAndChooseFromMenu(getMenuItems())) {
        }
    }

    public ArrayList<Action> getMenuItems() {
        return availableEulerProblems;
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        throw new UnsupportedOperationException("Override me if this class really needs input");
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Override me if a solution string is needed in this subclass.");
    }

}
