package courseprojectprimes.actions;

import courseprojectprimes.*;
import eulerproblems.*;
import java.util.ArrayList;

public class ActionEulerProblems extends Action {
    // has-a description
    // has-a ?
    // knows how to 
    // - ask the user for a problem number (-> have the UserInput class do that)
    // - check whether it can solve that problem
    // - find the solution
    // - output the solution.

    // TODO make the EP objects know about which solutions it already computed and store them
    // would be nice for the computations that take longer than a second or so.
    public ActionEulerProblems() {
    }

    // TODO change menu display and choosing to use displayAndChooseFromMenu method from UserInput
    // TODO make class for each (available) problem, instantiate an object of each of those classes here
    // these objects live as long as we stay in this action object - once we return to the main menu they are gone
    // and so are their cached solutions (TODO keep objects and their stored solution as long as the program runs)
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
        // TODO use displayMenu method (pass list of Ep objects as arguments), give Ep objects go methods that show the solution
        
        // stay in this sub-menu until user enters 0 (to return to main menu)
        while (true) {
            int eulerProblemChoice = UserInput.chooseEulerProblem();
            if (eulerProblemChoice == 0) {
                return;
            }
            if (eulerProblemChoice == 2) {
                ep2Object.execute();
            }
            if (eulerProblemChoice == 4) {
                ep4Object.execute();
            } 
            else if (eulerProblemChoice == 7) {
                ep7Object.execute();
            } 
            else if (eulerProblemChoice == 75) {
                ep75Object.execute();
            }
            else {
                System.out.println("Sorry, can't do that yet.");
            }

        }
    }

}
