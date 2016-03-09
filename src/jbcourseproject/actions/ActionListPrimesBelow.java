package jbcourseproject.actions;

import jbcourseproject.UserInput;
import jbcourseproject.PrimesUtils;
import java.util.ArrayList;

/**
 * Main menu item/action: Ask the user for a number and print a list of all primes smaller than that number.
 */
public class ActionListPrimesBelow extends Action {
    
    public ActionListPrimesBelow() {
        super("Prime list", "compute all prime numbers smaller than a certain number");
    }
    
    @Override
    public void execute() {
        int upperBound = new UserInput().askInputInteger(1);
        ArrayList<Integer> primeList = PrimesUtils.listPrimesBelow(upperBound);
        System.out.printf("Here is a list of all primes smaller than %d: %n", upperBound);
        System.out.println(primeList);
    }
}
