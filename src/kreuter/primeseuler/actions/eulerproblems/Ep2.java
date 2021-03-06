package kreuter.primeseuler.actions.eulerproblems;

import kreuter.primeseuler.utils.FibonacciArray;
import kreuter.primeseuler.database.EulerSolutionsConnector;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 2.
 */
public class Ep2 extends EulerProblem {

    private Long inputNumber = 4_000_000L;

    public Ep2() {
        super("2", "Even Fibonacci numbers (Problem 2)", "https://projecteuler.net/problem=2");
    }

    public Ep2(EulerSolutionsConnector esc) {
        super("2", "Even Fibonacci numbers (Problem 2)", "https://projecteuler.net/problem=2", esc);
    }

    @Override
    public long solve() {
        return evenFibSumUpTo(inputNumber);
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

    @Override
    public String getInfoText() {
        return "Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:\n"
                + "\n"
                + "1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...\n"
                + "\n"
                + "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms."
                + "\n\n"
                + "https://projecteuler.net/problem=2";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        throw new UnsupportedOperationException("This does not take input.");
    }

    @Override
    public String getSolutionString() {
        writeToLogFile();
        return "The sum of the even-valued fibonacci numbers up to 4 million is " + this.getSolution() + ".";
    }

}
