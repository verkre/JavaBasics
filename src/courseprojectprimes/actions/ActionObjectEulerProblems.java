package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;
import java.util.ArrayList;

public class ActionObjectEulerProblems extends ActionObject {
    // has-a description
    // has-a ?
    // knows how to 
    // - ask the user for a problem number (-> have the UserInput class do that)
    // - check whether it can solve that problem
    // - find the solution
    // - output the solution.
    

    public ActionObjectEulerProblems() {
        description = "show the solution to a problem from Project Euler";
    }

    @Override
    public void go() {
        int eulerProblemChoice = UserInput.chooseEulerProblem();
        if (eulerProblemChoice == 0) {
            return;
        }
        if (eulerProblemChoice == 7) {
            ArrayList<Integer> primeList = PrimesHelper.listFirstNPrimes(10001);
            System.out.println("The 10001st prime is " + primeList.get(10000));
        } 
        else {
            System.out.println("Sorry, can't do that yet.");
        }

    
    }
    
    
    
}
