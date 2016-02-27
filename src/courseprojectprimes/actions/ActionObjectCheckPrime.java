package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;

public class ActionObjectCheckPrime extends ActionObject {

    public ActionObjectCheckPrime() {
        description = "check if a number is prime";
    }
    
    @Override
    public void go() {
        int intToCheck = UserInput.askInputNumber(1, 2000000000);
        if (PrimesHelper.isPrime(intToCheck)) {
            System.out.printf("%d is prime.%n", intToCheck);
        }
        else {
            System.out.printf("%d is not prime.%n", intToCheck);
        }
    }
    
    
}
