package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;

public class ActionCheckPrime extends Action {

    public ActionCheckPrime() {
    }
    
    @Override
    public String giveDescription() {
        return "check if a number is prime";
    }
    
    @Override
    public void execute() {
        int intToCheck = UserInput.askInputNumber(1, 2000000000);
        if (PrimesHelper.isPrime(intToCheck)) {
            System.out.printf("\n%d is prime.%n", intToCheck);
        }
        else {
            System.out.printf("\n%d is not prime.%n", intToCheck);
        }
    }
    
    
}
