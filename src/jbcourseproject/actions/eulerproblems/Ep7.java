package jbcourseproject.actions.eulerproblems;

import jbcourseproject.PrimesUtils;
import jbcourseproject.database.EulerSolutionsConnector;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 7.
 */
public class Ep7 extends EulerProblem {

    private static final int inputNumber = 10001;
    
    public Ep7() {
        super("7", "10001st prime (Problem 7)", "https://projecteuler.net/problem=7");
    }
    
    public Ep7(EulerSolutionsConnector esc) {
        super("7", "10001st prime (Problem 7)", "https://projecteuler.net/problem=7", esc);
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
        return "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.\n"
                + "\n"
                + "What is the 10 001st prime number?"
                + "\n\n"
                + "https://projecteuler.net/problem=7";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        System.out.println("not possible.");
    }

    @Override
    public String getSolutionString() {
        return "The 10001st prime is " + this.getSolution() + ".";
    }



}
