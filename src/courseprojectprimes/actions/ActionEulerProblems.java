package courseprojectprimes.actions;

import courseprojectprimes.actions.eulerproblems.*;
import courseprojectprimes.*;
import java.util.ArrayList;

/**
 * This manages the Project Euler problem objects, and basically acts as a sub-controller
 * (instantiates a sub-menu for the problems)
 */
public class ActionEulerProblems extends Action {
    
    Ep2 ep2Object;
    Ep3 ep3Object;
    Ep4 ep4Object;
    Ep7 ep7Object;
    Ep75 ep75Object;
    
    /**
     * Instantiate each available EulerProblem, but only when called for the first time.
     */
    public ActionEulerProblems() {
        if (ep2Object == null) {
            ep2Object = new Ep2();
        }
        if (ep3Object == null) {
            ep3Object = new Ep3();
        }
        if (ep4Object == null) {
            ep4Object = new Ep4();
        }
        if (ep7Object == null) {
            ep7Object = new Ep7();
        }
        if (ep75Object == null) {
            ep75Object = new Ep75();
        }
    }

    @Override
    public String giveDescription() {
        return "show the solution to a problem from Project Euler";
    }

    @Override
    public void execute() {
        // stay in this sub-menu until user enters 0 (to return to main menu)
        MenuInterface eulerMenuInterface = new MenuInterface(this.collectEulerProblems());
        while (eulerMenuInterface.displayAndChooseFromMenu()) {
            // displayAndChooseFromMenu will return false once the user chooses the back-to-main-menu option
        }
    }

    /**
     * Make a list of all the available problems that should show up in the sub-menu,
     * plus the exit-back-to-main Action.
     * @return An ArrayList<> of EulerProblem objects.
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
    
}
