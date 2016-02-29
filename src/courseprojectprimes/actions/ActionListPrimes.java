package courseprojectprimes.actions;

import courseprojectprimes.*;
import java.util.ArrayList;

public class ActionListPrimes extends Action {
    
    public ActionListPrimes() {
    }
    
    @Override
    public String giveDescription() {
        return "compute a list of prime numbers";
    }
    
    @Override
    public void execute() {
        int howMany = new UserInput().askInputNumber(1);
        ArrayList<Integer> primeList = PrimesHelper.listFirstNPrimes(howMany);
        System.out.printf("Here is a list of the first %d primes: %n", howMany);
        System.out.println(primeList);
    }
}
