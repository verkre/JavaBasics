package kreuter.primeseuler.actions;


/**
 * Sub-menu item/action: Exit the sub-menu to go back to the main menu.
 */
public class ActionTUIExitToMainMenu extends Action {
    
    private Long inputNumber = null;
    
    public ActionTUIExitToMainMenu() {
        super("Back to main menu", "Back to main menu", false);
    }

    @Override
    public void execute() {
        // this method is never used, but has to be here because of the Executable interface inherited from Action.
    }

    @Override
    public String getInfoText() {
        return "...";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
