package kreuter.primeseuler.actions;

/**
* This is a superclass for all actions/options that can show up in a menu (main menu or sub-menu).
* For putting an action in a menu, we need a description with a getter method 
* and an execute() method (which is defined in the Executable interface).
*/
public abstract class Action implements ExecutableTUI, ExecutableGUI {
    
    private String title;
    private String description;
    private boolean needsInputNumber;
    
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
    
    public abstract void setInputNumber(Long newInputNumber);
    
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
    
    public boolean isValidInput(Long inputNumber) {
        return false;
        // some actions don't need input; this might as well return false in those
        // cases so there is no need to implement this method in each action,
        // just override it where input within specific bounds is needed.
    }
    
    public Long getLowerInputBound() {
        return 0L;
        // this is overridden in actions that actually need an input
    }
    
}
