package jbcourseproject.actions.eulerproblems;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 2.
 */
public class Ep2 extends EulerProblem {
    
    public Ep2() {
        super("Even Fibonacci numbers (Problem 2)");
    }
    
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
        // instantiates an FibonacciArray object which keeps the last 3 computed fibonacci numbers in an array
        // if last one is even, add it to resultSum, then compute the next fib. number
        // do all of this while the third element of list is < upperBound
        FibonacciArray lastThreeFibs = new FibonacciArray(new long[]{0, 1, 1});
        long resultSum = 0;
        while (lastThreeFibs.getLastElement() < upperBound) {
            if (lastThreeFibs.isLastElementEven()) {
                resultSum += lastThreeFibs.getLastElement();
            }
            lastThreeFibs.computeNextFib();
        }
        return resultSum;
    }


   
    
}
