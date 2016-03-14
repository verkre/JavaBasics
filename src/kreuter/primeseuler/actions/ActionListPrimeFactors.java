package kreuter.primeseuler.actions;

import kreuter.primeseuler.PrimesUtils;
import kreuter.primeseuler.UserInput;

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
        return "In number theory, the prime factors of a positive integer are the "
                + "prime numbers that divide that integer exactly. The prime factorization "
                + "of a positive integer is a list of the integer's prime factors, together with "
                + "their multiplicities; the process of determining these factors is called integer "
                + "factorization. The fundamental theorem of arithmetic says that every positive "
                + "integer has a single unique prime factorization."
                + "\n\n"
                + "-- quoted from https://en.wikipedia.org/wiki/Prime_factor"
                + "\n\n"
                + "Enter a number in the field below and click the button to show a list of its prime factors."
                ;
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        this.inputNumber = newInputNumber;
    }
}
