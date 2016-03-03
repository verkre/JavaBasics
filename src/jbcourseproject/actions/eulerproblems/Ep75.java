package jbcourseproject.actions.eulerproblems;

import java.util.ArrayList;
import jbcourseproject.actions.eulerproblems.EulerProblemsUtils;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 75.
 */
public class Ep75 extends EulerProblem {
    
    private static final int ep75InputNumber = 1_500_000;
    public Ep75() {
        super("Singular integer right triangles (Problem 75). This will take a few minutes!", "https://projecteuler.net/problem=75");
    }
    
    @Override
    public long solve() {
        return howManyTriplesWithUniqueSum(ep75InputNumber);
    }
    
    @Override
    public void execute() {
        System.out.printf("\nFor %d values <= 1,500,000 exactly one integer sided right triangle can be formed.%n", this.getSolution());
        printUrl();
    }
    
    /**
     * This method generates the sums Pythagorean triples up to a given max sum and checks for each sum
     * whether a triple with that sum was already found.
     * @param maxSum
     * @return the number of sums up to the given max sum that were the sum of exactly one Pythagorean triple
     */
    private int howManyTriplesWithUniqueSum(int maxSum) {
        // This method is very specific to the 75th problem from projecteuler
        // TODO also quite long and not very readable. Should possibly be broken down into two or more methods.
        ArrayList<Integer> sumsFoundOnce = new ArrayList<>();
        ArrayList<Integer> sumsFoundMoreThanOnce = new ArrayList<>();
        
        // m, n, and k are parameters for an algorithm that generates Pythagorean triples.
        for (int m = 1; m <= Math.sqrt(maxSum); m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 0 || EulerProblemsUtils.greatestCommonDivisor(m, n) != 1) {
                    // m - n has to be odd and the greatest common divisor of m and n has to be 1.
                    continue;
                }
                for (int k = 1; k <= (maxSum/(m*m + n*n)); k++) {
                    int thisSum = EulerProblemsUtils.generatePythagoreanTripleSum(m, n, k);
                    if (thisSum > maxSum) {
                        break;
                    }
                    if (sumsFoundMoreThanOnce.contains(thisSum)) {
                        continue;
                    } else if (sumsFoundOnce.contains(thisSum)) {
                        // we found a triple with that sum for the second time
                        sumsFoundMoreThanOnce.add(thisSum);
                        sumsFoundOnce.remove(sumsFoundOnce.indexOf(thisSum));
                    } else {
                        // this is the first triple we found with that sum
                        sumsFoundOnce.add(thisSum);
                    }
                    }
                }
        }
        return sumsFoundOnce.size();
    }


}
