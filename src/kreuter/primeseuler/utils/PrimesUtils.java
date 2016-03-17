
package kreuter.primeseuler.utils;

import java.util.ArrayList;

/**
 * This class contains several (static) helper methods for computing or checking primes.
 */
public final class PrimesUtils {
    
    private PrimesUtils() {}
    
    /**
     * Checks numbers up to Integer.MAX_VALUE for primeness.
     * @param potentialPrime a non-negative integer
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
     * @param potentialPrime a non-negative integer
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
     * @param potentialPrime a non-negative integer
     * @param allPrimesUptToPotentialPrime an ArrayList of all primes up to potentialPrime
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
     * @param numberToFactorize a non-negative integer (2 or greater)
     * @return an ArrayList of prime factors
     */
    public static ArrayList<Long> computePrimeFactors(long numberToFactorize) {
        // optimization: we only check potential factors up to Sqrt(numberToFactorize)
        // (and the number itself after the for loop in case it is a prime)
        ArrayList<Long> factorsList = new ArrayList<>();
        for (long i = 2L; i * i <= numberToFactorize; i++) {
            if ((numberToFactorize % i == 0) && PrimesUtils.isPrime(i)) {
                if (!factorsList.contains(i)) {
                    factorsList.add(i);
                }
                numberToFactorize /= i;
                i -= 1;
            }
        }
        if (!factorsList.contains(numberToFactorize) && PrimesUtils.isPrime(numberToFactorize)) {
            factorsList.add(numberToFactorize);
        }
        return factorsList;
    }
    
    /**
     * Computes the largest prime factor of a number. 
     * @param numberToFactorize an integer greater than 1
     * @return the largest prime factor
     */
    public static long findLargestPrimeFactor(long numberToFactorize) {
        long largestPrimeFactor = 1;
        // check potential factors (optimized to be a lot faster than just checking each number up to numberToFactorize/2)
        for (long i = 2; i * i <= numberToFactorize; i++) {
            if ((numberToFactorize % i == 0) && PrimesUtils.isPrime(i)) {
                largestPrimeFactor = i;
                numberToFactorize /= i;
                i -= 1;
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
     * @param upperBound an integer greater than 1
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

    public static ArrayList<Long> listPrimesBelow(long upperBound) {
        ArrayList<Long> primeList = new ArrayList<>();
        if (upperBound == 2) {
            return primeList;
            // empty list; there are no primes smaller than 2
        }
        primeList.add(2L);
        if (upperBound == 3) {
            return primeList;
        }
        // if upperBound is larger than 3, check every odd number up to upperBound and add it if it is prime.
        for (long i = 3; i < upperBound; i += 2) {
            if (PrimesUtils.isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }


    /**
     * Computes a list of primes of a given length.
     * @param howMany a non-negative integer
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
    
        public static ArrayList<Long> listFirstNPrimes(long howMany) {
        ArrayList<Long> primeList = new ArrayList<>();
        primeList.add(2L);
        long potentialNextPrime = 3L;
        // check every odd number and add it if it is prime until we have found howMany primes.
        while (primeList.size() < (int) howMany) {
            if (PrimesUtils.isPrime(potentialNextPrime)) {
                primeList.add(potentialNextPrime);
            }
            potentialNextPrime += 2;
        }
        return primeList;
    }

    
}
