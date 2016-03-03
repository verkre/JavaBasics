package jbcourseproject.actions.eulerproblems;

import jbcourseproject.PrimesUtils;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 7.
 */
public class Ep7 extends EulerProblem {

    private static final int ep7InputNumber = 10001;
    
    public Ep7() {
        super("10001st prime (Problem 7)", "https://projecteuler.net/problem=7");
    }
    
    @Override
    public long solve() {
        return PrimesUtils.listFirstNPrimes(ep7InputNumber).get(ep7InputNumber - 1);
    }
    
    @Override
    public void execute() {
        System.out.println("\nThe 10001st prime is " + this.getSolution());
        printUrl();
    }

}
