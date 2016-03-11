package jbcourseproject.actions.eulerproblems;

import jbcourseproject.PrimesUtils;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 3.
 */
public class Ep3 extends EulerProblem {
    
    private static final long inputNumber = 600851475143L;
    public Ep3() {
        super("Problem 3", "Largest prime factor of 600851475143 (Problem 3)", "https://projecteuler.net/problem=3");
    }

    @Override
    public long solve() {
        return PrimesUtils.findLargestPrimeFactor(inputNumber);
    }

    @Override
    public void execute() {
        System.out.println("\nThe largest prime factor of 600851475143 is " + this.getSolution() + ".");
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
