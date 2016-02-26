package courseprojectprimes.actions;

import courseprojectprimes.Number;
import courseprojectprimes.UserInput;

public class ActionObjectListPrimeFactors extends ActionObject {
    
    public ActionObjectListPrimeFactors() {
        description = "compute the prime factors of a number";
    }
    
    @Override
    public void go() {
        int intToFactorize = UserInput.askInputNumber(2);
        Number numberToFactorize = new Number(intToFactorize);
        System.out.printf("The prime factors of %d are:%n", intToFactorize);
        System.out.println(numberToFactorize.computePrimeFactors());
    }
}
