package jbcourseproject.actions;

import jbcourseproject.actions.eulerproblems.Ep75;
import jbcourseproject.actions.eulerproblems.Ep3;
import jbcourseproject.actions.eulerproblems.Ep7;
import jbcourseproject.actions.eulerproblems.Ep4;
import jbcourseproject.actions.eulerproblems.Ep2;
import jbcourseproject.MenuInterface;
import java.util.ArrayList;

/**
 * This manages the Project Euler problem objects, and basically acts as a sub-controller
 * (instantiates a sub-menu for the problems)
 */
public class ActionEulerProblems extends Action {
    
    private Ep2 ep2Object;
    private Ep3 ep3Object;
    private Ep4 ep4Object;
    private Ep7 ep7Object;
    private Ep75 ep75Object;
    
    /**
     * Instantiate each available EulerProblem, but only when called for the first time.
     */
    public ActionEulerProblems() {
        super("show the solution to a problem from Project Euler");
        ep2Object = new Ep2();
        ep3Object = new Ep3();
        ep4Object = new Ep4();
        ep7Object = new Ep7();
        ep75Object = new Ep75();
    }

//    @Override
//    protected String describeSelf() {
//        return "show the solution to a problem from Project Euler";
//    }

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
