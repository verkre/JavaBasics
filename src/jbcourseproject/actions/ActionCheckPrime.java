package jbcourseproject.actions;

import jbcourseproject.PrimesUtils;
import jbcourseproject.UserInput;

/**
 * Main menu item/action: Check a number (input from user) for primeness.
 */
public class ActionCheckPrime extends Action {
    
    private Long inputNumber;
    

    public ActionCheckPrime() {
        super("Prime checker", "check if a number is prime", true);
    }
    
    @Override
    public void setInputNumber(Long inputNumber) {
        this.inputNumber = inputNumber;
        // TODO add validity checking; return true/false depending on whether new value was set?
    }
    
    @Override
    public String getSolutionString() {
        String solutionString;
        if (PrimesUtils.isPrime(inputNumber)) {
            solutionString = "" + inputNumber + " is prime.";
        } else {
            solutionString = "" + inputNumber + " is not prime.";
        }
        return solutionString;
    }
    
    @Override
    public String getInfoText() {
        return "A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.\n" +
"-- quoted from https://en.wikipedia.org/wiki/Prime_number\n" +
" \n" +
"maybe also a link to Wikipedia,\n" +
"maybe also the option to display the first part of the Wikipedia article right here,\n" +
"...)";
    }
    
    public String getHowtoText() {
        return "Enter the number (integer) that you want to check and click the 'check' button.";
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
