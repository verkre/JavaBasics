package jbcourseproject;

import java.util.InputMismatchException;

/**
 * This class has several methods to ask the user for input (numbers), giving either 
 * just a lower or a lower and an upper bound.
 */
public class UserInput {
    public UserInput() {
        
    }
    
    // there is really no need for these methods to be non-static, is there?
    // Decided to keep it this way for now.
    
    public long askInputLongInt(long lowerBound, long upperBound) {
        System.out.print("Please type a number between " + lowerBound + " and " + upperBound + ". > ");
        long inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextLong();
            } catch(InputMismatchException inputNotLong) {
                System.out.print("That was not an integer. Please type a number between " + lowerBound + " and " + upperBound + ". > ");
                continue;
            }
            if (inputNumber >= lowerBound && inputNumber <= upperBound) {
                return inputNumber;
            }
            else {
                System.out.print("Invalid input. Please type a number between " + lowerBound + " and " + upperBound + ". > ");
            }
        }
    }
    
    public long askInputLongInt(long lowerBound) {
        System.out.print("Please type a number (" + lowerBound + " or greater). > ");
        long inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextInt();
            } catch(InputMismatchException inputNotLong) {
                System.out.print("That was not an integer. Please type an integer (" + lowerBound + " or greater). > ");
                continue;
            }
            if (inputNumber >= lowerBound) {
                return inputNumber;
            }
            else {
                System.out.print("Invalid input. Number must be at least " + lowerBound + ". > ");
            }
        }
    }

    public int askInputInteger(int lowerBound, int upperBound) {
        System.out.print("Please type a number between " + lowerBound + " and " + upperBound + ". > ");
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
    
    public int askInputInteger(int lowerBound) {
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
