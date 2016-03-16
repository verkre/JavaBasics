package kreuter.primeseuler.actions;

import kreuter.primeseuler.PrimesUtils;
import java.util.ArrayList;
import kreuter.primeseuler.exceptions.InvalidInputException;

/**
 * Main menu item/action: Ask the user for a number and print a list of primes of that length.
 */
public class ActionListPrimes extends Action {
    
    private final Long lowerInputBound;
    
    public ActionListPrimes() {
        super("First n primes", "compute a certain number of prime numbers", true);
        this.lowerInputBound = 1L;
    }
    
    @Override
    public void execute() {
//        long inputNumber = new UserInput().askInputLongInt(getLowerInputBound());
        ArrayList<Long> primeList = PrimesUtils.listFirstNPrimes(getInputNumber());
        System.out.printf("Here is a list of the first %d primes: %n", getInputNumber());
        System.out.println(primeList);
    }
    
    @Override
    public String getSolutionString() {
        return "Here is a list of the first " + getInputNumber() + " primes:\n"
                + PrimesUtils.listFirstNPrimes(getInputNumber());
    }
    @Override
    public String getInfoText() {
        return "\"A prime number (or a prime) is a natural number greater than 1 that has no positive \"\n"
                + "divisors other than 1 and itself."
                + "\n"
                + "There are infinitely many primes."
                + "\n\n"
                + "-- quoted from https://en.wikipedia.org/wiki/Prime_number"
                + "\n\n"
                + "Enter in the field below how many primes you want and click the button to get a list.";
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
