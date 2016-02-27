package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;

public class ActionObjectCheckPrime extends ActionObject {
    // has-a description, -what else?-
    // has-a number that we check
    // knows how to check that number and output the result (go() method)
    // 
//    private Number numberToCheck; // we ask user to input a number right here in the go method. Ok?
    
//    public ActionObjectCheckPrime(int numberToCheck) {
//        description = "check if a number is prime";
//        this.numberToCheck = new Number(numberToCheck);
//    }
    
    // constructor without setting input number
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
