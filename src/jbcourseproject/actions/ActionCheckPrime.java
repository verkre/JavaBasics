package jbcourseproject.actions;

import jbcourseproject.PrimesUtils;
import jbcourseproject.UserInput;

/**
 * Main menu item/action: Check a number (input from user) for primeness.
 */
public class ActionCheckPrime extends Action {

    public ActionCheckPrime() {
        super("Prime checker", "check if a number is prime");
    }
    
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
    
    // TODO for GUI:
    // declare a executeForGUI method in the Action class, 
    // or in a new DisplayableInGui interface, (and implement it here) that
    // - gets user input from the GUI somehow(?)
    // - calls the method that solves the problem
    // - passes its result to the GUI/ view object
    
    
}
