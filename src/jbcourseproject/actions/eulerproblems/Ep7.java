package jbcourseproject.actions.eulerproblems;

import jbcourseproject.PrimesUtils;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 7.
 */
public class Ep7 extends EulerProblem {

    private static final int inputNumber = 10001;
    
    public Ep7() {
        super("Problem 7", "10001st prime (Problem 7)", "https://projecteuler.net/problem=7");
    }
    
    @Override
    public long solve() {
        return PrimesUtils.listFirstNPrimes(inputNumber).get(inputNumber - 1);
    }
    
    @Override
    public void execute() {
        System.out.println("\nThe 10001st prime is " + this.getSolution());
        printUrl();
    }

    @Override
    public String getInfoText() {
        return "...";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        System.out.println("not possible.");
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
