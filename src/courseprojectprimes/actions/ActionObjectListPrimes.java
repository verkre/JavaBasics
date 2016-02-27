package courseprojectprimes.actions;

import courseprojectprimes.*;
import java.util.ArrayList;

public class ActionObjectListPrimes extends ActionObject {
    
    public ActionObjectListPrimes() {
        description = "compute a list of prime numbers";
    }
    
    
    @Override
    public void go() {
        int howMany = UserInput.askInputNumber(1);
        ArrayList<Integer> primeList = PrimesHelper.listFirstNPrimes(howMany);
        System.out.printf("Here is a list of the first %d primes: %n", howMany);
        System.out.println(primeList);
    }
}
