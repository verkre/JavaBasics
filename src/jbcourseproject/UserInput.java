package jbcourseproject;

import java.util.InputMismatchException;

/**
 * This class has several methods to ask the user for input (numbers), giving either 
 * just a lower or a lower and an upper bound.
 */
public class UserInput {
    // these constants are used to prompt the user if they enter a too-large number.
    public static final int MAX_INT = Integer.MAX_VALUE;
    public static final long MAX_LONG = Long.MAX_VALUE;
    
    public UserInput() {
    }
    
    public long askInputLongInt(long lowerBound) {
        System.out.printf("Please type a number (" + lowerBound + " or greater). > ");
        long inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextLong();
            } catch(InputMismatchException inputNotLong) {
                System.out.print("That was not an integer. Please type an integer between " + lowerBound + " and " + MAX_LONG + ". > ");
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
    
    public int askInputInteger(int lowerBound) {
        System.out.printf("Please type a number (%d or greater). > ", lowerBound);
        int inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextInt();
            } catch(InputMismatchException inputNotInteger) {
                System.out.printf("That was not an integer. Please type an integer between %d and %d. > ", lowerBound, MAX_INT);
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
    
    // TODO Could or should this be a utility class? There is really no need for these methods to be non-static, is there?
    // Decided to keep it this way for now.

}
