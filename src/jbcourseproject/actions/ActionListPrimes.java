package jbcourseproject.actions;

import jbcourseproject.UserInput;
import jbcourseproject.PrimesHelper;
import java.util.ArrayList;

/**
 * This asks the user for a number and prints a list of primes of that length.
 */
public class ActionListPrimes extends Action {
    
    public ActionListPrimes() {
    }
    
    @Override
    public String describeSelf() {
        return "compute a certain number of prime numbers";
    }
    
    @Override
    public void execute() {
        int howMany = new UserInput().askInputInteger(1);
        ArrayList<Integer> primeList = PrimesHelper.listFirstNPrimes(howMany);
        System.out.printf("Here is a list of the first %d primes: %n", howMany);
        System.out.println(primeList);
    }
}
