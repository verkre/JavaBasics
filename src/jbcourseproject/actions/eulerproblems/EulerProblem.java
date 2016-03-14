package jbcourseproject.actions.eulerproblems;

import jbcourseproject.actions.Action;

/**
 * This is a superclass for all the "Project Euler" problems which show up in their
 * own sub-menu. They are different from the other Actions in that no user interaction
 * (asking for input number) is required. Once their solution was computed for the first time,
 * it is cached and the cached value is returned if the user chooses the same problem again.
 * Additionally to the description and the execute() method defined in the Action superclass,
 * this class has attributes and methods for computing, caching and getting the solution, as well
 * as for printing the URL of the respective projecteuler.com page.
 */
public abstract class EulerProblem extends Action {

    private long solution;
    private boolean solutionWasComputed;
    private String url;
    
    public EulerProblem(String title, String description, String url) {
        super(title, description, false);
        // passes the first constructor argument to the constructor of the superclass (Action)
        this.solutionWasComputed = false;
        this.url = url;
    }
    
    public abstract long solve();
    
    public void printUrl() {
        System.out.println("Find details on this problem here: " + this.url);
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public long getSolution() {
        if (!this.solutionWasComputed) {
            this.solution = this.solve();
            this.solutionWasComputed = true;
        }
//        else {
//            System.out.println("\n...getting cached solution...");
//        }
        return this.solution;
    }
    
    @Override
    public abstract String getInfoText();
    public abstract String getSolutionString();
    // TODO why do these have to be here and is not passed on directly to the subclasses of this class
}
