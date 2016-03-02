/*
https://projecteuler.net/problem=2

find the sum of even-valued fibonacci numbers that do not exceed four million.

*/

package jbcourseproject.actions.eulerproblems;


public class Ep2 extends EulerProblem {
    
    public Ep2() {
        super("Even Fibonacci numbers (Problem 2)");
    }
    
//    @Override
//    public String describeSelf() {
//        return "Even Fibonacci numbers (Problem 2)";
//    }
    
    @Override
    public String giveUrl() {
        return "https://projecteuler.net/problem=2";
    }
    
    @Override
    public long solve() {
        return evenFibSumUpTo(4_000_000L);
    }
        
    @Override
    public void execute() {
        System.out.println("\nThe sum of the even-valued fibonacci numbers up to 4 million is " + this.getSolution());
        printUrl();
    }
    
    private long evenFibSumUpTo(long upperBound) {
        // keeps only the last 3 computed fibonacci numbers in an array
        // if last one is even, add it to resultSum
        // update the array by shifting the values to the left and adding the next fib on the right
        // do all of this while the third element of list is < upperBound
        FibonacciArray lastThreeFibs = new FibonacciArray(new long[]{0, 1, 1});
        long resultSum = 0;
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
