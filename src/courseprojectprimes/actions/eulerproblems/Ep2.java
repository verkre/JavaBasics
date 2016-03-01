/*
https://projecteuler.net/problem=2

find the sum of even-valued fibonacci numbers that do not exceed four million.

*/

package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.actions.Action;

public class Ep2 extends Action implements EulerProblem {
    
    private int solution;
    private boolean solutionWasComputed;
    public Ep2() {
        this.solutionWasComputed = false;
    }
    
    @Override
    public String giveDescription() {
        return "Even Fibonacci numbers (Problem 2)";
    }
    
    @Override
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public int getSolution() {
        if (!this.solutionWasComputed) {
            this.solution = this.evenFibSumUpTo(4_000_000);
            this.solutionWasComputed = true;
        }
        else {
            System.out.println("\n...getting cached solution...");
        }
        return this.solution;
    }
    
    @Override
    public void execute() {
        System.out.println("\nThe sum of the even-valued fibonacci numbers up to 4 million is " + this.getSolution());
    }
    
    public int evenFibSumUpTo(int upperBound) {
        // keeps only the last 3 computed fibonacci numbers in an array
        // if last one is even, add it to resultSum
        // update the array by shifting the values to the left and adding the next fib on the right
        // do all of this while the third element of list is < upperBound
        FibonacciArray lastThreeFibs = new FibonacciArray(new int[]{0, 1, 1});
        int resultSum = 0;
        while (lastThreeFibs.getLastElement() < upperBound) {
            // if the last fibonacci number we generated so far is even, add it to the sum
            if (lastThreeFibs.isLastElementEven()) {
                resultSum += lastThreeFibs.getLastElement();
            }
            lastThreeFibs.computeNextFib();
        }
        return resultSum;
    }

   
    
}
