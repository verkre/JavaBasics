package courseprojectprimes;

import courseprojectprimes.actions.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class UserInput {
    
    
    public static void displayAndChooseFromMenu(ArrayList<ActionObject> availableMenuChoices) {
        for (int i = 0; i < availableMenuChoices.size(); i++) {
            System.out.printf("%d - " + availableMenuChoices.get(i).getDescription() + "%n", i);
        }
        int userChoice = UserInput.askInputNumber(0, availableMenuChoices.size() - 1);
        availableMenuChoices.get(userChoice).go();
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
    // using BigInteger class
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
    
}
