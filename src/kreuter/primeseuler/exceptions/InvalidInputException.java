/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.exceptions;

/**
 *
 * @author Vera Kreuter
 */
public class InvalidInputException extends RuntimeException {
    
    // If GUI programmer fails to check
    // validity first and Action gets invalid input, throw this exception
    public InvalidInputException() {
        super("Input is invalid. Use the Action's isValidInput() method to check your input before trying to set its input number.");
    }
    
    
}
