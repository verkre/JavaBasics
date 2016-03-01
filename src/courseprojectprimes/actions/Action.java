package courseprojectprimes.actions;

/**
* This is a superclass for all actions/options that can show up in a menu (main menu or sub-menu).
* For putting an action in a menu, we need a description with a getter method 
* and an execute() method (which is defined in the Executable interface).
*/
public abstract class Action implements Executable {
    
    private String description;
    
    public Action() {
        description = giveDescription();
    }
    
    protected abstract String giveDescription();
    
    public String getDescription() {
        return description;
        
        // TODO overwrite getDescription method in each subclass, have it return the string directly
        // getDescription to Executable interface, or make it abstract here?
    }
    
}
