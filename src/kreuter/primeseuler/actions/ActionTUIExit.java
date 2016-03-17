package kreuter.primeseuler.actions;

/**
 * Main menu item/action: Exit the program.
 */
public class ActionTUIExit extends Action {
    
    private Long inputNumber = null;

    public ActionTUIExit() {
        super("Exit", "Exit", false);
    }
    
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getInfoText() {
        return "...";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        // do nothing
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
