/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectprimes;

import java.util.ArrayList;

/**
 *
 * @author Vera Kreuter
 */
public class PrimeList {
//    public int howMany;
//    public PrimeList (int howMany) {
//        this.howMany = howMany;
//    }
    
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
                    continue whileLoop; // not a prime, stop checking the list, i.e. jump out of the for loop
                }
            }
            primeList.add(potentialNextPrime); // if the for-loop ran through we have a new prime.
            potentialNextPrime += 2;
                
            
//            if (Number.isPrime(potentialNextPrime)) {
//                primeList.add(potentialNextPrime); // autoboxing
//                potentialNextPrime += 2; // check only odd numbers
//            }
        }
        return primeList;
    }
    
    public static ArrayList<Integer> listPrimesBelow(int upperBound) {
        ArrayList<Integer> primeList = new ArrayList<>();
        if (upperBound <= 2) {
            return primeList; // empty
        }
        primeList.add(2);
        if (upperBound <= 3) {
            return primeList;
        }
        int potentialNextPrime = 3;
        
        whileLoop:
        while (potentialNextPrime < upperBound) {
            for (Integer foundPrime : primeList) {
                if (potentialNextPrime % foundPrime == 0) {
                    potentialNextPrime += 2;
                    continue whileLoop;
                }
            }
            primeList.add(potentialNextPrime);
            potentialNextPrime += 2;
        }
        return primeList;
    }
}
