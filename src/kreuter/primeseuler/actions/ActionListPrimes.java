package kreuter.primeseuler.actions;

import kreuter.primeseuler.UserInput;
import kreuter.primeseuler.PrimesUtils;
import java.util.ArrayList;

/**
 * Main menu item/action: Ask the user for a number and print a list of primes of that length.
 */
public class ActionListPrimes extends Action {
    
    private Long inputNumber;
    
    public ActionListPrimes() {
        super("First n primes", "compute a certain number of prime numbers", true);
    }
    
    @Override
    public void execute() {
        int howMany = new UserInput().askInputInteger(1);
        ArrayList<Integer> primeList = PrimesUtils.listFirstNPrimes(howMany);
        System.out.printf("Here is a list of the first %d primes: %n", howMany);
        System.out.println(primeList);
    }
    
    public String getSolutionString() {
        return "Here is a list of the first " + inputNumber + " primes:\n"
                + PrimesUtils.listFirstNPrimes(inputNumber);
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
    public void setInputNumber(Long newInputNumber) {
        this.inputNumber = newInputNumber;
    }
}
