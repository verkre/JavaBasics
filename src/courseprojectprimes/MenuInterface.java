package courseprojectprimes;

import courseprojectprimes.actions.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MenuInterface {
    
    private ArrayList<Action> menuItems;
    
    public MenuInterface() {
    }
    
    public MenuInterface(ArrayList<Action> availableMenuItems) {
        this.menuItems = availableMenuItems;
    }
    
    public void displayAndChooseFromMenu() {
        System.out.println("\n");
        // print a newline before the menu because it looks better
        for (int i = 0; i < this.menuItems.size(); i++) {
            System.out.printf("%d - " + this.menuItems.get(i).getDescription() + "%n", i);
        }
        int userChoice = new UserInput().askInputNumber(0, this.menuItems.size() - 1);
        this.menuItems.get(userChoice).execute();
    }
    
    
   
    
    
    // TODO change this method to accept larger numbers
    // using BigInteger class
    // is it better to just use the biggest possible class (BigInteger) for all
    // integer objects, or should I try to store the input as int or long before
    // resorting to BigInteger?
    // or maybe try to cast it to a smaller type before making the calculations and iterations?
//    
//    public int askInputNumber(int lowerBound, int upperBound) { // TODO change this to be non-static?
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
//    public static int askInputNumber(int lowerBound) {
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
