
package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.actions.Action;

public class Ep7 extends Action implements EulerProblem {

    private int solution;
    private boolean solutionWasComputed;
    
    public Ep7() {
        solutionWasComputed = false;
    }
    
    @Override
    public String giveDescription() {
        return "10001st prime (Problem 7)";
    }
    
    @Override
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
    
    @Override
    public void execute() {
        System.out.println("\nThe 10001st prime is " + this.getSolution());
    }

}
