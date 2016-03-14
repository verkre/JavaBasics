package jbcourseproject.actions.eulerproblems;

import java.util.ArrayList;
import jbcourseproject.actions.eulerproblems.EulerProblemsUtils;
import jbcourseproject.database.EulerSolutionsConnector;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 75.
 */
public class Ep75 extends EulerProblem {
    
    private static final int inputNumber = 1_500_000;
    
    public Ep75() {
        super("75", "Singular integer right triangles (Problem 75). This will take a few minutes!", "https://projecteuler.net/problem=75");
    }
    
    public Ep75(EulerSolutionsConnector esc) {
        super("75", "Singular integer right triangles (Problem 75). This will take a few minutes!", "https://projecteuler.net/problem=75", esc);
    }
    
    @Override
    public long solve() {
        return howManyTriplesWithUniqueSum(inputNumber);
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

    @Override
    public String getInfoText() {
        return "It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way, but there are many more examples.\n"
                + "\n"
                + "12 cm: (3,4,5)\n"
                + "24 cm: (6,8,10)\n"
                + "30 cm: (5,12,13)\n"
                + "36 cm: (9,12,15)\n"
                + "40 cm: (8,15,17)\n"
                + "48 cm: (12,16,20)\n"
                + "\n"
                + "In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, and other lengths allow more than one solution to be found; for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.\n"
                + "\n"
                + "120 cm: (30,40,50), (20,48,52), (24,45,51)\n"
                + "\n"
                + "Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed?"
                + "\n\n"
                + "https://projecteuler.net/problem=75";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        System.out.println("not possible.");
    }

    @Override
    public String getSolutionString() {
        return "For " + this.getSolution() + " values <= 1,500,000 exactly one integer sided right triangle can be formed.";
    }


}
