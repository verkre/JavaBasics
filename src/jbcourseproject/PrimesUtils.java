
package jbcourseproject;

import java.util.ArrayList;

/**
 * This class contains several (static) helper methods for computing or checking primes.
 */
public class PrimesUtils {
    
    /**
     * Checks numbers up to Integer.MAX_VALUE for primeness.
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
     * Checks a number for primeness.
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
     * Checks numbers up to Integer.MAX_VALUE.
     * Takes a list of all primes below the number it checks and uses it to make the checking faster
     * @param potentialPrime, allPrimesUptToPotentialPrime
     * @return true if argument is prime
     */
    public static boolean isPrime(int potentialPrime, ArrayList<Integer> allPrimesUptToPotentialPrime) {
        for (Integer prime : allPrimesUptToPotentialPrime) {
            if (potentialPrime % prime == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Computes all prime factors of a number.
     * @param numberToFactorize
     * @return an ArrayList<Long>.
     */
    public static ArrayList<Long> computePrimeFactors(long numberToFactorize) {
        // optimization: we only check potential factors up to Sqrt(numberToFactorize)
        // (and the number itself after the for loop in case it is a prime)
        ArrayList<Long> factorsList = new ArrayList<>();
        for (long i = 2; i * i <= numberToFactorize; i++) {
            if ((numberToFactorize % i == 0) && PrimesUtils.isPrime(i))  {
                factorsList.add(i);
                numberToFactorize /= i;
            }
        }
        if (PrimesUtils.isPrime(numberToFactorize)) {
            factorsList.add(numberToFactorize);
        }
        return factorsList;
    }
    
    /**
     * Computes the largest prime factor of a number. 
     * @param numberToFactorize
     * @return the largest prime factor
     */
    public static long findLargestPrimeFactor(long numberToFactorize) {
        long largestPrimeFactor = 1;
        // check potential factors (optimized to be a lot faster than just checking each number up to numberToFactorize/2)
        for (long i = 2; i * i <= numberToFactorize; i++) {
            if ((numberToFactorize % i == 0) && PrimesUtils.isPrime(i)) {
                largestPrimeFactor = i;
                numberToFactorize /= i;
            }
        }
        // if the number we have left after the for loop is prime (or numberToFactorize is itself prime), add it as a factor
        if (PrimesUtils.isPrime(numberToFactorize)) {
            largestPrimeFactor = numberToFactorize;
        }
        return largestPrimeFactor;
    }

    /**
     * Computes a list of primes up to the given upper Bound.
     * @param upperBound
     * @return An ArrayList of primes.
     */
    public static ArrayList<Integer> listPrimesBelow(int upperBound) {
        ArrayList<Integer> primeList = new ArrayList<>();
        if (upperBound == 2) {
            return primeList;
            // empty list; there are no primes smaller than 2
        }
        primeList.add(2);
        if (upperBound == 3) {
            return primeList;
        }
        // if upperBound is larger than 3, check every odd number up to upperBound and add it if it is prime.
        for (int i = 3; i < upperBound; i += 2) {
            if (PrimesUtils.isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }


    /**
     * Computes a list of primes of a given length.
     * @param howMany
     * @return An ArrayList of primes.
     */
    public static ArrayList<Integer> listFirstNPrimes(int howMany) {
        ArrayList<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        int potentialNextPrime = 3;
        // check every odd number and add it if it is prime until we have found howMany primes.
        while (primeList.size() < howMany) {
            if (PrimesUtils.isPrime(potentialNextPrime)) {
                primeList.add(potentialNextPrime);
            }
            potentialNextPrime += 2;
        }
        return primeList;
    }
    
    
}
