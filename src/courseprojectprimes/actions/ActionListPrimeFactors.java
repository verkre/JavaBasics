package courseprojectprimes.actions;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.UserInput;

public class ActionListPrimeFactors extends Action {
    
    public ActionListPrimeFactors() {
    }
    
    @Override
    public String giveDescription() {
        return "compute the prime factors of a number";
    }
    
    @Override
    public void execute() {
        int intToFactorize = UserInput.askInputNumber(2);
        System.out.printf("The prime factors of %d are:%n", intToFactorize);
        System.out.println(PrimesHelper.computePrimeFactors(intToFactorize));
    }
}
