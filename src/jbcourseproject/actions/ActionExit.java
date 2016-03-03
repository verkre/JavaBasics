package jbcourseproject.actions;

/**
 * Main menu item/action: Exit the program.
 */
public class ActionExit extends Action {

    public ActionExit() {
        super("Exit");
    }
    
    @Override
    public void execute() {
        System.exit(0);
    }
    
    
}
