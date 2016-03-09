package jbcourseproject.actions;

/**
* This is a superclass for all actions/options that can show up in a menu (main menu or sub-menu).
* For putting an action in a menu, we need a description with a getter method 
* and an execute() method (which is defined in the Executable interface).
*/
public abstract class Action implements Executable {
    
    private String title;
    private String description;
    // TODO add a title and a getTitle method for display on tabs
    
    public Action(String title, String description) {
        this.title = title;
        this.description = description;
        // each subclass calls the superclass constructor with its own description string
        // as an argument. (As a way to keep the description attribute private, yet allow each 
        // subclass to set it to its own string).
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
}
