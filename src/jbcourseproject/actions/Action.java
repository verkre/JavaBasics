package jbcourseproject.actions;

/**
* This is a superclass for all actions/options that can show up in a menu (main menu or sub-menu).
* For putting an action in a menu, we need a description with a getter method 
* and an execute() method (which is defined in the Executable interface).
*/
public abstract class Action implements Executable {
    
    private String description;
    
    public Action(String description) {
        this.description = description;
//        description = describeSelf();
        // the compiler warns me because I call an overridable method in the constructor.
        // the only alternative I can think of is making the description attribute protected
        // and defining it directly in the constructor of each subclass
    }
    
//    protected abstract String describeSelf();
    
    @Override
    public String getDescription() {
        return description;
        
        // TODO overwrite getDescription method in each subclass, have it return the string directly?
    }
    
}
