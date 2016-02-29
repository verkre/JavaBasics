package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;
import courseprojectprimes.MenuInterface;

public class ActionListPrimeFactors extends Action {
    
    public ActionListPrimeFactors() {
    }
    
    @Override
    public String giveDescription() {
        return "compute the prime factors of a number";
    }
    
    @Override
    public void execute() {
        int intToFactorize = new UserInput().askInputNumber(2);
        System.out.printf("\nThe prime factors of %d are:%n", intToFactorize);
        System.out.println(PrimesHelper.computePrimeFactors(intToFactorize));
    }
}
