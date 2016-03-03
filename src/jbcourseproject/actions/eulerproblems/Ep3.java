package jbcourseproject.actions.eulerproblems;

import jbcourseproject.PrimesUtils;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 3.
 */
public class Ep3 extends EulerProblem {
    
    private static final long ep3InputNumber = 600851475143L;
    public Ep3() {
        super("Largest prime factor of 600851475143 (Problem 3)", "https://projecteuler.net/problem=3");
    }

    @Override
    public long solve() {
        return PrimesUtils.findLargestPrimeFactor(ep3InputNumber);
    }

    @Override
    public void execute() {
        System.out.println("\nThe largest prime factor of 600851475143 is " + this.getSolution() + ".");
        printUrl();
    }

}
