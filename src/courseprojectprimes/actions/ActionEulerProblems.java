package courseprojectprimes.actions;

import courseprojectprimes.actions.eulerproblems.*;
import courseprojectprimes.*;
import java.util.ArrayList;

public class ActionEulerProblems extends Action {
    
    Ep2 ep2Object;
    Ep3 ep3Object;
    Ep4 ep4Object;
    Ep7 ep7Object;
    Ep75 ep75Object;
    
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

    // TODO these objects live as long as we stay in this action object - once we return to the main menu they are gone
    // and so are their cached solutions (better: keep objects and their stored solution as long as the program runs)
    
//    ep3Object = new Ep3();
//    ep4Object = new Ep4();
//    ep7Object = new Ep7();
//    ep75Object = new Ep75();
    
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

    public ArrayList<Action> collectEulerProblems() {
        ArrayList<Action> availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ExitToMainMenu());
        availableEulerProblems.add(ep2Object);
        availableEulerProblems.add(ep3Object);
        availableEulerProblems.add(ep4Object);
        availableEulerProblems.add(ep7Object);
        availableEulerProblems.add(ep75Object);
        return availableEulerProblems;
    }
    
}
