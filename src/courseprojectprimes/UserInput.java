/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectprimes;

import java.util.InputMismatchException;

/**
 *
 * @author Vera Kreuter
 */
public class UserInput {
    public UserInput() {
        
    }
    
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
