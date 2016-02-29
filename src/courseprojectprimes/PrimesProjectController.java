package courseprojectprimes;

import courseprojectprimes.actions.*;
import java.util.ArrayList;

public class PrimesProjectController {
    // TODO make it work for bigger numbers (use BigInteger class)
    
    public static void main(String[] args) {
        // ask user what they want to do:
        // - check if a number is prime
        // - compute prime factors of a number
        // - view a list of the first n primes
        // - view a list of all primes below n
        // - view the solution to PE Problem x, y, or z (all to do with primes)
        // -- problem 3: first get methods to handle (very) large numbers
        // -- problem 10: method to find all primes up to upperBound (first, learn to handle large numbers)
        // -- problem 35: iterate over list of primes, permutate numbers (convert to string and back?) then check for primeness
        // -- problem 41: permutations of 9 (8..) digits, check for primeness and find largest
        // -- problem 49: ...
        // -- problem 50: add up sub-lists of prime list and check result for primeness (possibly optimize that to make it faster)

        while (true) {
            UserInput.displayAndChooseFromMenu(collectActionObjects());
        }
        
    }

    public static ArrayList<ActionObject> collectActionObjects() {
        // make an instance from each ActionObject class, collect them in an ArrayList
        // to pass them as an argument to the main menu method in the UserInput class
        ArrayList<ActionObject> availableActionObjects = new ArrayList<>();
        availableActionObjects.add(new ActionObjectExit());
        availableActionObjects.add(new ActionObjectCheckPrime());
        availableActionObjects.add(new ActionObjectListPrimeFactors());
        availableActionObjects.add(new ActionObjectListPrimes());
        availableActionObjects.add(new ActionObjectEulerProblems());
        return availableActionObjects;
    }
    
}
