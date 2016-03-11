package jbcourseproject.actions;

import jbcourseproject.UserInput;
import jbcourseproject.PrimesUtils;
import java.util.ArrayList;

/**
 * Main menu item/action: Ask the user for a number and print a list of all primes smaller than that number.
 */
public class ActionListPrimesBelow extends Action {
    
    private Long inputNumber;
    
    public ActionListPrimesBelow() {
        super("Primes up to n", "compute all prime numbers smaller than a certain number", true);
    }
    
    @Override
    public void execute() {
        int upperBound = new UserInput().askInputInteger(1);
        ArrayList<Integer> primeList = PrimesUtils.listPrimesBelow(upperBound);
        System.out.printf("Here is a list of all primes smaller than %d: %n", upperBound);
        System.out.println(primeList);
    }
    
    public String getSolutionString() {
        return "Here is a list of all primes smaller than " + inputNumber + ":\n"
                + PrimesUtils.listPrimesBelow(inputNumber);
    }
    
    @Override
    public String getInfoText() {
        return "...";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        this.inputNumber = newInputNumber;
    }
}
