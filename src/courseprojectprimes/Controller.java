package courseprojectprimes;

import courseprojectprimes.actions.*;
import java.util.ArrayList;

public class Controller {
    // TODO make it work for bigger numbers (use BigInteger class)
    
    public static void main(String[] args) {
        // possible PE problems that have to do with primes:
        // -- problem 3: first get methods to handle (very) large numbers
        // -- problem 10: method to find all primes up to upperBound (first, learn to handle large numbers)
        // -- problem 35: iterate over list of primes, permutate numbers (convert to string and back?) then check for primeness
        // -- problem 41: permutations of 9 (8..) digits, check for primeness and find largest
        // -- problem 49: ...
        // -- problem 50: add up sub-lists of prime list and check result for primeness (possibly optimize that to make it faster)
        
        MenuInterface mainMenuInterface = new MenuInterface(collectActionObjects());
        while (true) {
            mainMenuInterface.displayAndChooseFromMenu();
        }
    }

    public static ArrayList<Action> collectActionObjects() {
        // make an instance from each ActionObject class, collect them in an ArrayList
        // to pass them as an argument to the main menu method in the MenuInterface class
        ArrayList<Action> availableActionObjects = new ArrayList<>();
        availableActionObjects.add(new ActionExit());
        availableActionObjects.add(new ActionCheckPrime());
        availableActionObjects.add(new ActionListPrimeFactors());
        availableActionObjects.add(new ActionListPrimes());
        availableActionObjects.add(new ActionEulerProblems());
        return availableActionObjects;
    }
    
}
