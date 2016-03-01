/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.PrimesHelper;
import courseprojectprimes.actions.Action;

public class Ep3 extends Action implements EulerProblem {

    private long solution;
    private boolean solutionWasComputed;

    public Ep3() {
        this.solutionWasComputed = false;
    }

    @Override
    protected String giveDescription() {
        return "Largest prime factor of 600851475143 (Problem 3)";
    }

    @Override
    public boolean isSolved() {
        return this.solutionWasComputed;
    }


    public long getSolution() {
        if (!this.solutionWasComputed) {
            this.solution = PrimesHelper.findLargestPrimeFactor(600851475143L);
            this.solutionWasComputed = true;
        }
        return this.solution;
    }
    

    @Override
    public void execute() {
        System.out.println("\nThe largest prime factor of 600851475143 is " + this.getSolution() + ".");
    }

}
