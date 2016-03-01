
package courseprojectprimes;

import java.util.ArrayList;

/**
 *
 * @author Vera Kreuter
 */
public class PrimesHelper {
    
    /**
     * can only check numbers up to Integer.MAX_VALUE
     * @param potentialPrime
     * @return true if argument is prime
     */
    public static boolean isPrime(int potentialPrime) {
        if (potentialPrime == 0 || potentialPrime == 1) {
            return false;
        }
        else {
            for (int i = 2; i * i <= potentialPrime; i++) {
                if (potentialPrime % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * can check numbers up to the max value of long
     * @param potentialPrime
     * @return true if argument is prime
     */
    public static boolean isPrime(long potentialPrime) {
        if (potentialPrime == 0 || potentialPrime == 1) {
            return false;
        }
        else {
            for (long i = 2; i * i <= potentialPrime; i++) {
                if (potentialPrime % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * can only check numbers up to Integer.MAX_VALUE.
     * takes a list of all primes below the number it checks for primeness and uses it to make the checking faster
     * @param potentialPrime, allPrimesUptToPotentialPrime
     * @return true if argument is prime
     */
    // overloading static isPrime method
    public static boolean isPrime(int potentialPrime, ArrayList<Integer> allPrimesUptToPotentialPrime) {
        for (Integer prime : allPrimesUptToPotentialPrime) {
            if (potentialPrime % prime == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param numberToFactorize
     * @return an ArrayList<Long> containing all prime factors of the input number
     */
    public static ArrayList<Long> computePrimeFactors(long numberToFactorize) {
        // optimization: we only check potential factors up to Sqrt(numberToFactorize)
        // (and the number itself after the for loop in case it is a prime)
        ArrayList<Long> factorsList = new ArrayList<>();
        for (long i = 2; i * i <= numberToFactorize; i++) {
            if ((numberToFactorize % i == 0) && PrimesHelper.isPrime(i))  {
                factorsList.add(i);
                numberToFactorize /= i;
            }
        }
        if (PrimesHelper.isPrime(numberToFactorize)) {
            factorsList.add(numberToFactorize);
        }
        return factorsList;
    }
    
    /**
     * 
     * @param numberToFactorize
     * @return the largest prime factor of the input number
     */
    public static long findLargestPrimeFactor(long numberToFactorize) {
        long largestPrimeFactor = 1;
        // check potential factors (optimized to be a lot faster than just checking each number up to numberToFactorize/2)
        for (long i = 2; i * i <= numberToFactorize; i++) {
            if ((numberToFactorize % i == 0) && PrimesHelper.isPrime(i)) {
                largestPrimeFactor = i;
                numberToFactorize /= i;
            }
        }
        // if the number we have left is prime (or numberToFactorize is itself prime), add it as a factor
        if (PrimesHelper.isPrime(numberToFactorize)) {
            largestPrimeFactor = numberToFactorize;
        }
        return largestPrimeFactor;
    }

    /**
     * 
     * @param upperBound
     * @return an ArrayList of all primes smaller than input number
     */
    public static ArrayList<Integer> listPrimesBelow(int upperBound) {
        ArrayList<Integer> primeList = new ArrayList<>();
        if (upperBound == 2) {
            return primeList;
            // empty list/ there are no primes smaller than 2
        }
        primeList.add(2);
        if (upperBound == 3) {
            return primeList;
        }
        for (int i = 3; i < upperBound; i += 2) {
            if (PrimesHelper.isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }


    /**
     * accepts positive (non-zero) integers as input.
     * @param howMany
     * @return an ArrayList of the first howMany primes
     */
    public static ArrayList<Integer> listFirstNPrimes(int howMany) {
        ArrayList<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        int potentialNextPrime = 3;
        while (primeList.size() < howMany) {
            if (PrimesHelper.isPrime(potentialNextPrime)) {
                primeList.add(potentialNextPrime);
            }
            potentialNextPrime += 2;
        }
        return primeList;
    }
    
    
}
