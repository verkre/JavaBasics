
package jbcourseproject.actions.eulerproblems;

import jbcourseproject.PrimesUtils;
import jbcourseproject.actions.Action;

public class Ep7 extends EulerProblem {

    
    public Ep7() {
    }
    
    @Override
    public String describeSelf() {
        return "10001st prime (Problem 7)";
    }

    @Override
    public String giveUrl() {
        return "https://projecteuler.net/problem=7";
    }
    
    public long solve() {
        return PrimesUtils.listFirstNPrimes(10001).get(10000);
    }
    
    @Override
    public void execute() {
        System.out.println("\nThe 10001st prime is " + this.getSolution());
        printUrl();
    }

}
