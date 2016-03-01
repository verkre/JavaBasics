package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;

/**
 * This asks the user for an input number (long), checks whether that number is a prime,
 * and prints the result.
 */
public class ActionCheckPrime extends Action {

    public ActionCheckPrime() {
    }
    
    @Override
    public String giveDescription() {
        return "check if a number is prime";
    }
    
    @Override
    public void execute() {
        long numberToCheck = new UserInput().askInputLongInt(1L, 9_223_372_036_854_775_807L);
        if (PrimesHelper.isPrime(numberToCheck)) {
            System.out.printf("\n%d is prime.%n", numberToCheck);
        }
        else {
            System.out.printf("\n%d is not prime.%n", numberToCheck);
        }
    }
    
    
}
