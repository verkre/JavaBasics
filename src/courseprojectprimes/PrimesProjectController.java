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
//        UserInput.displayMainMenuNew();
        
        while (true) {
            
        
            int mainMenuChoice = UserInput.chooseMainMenu();


            // REFACT make menu item numbers "dynamic"
            switch (mainMenuChoice) {
                case 0:
                    ActionObjectExit aoExit = new ActionObjectExit();
                    aoExit.go();
                    break;
                case 1:
                    ActionObjectCheckPrime aoCheckPrime = new ActionObjectCheckPrime(); // instantiating action object
                    aoCheckPrime.go(); 
                    break;
                case 2:
                    ActionObjectListPrimeFactors aoPrimeFactors = new ActionObjectListPrimeFactors();
                    aoPrimeFactors.go();
                    break;
                case 3:
                    ActionObjectListPrimes aoListPrimes = new ActionObjectListPrimes();
                    aoListPrimes.go();
                    break;
                case 4:
                case 5:
                    ActionObjectEulerProblems aoEulerProblems = new ActionObjectEulerProblems();
                    aoEulerProblems.go();
                    break;

            }
            
        }
    }
    
}
