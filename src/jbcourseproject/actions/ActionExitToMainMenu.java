package jbcourseproject.actions;


/**
 * Exit the sub-menu to go back to the main menu
 */
public class ActionExitToMainMenu extends Action {
    public ActionExitToMainMenu() {
        super("Back to main menu");
    }

    @Override
    public void execute() {
        // this method is never used, but has to be here because of Executable interface inherited from Action.
    }

}
