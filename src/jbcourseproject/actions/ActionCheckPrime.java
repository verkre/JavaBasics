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
        return "A prime number (or a prime) is a natural number greater than 1 that has no positive "
                + "divisors other than 1 and itself."
                + "\n"
                + "There are infinitely many primes, as demonstrated by Euclid around 300 BC. There is no "
                + "known simple formula that separates prime numbers from composite numbers. However, the distribution "
                + "of primes, that is to say, the statistical behaviour of primes in the large, can be modelled. "
                + "The first result in that direction is the prime number theorem, proven at the end of the "
                + "19th century, which says that the probability that a given, randomly chosen number n is "
                + "prime is inversely proportional to its number of digits, or to the logarithm of n."
                + "\n\n"
                + "-- quoted from https://en.wikipedia.org/wiki/Prime_number"
                + "\n\n"
                + "Enter a number (an integer) in the field below and click the button to check whether it is a prime."
               ;
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
