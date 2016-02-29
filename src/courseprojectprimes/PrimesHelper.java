
package courseprojectprimes;

import java.util.ArrayList;

/**
 *
 * @author Vera Kreuter
 */
public class PrimesHelper {
    
    // TODO rewrite these methods to work for long integers (or overload)    

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
            for (int i = 2; i < potentialPrime/2; i++) {
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
    
    public static ArrayList<Integer> computePrimeFactors(int numberToFactorize) {
        // optimization: we only check potential factors up to (number/2 + 1)
        // (and the number itself after the for loop in case it is a prime)
        ArrayList<Integer> factorsList = new ArrayList<>();
        for (int i = 2; i < (numberToFactorize/2 + 1); i++) {
            if ((numberToFactorize % i == 0) && PrimesHelper.isPrime(i))  {
                factorsList.add(i);
            }
        }
        if (PrimesHelper.isPrime(numberToFactorize)) {
            factorsList.add(numberToFactorize);
        }
        return factorsList;
    }

    public static ArrayList<Integer> listPrimesBelow(int upperBound) {
        ArrayList<Integer> primeList = new ArrayList<>();
        if (upperBound <= 2) {
            return primeList;
            // empty list; there are no primes smaller than 2
        }
        primeList.add(2);
        if (upperBound <= 3) {
            return primeList;
            // 2 is the only even prime and we only check odd numbers in the following loop
        }
        int potentialNextPrime = 3;
        while (potentialNextPrime < upperBound) {
            if (PrimesHelper.isPrime(potentialNextPrime, primeList)) {
                primeList.add(potentialNextPrime);
            }
            potentialNextPrime += 2;
        }
        return primeList;
    }


    /**
     * accepts positive (non-zero) integers as input.
     * @param howMany
     * @return a list of the first howMany primes
     */
    public static ArrayList<Integer> listFirstNPrimes(int howMany) {
        ArrayList<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        int potentialNextPrime = 3;
        whileLoop:
        while (primeList.size() < howMany) {
            // check if potentialPrime is divisible by a prime we already found
            for (Integer foundPrime : primeList) {
                if (potentialNextPrime % foundPrime == 0) {
                    potentialNextPrime += 2;
                    continue whileLoop;
                    // not a prime, stop checking the list, i.e. jump out of the for loop
                }
            }
            // if the for-loop ran through we have a new prime.
            primeList.add(potentialNextPrime);
            potentialNextPrime += 2;
        }
        return primeList;
    }
    
    
}
