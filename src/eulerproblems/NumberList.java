
package eulerproblems;



public class NumberList {
    public int[] array;
    public NumberList(int[] array) {
        this.array = array;
    }
    
    public boolean isLastElementEven() {
        return getLastElement() % 2 == 0;
    }
    
    public int getLastElement() {
        return this.array[this.array.length - 1];
    }
    
    public void computeNextFib() {
        // shift elements of the list to the left, dropping the first one,
        // generate the next fibonacci number and add it as the third element
        int nextFib = this.array[1] + this.array[2];
        this.array[0] = this.array[1];
        this.array[1] = this.array[2];
        this.array[2] = nextFib;
        
    }

}
