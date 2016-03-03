package jbcourseproject.actions;

import jbcourseproject.PrimesUtils;
import jbcourseproject.UserInput;

/**
 * Main menu item/action: Ask the user for a number, compute and print its prime factors.
 */
public class ActionListPrimeFactors extends Action {
    
    public ActionListPrimeFactors() {
        super("compute the prime factors of a number");
    }
    
    @Override
    public void execute() {
        long numberToFactorize = new UserInput().askInputLongInt(2L);
        System.out.printf("\nThe prime factors of %d are:%n", numberToFactorize);
        System.out.println(PrimesUtils.computePrimeFactors(numberToFactorize));
    }
}
