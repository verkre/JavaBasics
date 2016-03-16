package kreuter.primeseuler.actions;

import kreuter.primeseuler.PrimesUtils;
import java.util.ArrayList;
import kreuter.primeseuler.exceptions.InvalidInputException;

/**
 * Main menu item/action: Ask the user for a number and print a list of all primes smaller than that number.
 */
public class ActionListPrimesBelow extends Action {
    
    private final Long lowerInputBound;
    
    public ActionListPrimesBelow() {
        super("Primes up to n", "compute all prime numbers smaller than a certain number", true);
        this.lowerInputBound = 1L;
    }
    
    @Override
    public String getSolutionString() {
        writeToLogFile();
        return "Here is a list of all primes smaller than " + getInputNumber() + ":\n"
                + PrimesUtils.listPrimesBelow(getInputNumber());
    }
    
    @Override
    public String getInfoText() {
        return "A prime number (or a prime) is a natural number greater than 1 that has no positive \"\n"
                + "divisors other than 1 and itself."
                + "\n"
                + "There are infinitely many primes."
                + "\n\n"
                + "-- quoted from https://en.wikipedia.org/wiki/Prime_number"
                + "\n\n"
                + "Enter a number (an integer) in the field below and click the "
                + "button to get a list of all primes smaller than that number.";
    }

    @Override
    public boolean isValidInput(Long inputNumber) {
        return (inputNumber >= getLowerInputBound());
    }

    @Override
    public Long getLowerInputBound() {
        return lowerInputBound;
    }
}
