package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.actions.Action;
import java.util.ArrayList;


public class Ep75 extends Action implements EulerProblem {
    
    private int solution;
    private boolean solutionWasComputed;
    
    public Ep75() {
        solutionWasComputed = false;
    }
    
    @Override
    public String giveDescription() {
        return "Singular integer right triangles (Problem 75). This will take a few minutes!";
    }
    
    @Override
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public int getSolution() {
        if (!this.solutionWasComputed) {
            this.solution = this.howManyTriplesWithUniqueSum(1_500_000);
            this.solutionWasComputed = true;
        }
        return this.solution;
    }
    
    @Override
    public void execute() {
        System.out.printf("\nFor %d values <= 1,500,000 exactly one integer sided right triangle can be formed.%n", this.getSolution());
    }

    
    public int howManyTriplesWithUniqueSum(int maxSum) {
        ArrayList<Integer> sumsFoundOnce = new ArrayList<>();
        ArrayList<Integer> sumsFoundMoreThanOnce = new ArrayList<>();

        for (int m = 1; m <= Math.sqrt(maxSum); m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 0 || EulerProblemsHelper.gcd(m, n) != 1) {
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


        public int generatePythagoreanTripleSum(int m, int n, int k) {
        // where m and n are coprime, m > n, m-n is odd.
        int a = k * (m*m - n*n);
        int b = k * (2 * m *n);
        int c = k * (m*m + n*n);
        return (a + b + c);
    }

}
