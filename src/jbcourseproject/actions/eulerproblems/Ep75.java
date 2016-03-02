package jbcourseproject.actions.eulerproblems;

import java.util.ArrayList;


public class Ep75 extends EulerProblem {
    
    public Ep75() {
        super("Singular integer right triangles (Problem 75). This will take a few minutes!");
    }
    
//    @Override
//    public String describeSelf() {
//        return "Singular integer right triangles (Problem 75). This will take a few minutes!";
//    }

    @Override
    public String giveUrl() {
        return "https://projecteuler.net/problem=75";
    }
    
    @Override
    public long solve() {
        return howManyTriplesWithUniqueSum(1_500_000);
    }
    
    @Override
    public void execute() {
        System.out.printf("\nFor %d values <= 1,500,000 exactly one integer sided right triangle can be formed.%n", this.getSolution());
        printUrl();
    }
    
    private int howManyTriplesWithUniqueSum(int maxSum) {
        ArrayList<Integer> sumsFoundOnce = new ArrayList<>();
        ArrayList<Integer> sumsFoundMoreThanOnce = new ArrayList<>();

        for (int m = 1; m <= Math.sqrt(maxSum); m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 0 || EulerProblemsUtils.gcd(m, n) != 1) {
                    // m - n has to be odd and the greatest common divisor of m and n ahs to be 1
                    continue;
                }
                for (int k = 1; k <= (maxSum/(m*m + n*n)); k++) {
                    int thisSum = generatePythagoreanTripleSum(m, n, k);
                    if (thisSum > maxSum) {
                        break;
                    }
                    if (sumsFoundMoreThanOnce.contains(thisSum)) {
                        continue;
                    } else if (sumsFoundOnce.contains(thisSum)) {
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

        private int generatePythagoreanTripleSum(int m, int n, int k) {
        // where m and n are coprime, m > n, m-n is odd.
        int a = k * (m*m - n*n);
        int b = k * (2 * m *n);
        int c = k * (m*m + n*n);
        return (a + b + c);
    }

}
