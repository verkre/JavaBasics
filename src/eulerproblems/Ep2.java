/*
https://projecteuler.net/problem=2

find the sum of even-valued fibonacci numbers that do not exceed four million.

*/

package eulerproblems;

// TODO make a super class (or interface?) for all these Ep classes!

public class Ep2 {
    
    private int solution;
    private boolean solutionWasComputed;
    public Ep2() {
        this.solutionWasComputed = false;
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public int showSolution() {
        if (this.solutionWasComputed) {
            this.solution = this.evenFibSumUpTo(4_000_000);
            this.solutionWasComputed = true;
        }
        return this.solution;
    }
    
    public void execute() {
        System.out.println("The sum of the even-valued fibonacci numbers up to 4 million is " + this.showSolution());
    }
    
    public int evenFibSumUpTo(int upperBound) {
        // list of last 3 fibs so far
        // if last one ist even, add to resultSum
        // update list by shifting the values to the left and adding the next fib on the right
        // do all of this while third element of list is < 4 million
        NumberList lastThreeFibs = new NumberList(new int[]{0, 1, 1});
        int resultSum = 0;
        while (lastThreeFibs.getLastElement() < upperBound) {
            // if the last fibonacci number we generated so far is even, add it to the sum
            if (lastThreeFibs.isLastElementEven()) {
                resultSum += lastThreeFibs.getLastElement();
            }
            
            lastThreeFibs.computeNextFib();
            // if we exceed the given upperBound here, the loop ends
        }
        return resultSum;
    }

   
    
}
