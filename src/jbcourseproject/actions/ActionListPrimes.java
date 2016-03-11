package jbcourseproject.actions;

import jbcourseproject.UserInput;
import jbcourseproject.PrimesUtils;
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
        return "...";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        this.inputNumber = newInputNumber;
    }
}
