package kreuter.primeseuler.exceptions;

/**
 * If GUI programmer fails to check validity first and Action gets invalid input, this exception is thrown.
 * @author Vera Kreuter
 */
public class InvalidInputException extends RuntimeException {
    
    public InvalidInputException() {
        super("Input is invalid. Use the Action's isValidInput() method to check your input before trying to set its input number.");
    }
    
}
