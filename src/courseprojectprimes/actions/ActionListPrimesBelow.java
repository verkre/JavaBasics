package courseprojectprimes.actions;

import courseprojectprimes.*;
import java.util.ArrayList;

public class ActionListPrimesBelow extends Action {
    
    public ActionListPrimesBelow() {
    }
    
    @Override
    public String giveDescription() {
        return "compute all prime numbers smaller than a certain number";
    }
    
    @Override
    public void execute() {
        int upperBound = new UserInput().askInputInteger(1);
        ArrayList<Integer> primeList = PrimesHelper.listPrimesBelow(upperBound);
        System.out.printf("Here is a list of all primes smaller than %d: %n", upperBound);
        System.out.println(primeList);
    }
}
