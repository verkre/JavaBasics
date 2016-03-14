package kreuter.primeseuler.actions;

/**
* This is a superclass for all actions/options that can show up in a menu (main menu or sub-menu).
* For putting an action in a menu, we need a description with a getter method 
* and an execute() method (which is defined in the Executable interface).
*/
public abstract class Action implements Executable {
    
    private String title;
    private String description;
    private String infoText;
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
    
    public abstract String getInfoText();
    public abstract String getSolutionString();
    public abstract void setInputNumber(Long newInputNumber);
    
    @Override
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
    
    
}
