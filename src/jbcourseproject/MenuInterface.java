package jbcourseproject;

import jbcourseproject.actions.Action;
import jbcourseproject.actions.ActionExitToMainMenu;
import java.util.ArrayList;

public class MenuInterface {
    
    private ArrayList<Action> menuItems;
    
    public MenuInterface(ArrayList<Action> availableMenuItems) {
        this.menuItems = availableMenuItems;
    }
    
    /**
     * Displays descriptions of available menu items, lets user choose one and calls its execute method.
     * @return false if the user chose the exit-to-main-menu option, true otherwise
     */
    public boolean displayAndChooseFromMenu() {
        System.out.println("\n");
        // print a newline before the menu because it looks better
        for (int i = 0; i < this.menuItems.size(); i++) {
            System.out.printf("%d - " + this.menuItems.get(i).getDescription() + "%n", i);
        }
        int userChoice = new UserInput().askInputInteger(0, this.menuItems.size() - 1);
        
        // to return to main menu: return false if user chose the exit option (= exit object)
        if (this.menuItems.get(userChoice) instanceof ActionExitToMainMenu) {
            return false;
        }
        this.menuItems.get(userChoice).execute();
        return true;
    }
    
    
   
    
    
    // TODO change this method to accept larger numbers
    // using BigInteger class
    // is it better to just use the biggest possible class (BigInteger) for all
    // integer objects, or should I try to store the input as int or long before
    // resorting to BigInteger?
    // or maybe try to cast it to a smaller type before making the calculations and iterations?
//    
//    public int askInputInteger(int lowerBound, int upperBound) { // TODO change this to be non-static?
//        System.out.printf("Please type a number between %d and %d. > ", lowerBound, upperBound);
//        int inputNumber;
//        while (true) {
//            try {
//                inputNumber = new java.util.Scanner(System.in).nextInt();
//            } catch(InputMismatchException inputNotInteger) {
//                System.out.printf("That was not an integer. Please enter an integer between %d and %d. > ", lowerBound, upperBound);
//                continue;
//            }
//            if (inputNumber >= lowerBound && inputNumber <= upperBound) {
//                return inputNumber;
//            }
//            else {
//                System.out.printf("Invalid input. Please enter a number between %d and %d. > ", lowerBound, upperBound);
//            }
//        }
//    }
//    
//    public static int askInputInteger(int lowerBound) {
//        System.out.printf("Please type a number (%d or greater). > ", lowerBound);
//        int inputNumber;
//        while (true) {
//            try {
//                inputNumber = new java.util.Scanner(System.in).nextInt();
//            } catch(InputMismatchException inputNotInteger) {
//                System.out.printf("That was not an integer. Please type an integer (%d or greater). > ", lowerBound);
//                continue;
//            }
//            if (inputNumber >= lowerBound) {
//                return inputNumber;
//            }
//            else {
//                System.out.printf("Invalid input. Number must be at least %d. > ", lowerBound);
//            }
//        }
//    }
    
}
