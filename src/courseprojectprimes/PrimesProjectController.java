package courseprojectprimes;

import courseprojectprimes.actions.*;
import java.util.ArrayList;

public class PrimesProjectController {
    // TODO accept command line arguments?
    // 
    
    // **********
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
        // -- problem 50: add sub-lists of prime list and check result for primeness (possibly optimize that to make it faster)
        
        while (true) {
            UserInput.displayAndChooseFromMenu(collectActionObjects());
        }
        
        
    }

    // is-a
    // has-a
    // knows how to
    // - display different menus (main, sub), optionally getting the menu items from the controller (?)
    // - ask the user for an input
    // - check user input for validity and return it to the controller
    public static ArrayList<ActionObject> collectActionObjects() {
        // get the descriptions from each action object, collect them in an ArrayList
        ArrayList<ActionObject> availableActionObjects = new ArrayList<>();
        availableActionObjects.add(new ActionObjectExit());
        availableActionObjects.add(new ActionObjectCheckPrime());
        availableActionObjects.add(new ActionObjectListPrimeFactors());
        availableActionObjects.add(new ActionObjectListPrimes());
        availableActionObjects.add(new ActionObjectEulerProblems());
        return availableActionObjects;
    }
    
}
