package courseprojectprimes.actions;

import courseprojectprimes.*;
import eulerproblems.*;
import java.util.ArrayList;

public class ActionEulerProblems extends Action {

    public ActionEulerProblems() {
    }

    // TODO these objects live as long as we stay in this action object - once we return to the main menu they are gone
    // and so are their cached solutions (better: keep objects and their stored solution as long as the program runs)
    Ep2 ep2Object = new Ep2();
    Ep4 ep4Object = new Ep4();
    Ep7 ep7Object = new Ep7();
    Ep75 ep75Object = new Ep75();
    
    
  
    @Override
    public String giveDescription() {
        return "show the solution to a problem from Project Euler";
    }

    @Override
    public void execute() {
        
        
        
        // stay in this sub-menu until user enters 0 (to return to main menu)
        MenuInterface eulerUserInterface = new MenuInterface(this.collectEulerProblems());
        while (true) {
            eulerUserInterface.displayAndChooseFromMenu();
        }
    }

    public ArrayList<Action> collectEulerProblems() {
        ArrayList<Action> availableEulerProblems = new ArrayList<>();
        availableEulerProblems.add(new ExitToMainMenu());
        availableEulerProblems.add(ep2Object);
        availableEulerProblems.add(ep4Object);
        availableEulerProblems.add(ep7Object);
        availableEulerProblems.add(ep75Object);
        return availableEulerProblems;
    }
    
    
    
}
