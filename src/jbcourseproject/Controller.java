package jbcourseproject;

import jbcourseproject.actions.*;
import java.util.ArrayList;
import jbcourseproject.userinterface.ViewGUI;
import jbcourseproject.userinterface.ViewTUI;

public class Controller {
    
    public static void main(String[] args) {
//        ViewTUI viewTUI = new ViewTUI(new Controller().collectActionObjects());
        ViewGUI viewGUI = new ViewGUI(new Controller().collectActionObjects(), new ActionEulerProblems().collectEulerProblems());
        viewGUI.go();
        // TODO let the ViewGUI or ViewTUI start the program (= put main methods there)
    }
    
    /**
     * Collect all Actions that should appear in the main menu in an ArrayList.
     * @return an ArrayList of Action objects
     */
    public ArrayList<Action> collectActionObjects() {
        // these are only instantiated once at the start of the program - so there is no need to declare them as 
        // class attributes (as with the EulerProblem objects in the sub-menu)
        ArrayList<Action> availableActionObjects = new ArrayList<>();
        availableActionObjects.add(new ActionExit());
        availableActionObjects.add(new ActionCheckPrime());
        availableActionObjects.add(new ActionListPrimeFactors());
        availableActionObjects.add(new ActionListPrimes());
        availableActionObjects.add(new ActionListPrimesBelow());
        availableActionObjects.add(new ActionEulerProblems());
        return availableActionObjects;
    }
    
    // TODO
        // possible PE problems that have to do with primes:
        // -- problem 10: method to find all primes up to upperBound (first, learn to handle large numbers)
        // -- problem 35: iterate over list of primes, permutate numbers (convert to string and back?) then check for primeness
        // -- problem 41: permutations of 9 (8..) digits, check for primeness and find largest
        // -- problem 49: 
        // -- problem 50: add up sub-lists of prime list and check result for primeness

}
