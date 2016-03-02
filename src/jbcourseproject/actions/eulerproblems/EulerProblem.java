package jbcourseproject.actions.eulerproblems;

import jbcourseproject.actions.Action;

/**
 * This is a superclass for all the "Project Euler" problems which show up in their
 * own sub-menu. They are different from the other Actions in that no user interaction
 * (asking for input number) is required. Once their solution was computed for the first time,
 * it is cached and the cached value is returned if the user chooses the same problem again.
 * Additionally to the description and the execute() method defined in the Action superclass,
 * this class has attributes and methods for computing, caching and getting the solution.
 */
public abstract class EulerProblem extends Action {

    long solution;
    boolean solutionWasComputed;
    protected String url;
    
    public EulerProblem() {
        this.solutionWasComputed = false;
    }
    
    public void printUrl() {
        System.out.println("Find details on this problem here: " + this.url);
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
    
}
