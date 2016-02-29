
package eulerproblems;

import courseprojectprimes.PrimesHelper;

public class Ep7 extends EulerProblem {

    private int solution;
    private boolean solutionWasComputed;
    
    public Ep7() {
        solutionWasComputed = false;
    }

    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public int showSolution() {
        if (!this.solutionWasComputed) {
            this.solution = PrimesHelper.listFirstNPrimes(10001).get(10000);
            this.solutionWasComputed = true;
        }
        return this.solution;
    }
    
    public void execute() {
        System.out.println("The 10001st prime is " + this.showSolution());
    }

}
