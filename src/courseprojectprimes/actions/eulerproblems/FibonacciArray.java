
package courseprojectprimes.actions.eulerproblems;


/**
 * This is a class to help with some operations on an array of integers (used in
 * the generation of fibonacci numbers and sums)
 * @author Vera Kreuter
 */

public class FibonacciArray {
    public long[] array;
    public FibonacciArray(long[] array) {
        this.array = array;
    }
    
    public boolean isLastElementEven() {
        return getLastElement() % 2 == 0;
    }
    
    public long getLastElement() {
        return this.array[this.array.length - 1];
    }
    
    public void computeNextFib() {
        // shift elements of the list to the left, dropping the first one,
        // generate the next fibonacci number and add it as the third element
        long nextFib = this.array[1] + this.array[2];
        this.array[0] = this.array[1];
        this.array[1] = this.array[2];
        this.array[2] = nextFib;
        
    }

}
