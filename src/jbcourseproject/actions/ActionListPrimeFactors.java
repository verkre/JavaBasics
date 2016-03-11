package jbcourseproject.actions;

import jbcourseproject.PrimesUtils;
import jbcourseproject.UserInput;

/**
 * Main menu item/action: Ask the user for a number, compute and print its prime factors.
 */
public class ActionListPrimeFactors extends Action {
    
    private Long inputNumber;
    
    public ActionListPrimeFactors() {
        super("Prime Factors", "compute the prime factors of a number", true);
    }
    
    @Override
    public void execute() {
        long numberToFactorize = new UserInput().askInputLongInt(2L);
        System.out.printf("\nThe prime factors of %d are:%n", numberToFactorize);
        System.out.println(PrimesUtils.computePrimeFactors(numberToFactorize));
    }
    
    public String getSolutionString() {
        return "The prime factors of " + this.inputNumber + " are:\n"
                + PrimesUtils.computePrimeFactors(this.inputNumber);
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
