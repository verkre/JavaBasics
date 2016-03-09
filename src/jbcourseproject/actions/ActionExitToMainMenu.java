package jbcourseproject.actions;


/**
 * Sub-menu item/action: Exit the sub-menu to go back to the main menu.
 */
public class ActionExitToMainMenu extends Action {
    public ActionExitToMainMenu() {
        super("Back to main menu", "Back to main menu");
    }

    @Override
    public void execute() {
        // this method is never used, but has to be here because of the Executable interface inherited from Action.
    }

}
