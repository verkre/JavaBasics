
package kreuter.primeseuler.actions.eulerproblems;


/**
 * Implements some methods on a long array of 3 consecutive fibonacci numbers. 
 * Specific to use within the Ep2 class to help with the solution of the 2nd problem on projecteuler.com.
 */
public class FibonacciArray {
    private long[] array;
    
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
    
    // TODO This class is now very specific for use in the Ep2 class. It is not very robust
    // (e.g. no checking whether the argument really is a 3-element array, which it has to be)
    // or useful for anything but this purpose.
}
