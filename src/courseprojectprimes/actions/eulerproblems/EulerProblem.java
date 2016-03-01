package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.actions.*
/**
 *
 * @author Vera Kreuter
 */
public abstract class EulerProblem extends Action {

    long solution;
    boolean solutionWasComputed;
    
    public EulerProblem() {
        this.solutionWasComputed = false;
    }
    
    protected String giveDescription() {
        return "EulerProblem superclass, subclass of Action";
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public abstract long solve();
    
    public long getSolution() {
        if (!this.solutionWasComputed) {
            this.solution = this.solve();
            this.solutionWasComputed = true;
        }
        else {
            System.out.println("\n...getting cached solution...");
        }
        return this.solution;
    }
    
    public abstract void execute();
}
