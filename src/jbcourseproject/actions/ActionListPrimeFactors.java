package jbcourseproject.actions;

import jbcourseproject.PrimesHelper;
import jbcourseproject.UserInput;

/**
 * Ask the user for a number, compute and print its prime factors.
 */
public class ActionListPrimeFactors extends Action {
    
    public ActionListPrimeFactors() {
    }
    
    @Override
    public String giveDescription() {
        return "compute the prime factors of a number";
    }
    
    @Override
    public void execute() {
        long numberToFactorize = new UserInput().askInputLongInt(2L, 9_223_372_036_854_775_807L);
        System.out.printf("\nThe prime factors of %d are:%n", numberToFactorize);
        System.out.println(PrimesHelper.computePrimeFactors(numberToFactorize));
    }
}
