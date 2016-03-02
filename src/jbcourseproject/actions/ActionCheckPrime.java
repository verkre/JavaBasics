package jbcourseproject.actions;

import jbcourseproject.PrimesUtils;
import jbcourseproject.UserInput;

/**
 * 
 */
public class ActionCheckPrime extends Action {

    public ActionCheckPrime() {
        super("check if a number is prime");
    }
    
//    @Override
//    public String describeSelf() {
//        return "check if a number is prime";
//    }
    
    @Override
    public void execute() {
        long numberToCheck = new UserInput().askInputLongInt(1L);
        if (PrimesUtils.isPrime(numberToCheck)) {
            System.out.printf("\n%d is prime.%n", numberToCheck);
        }
        else {
            System.out.printf("\n%d is not prime.%n", numberToCheck);
        }
    }
    
    
}
