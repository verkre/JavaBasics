
package courseprojectprimes;

import java.util.ArrayList;

/**
 *
 * @author Vera Kreuter
 */
public class Number {
    private int number;
    public Number(int number) {
        this.number = number;
    }
    
    // TODO rewrite (?) these methods to work for long integers (or overload them?)
    
    public int getValue() {
        return this.number;
    }
    public boolean isPrime() {
        int potentialPrime = this.number;
        return isPrime(potentialPrime);
    }
    
    // overloading isPrime method
    public static boolean isPrime(int potentialPrime) {
        if (potentialPrime == 0 || potentialPrime == 1) {
            return false;
        }
        else {
            for (int i = 2; i < potentialPrime/2; i++) {
                if (potentialPrime % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
//    public boolean isPrime() {
//        if (this.number == 0) {
//            return false;
//        }
//        else if (this.number == 1) {
//            return false;
//        }
//        else {
//            for (int i = 2; i < this.number/2; i++) {
//                if (this.number % i == 0) {
//                    return false;
//                }
//            }
//        }
//        return true; // if number is not 0 or 1 and none of the numbers between 2 and number/2 is a factor, 
//                    // the number must be prime.
//    }
    
    public ArrayList<Integer> computePrimeFactors() {
        // compute prime factors and put them into an arraylist
        int numberToFactorize = this.number;
        ArrayList<Integer> factorsList = new ArrayList<>();
        for (int i = 2; i < (numberToFactorize/2 + 1); i++) {
            if ((numberToFactorize % i == 0) && Number.isPrime(i))  {
                factorsList.add(i);
            }
        }
        if (this.isPrime()) {
            factorsList.add(this.number);
        }
        
        return factorsList;
    }
    
    // *****************
    // REFACT this actually belongs to another class:
    public static int[] firstPrimeFactors(int howMany) {
        int[] primeFactors;
        primeFactors = new int[howMany];
        // fill array with first howMany prime factors
        return primeFactors;
    }
    
}
