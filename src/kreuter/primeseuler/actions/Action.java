package kreuter.primeseuler.actions;

import kreuter.primeseuler.interfaces.ExecutableGUI;
import kreuter.primeseuler.interfaces.ExecutableTUI;
import kreuter.primeseuler.utils.Logger;
import kreuter.primeseuler.exceptions.InvalidInputException;

/**
* This is a superclass for all actions/options that can show up in a menu (main menu or sub-menu).
* For putting an action in a menu, we need a description with a getter method 
* and an execute() method (which is defined in the Executable interface).
*/
public abstract class Action implements ExecutableTUI, ExecutableGUI {
    
    private String title;
    private String description;
    private boolean needsInputNumber;
    private Long inputNumber;
    
    public Action(String title, String description, boolean needsInput) {
        this.title = title;
        this.description = description;
        this.needsInputNumber = needsInput;
        // each subclass calls the superclass constructor with its own description string
        // as an argument. (As a way to keep the description attribute private, yet allow each 
        // subclass to set it to its own string).
    }
    
   public boolean needsInputNumber() {
       return needsInputNumber;
   }
        
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getTitle();
    }
    
    @Override
    public void execute() {
        System.out.println(getSolutionString());
    }
    
    public boolean isValidInput(Long inputNumber) {
        throw new UnsupportedOperationException("Override me if this class really needs input");
    }
    
    public Long getLowerInputBound() {
        throw new UnsupportedOperationException("Override me if this class really needs input");
    }

    public Long getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(Long newInputNumber) throws InvalidInputException {
        if (isValidInput(newInputNumber)) {
            this.inputNumber = newInputNumber;
        } else {
            throw new InvalidInputException();
        }
    }
    
    public void writeToLogFile() {
        if (inputNumber == null) {
            Logger.writeToLogFile(getTitle() + " / No input");
        } else {
            Logger.writeToLogFile(getTitle() + " / Input: " + inputNumber);
        }
    }
}
