
package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.actions.Action;

public class Ep7 extends EulerProblem {

    
    public Ep7() {
    }
    
    @Override
    public String giveDescription() {
        return "10001st prime (Problem 7)";
    }
    
    public long solve() {
        return PrimesHelper.listFirstNPrimes(10001).get(10000);
    }
    
    @Override
    public void execute() {
        System.out.println("\nThe 10001st prime is " + this.getSolution());
    }

}
