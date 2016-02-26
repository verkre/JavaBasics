package courseprojectprimes;

import courseprojectprimes.actions.ActionObjectCheckPrime;
import courseprojectprimes.actions.ActionObjectEulerProblems;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class UserInput {
    // is-a
    // has-a
    // knows how to
    // - display different menus (main, sub), optionally getting the menu items from the controller (?)
    // - ask the user for an input
    // - check user input for validity and return it to the controller
    
    public static ArrayList<String> collectMainMenuItems() {
        // get the descriptions from each action object, collect them in an ArrayList
        ArrayList<String> mainMenuItems = new ArrayList<>();
        
        // REFACT? now we instantiate an object from each action object class just to read
        // their descriptions. Would it be better to give the action objects an (additional)
        // static getDescription() method?
        // TODO wouldn't it be better if the UserInput class got these action objects
        // from the (main) controller somehow? So the action objects do not have to be
        // hard coded into the UserInput class? i.e. where should the information about
        // the available action objects live?
        // what I would like to do: 
        // take an ArrayList of all available action objects as an argument, then call 
        // the respective getDescription() method on each of them and return a list
        // of all the descriptions. But when I try that the getDescription() method of
        // the superclass is called. 
        ActionObjectCheckPrime aoCheckPrime = new ActionObjectCheckPrime();
        ActionObjectEulerProblems aoEulerProblems = new ActionObjectEulerProblems();
        
//        ArrayList<ActionObject> availableActionObjects = new ArrayList<>();
        mainMenuItems.add(aoCheckPrime.getDescription());
        mainMenuItems.add(aoEulerProblems.getDescription());
        
//        for (ActionObject actionObject : availableActionObjects) {
//            mainMenuItems.add(actionObject.getActionObjectDescription());
//        }

        return mainMenuItems;
    }
    
    public static void displayMainMenuNew() {
//        System.out.println("These are the main menu entries that have an action object so far:");
        ArrayList<String> mainMenuItems = collectMainMenuItems();
        mainMenuItems.add(0, "Exit");
//        System.out.println(mainMenuItems.toString());
//        return;
        for (int i = 0; i < mainMenuItems.size(); i++) {
            // print number and description
            System.out.printf("%d - " + mainMenuItems.get(i) + "%n", i);
        }
        
        int userChoice = UserInput.askInputNumber(0, mainMenuItems.size() - 1);
        System.out.printf("You chose menu item %d. Exiting now...", userChoice);
        System.exit(0);
    }
    
    public static int chooseMainMenu() {
        System.out.println("What do you want to do? Please enter a number:");
        int userChoice;
        while (true) {
            ActionObjectCheckPrime aoCheckPrime = new ActionObjectCheckPrime();
            ActionObjectEulerProblems aoEulerProblems = new ActionObjectEulerProblems();
            System.out.println("1 - " + aoCheckPrime.getDescription());
            System.out.println("2 - compute the prime factors of a number");
            System.out.println("3 - compute a list of prime numbers");
            System.out.println("4 - " + aoEulerProblems.getDescription());
            System.out.println("5 - solve a problem from Project Euler that has nothing to do with primes");
            System.out.println("0 - exit");
            System.out.print("> ");
            // REFACT extract each menu item into a class (action object?) that has a
            // description method that returns a string.
            // the controller gives chooseMainMenu() an array of these and has it ask the user which of them to execute
            // all of these can implement the action object interface 
            // and/or inherit from the action object superclass
            // action object has a doIt method (that is overwritten in each subclass)
            // **action object factory!!!!**
            
            userChoice = UserInput.askInputNumber(0, 5);

            if (userChoice >= 0 && userChoice <= 5) {
                return userChoice;
            }
            else {
                System.out.println("Invalid input. Please enter one of these numbers (0 to exit):");
            }
        }
    }
    
    public static int chooseEulerProblem() {
        System.out.println("Right now, I can only do problem 7 from Project Euler. Please choose one option:");
        int userChoice;
        while (true) {
            System.out.println("7 - show me the answer to problem 7 (10001st prime)");
            System.out.println("0 - no thanks");
            System.out.print("> ");
        
        
            try {
                userChoice = new java.util.Scanner(System.in).nextInt();
            }
            catch (InputMismatchException inputNotInteger) {
                System.out.println("Invalid input. Please enter one of these numbers (0 to exit):");
                continue;
            }

            if (userChoice == 0) {
//                System.out.println("Exiting...");
//                System.exit(0);
                return userChoice; // to return to main menu instead of exiting right away
            }
            else if (userChoice == 7) {
                return userChoice;
            }
            else {
                System.out.println("Invalid input. Please enter one of these numbers (0 to exit):");
            }
        }
    }
    
    // TODO change this method to accept larger numbers
    // using Integer or BigInteger class
    // is it better to just use the biggest possible class (BigInteger) for all
    // integer objects, or should I try to store the input as int or long before
    // resorting to BigInteger?
    // or maybe try to cast it to a smaller type before making the calculations and iterations?
    
    public static int askInputNumber(int lowerBound, int upperBound) { // TODO change this to be non-static?
        System.out.printf("Please type a number between %d and %d. > ", lowerBound, upperBound);
        int inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextInt();
            } catch(InputMismatchException inputNotInteger) {
                System.out.printf("That was not an integer. Please enter an integer between %d and %d. > ", lowerBound, upperBound);
                continue;
            }
            if (inputNumber >= lowerBound && inputNumber <= upperBound) {
                return inputNumber;
            }
            else {
                System.out.printf("Invalid input. Please enter a number between %d and %d. > ", lowerBound, upperBound);
            }
        }
    }
    
    public static int askInputNumber(int lowerBound) {
        System.out.printf("Please type a number (%d or greater). > ", lowerBound);
        int inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextInt();
            } catch(InputMismatchException inputNotInteger) {
                System.out.printf("That was not an integer. Please type an integer (%d or greater). > ", lowerBound);
                continue;
            }
            if (inputNumber >= lowerBound) {
                return inputNumber;
            }
            else {
                System.out.printf("Invalid input. Number must be at least %d. > ", lowerBound);
            }
        }
    }

    // replaced by more generic askInputNumber method
//    public static int getHowMany() {
//        System.out.print("How many entries do you want the list to have? > ");
//        while (true) {
//            int howMany = new java.util.Scanner(System.in).nextInt();
//            if (howMany >= 0) {  // add check to see if number is not too large
//                return howMany;
//            }
//            else {
//                System.out.print("Invalid input. Please enter a non-negative integer. > ");
//            }
//        }
//    }

    public static int askUpperBound() {
        System.out.print("Input an upper bound for the list of primes > ");
        while (true) {
            int upperBound = new java.util.Scanner(System.in).nextInt();
            if (upperBound > 2) {  // add check to see if number is not too large
                return upperBound;
            }
            else {
                System.out.print("Invalid input. There are no primes smaller than 2. > ");
            }
        }
    }
    
    // REFACT replace these 3 number-getting methods by just one that accepts the desired
    // min and max value as arguments.

}
