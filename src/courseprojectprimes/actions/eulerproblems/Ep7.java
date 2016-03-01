
package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.actions.Action;

public class Ep7 extends Action {

    private int solution;
    private boolean solutionWasComputed;
    
    public Ep7() {
        solutionWasComputed = false;
    }
    
    public String giveDescription() {
        return "Problem 7 - 10001st prime";
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public int getSolution() {
        if (!this.solutionWasComputed) {
            this.solution = PrimesHelper.listFirstNPrimes(10001).get(10000);
            this.solutionWasComputed = true;
        }
        return this.solution;
    }
    
    public void execute() {
        System.out.println("\nThe 10001st prime is " + this.getSolution());
    }

}
