package kreuter.primeseuler.actions;

import kreuter.primeseuler.database.EulerSolutionsConnector;

/**
 * This object represents the "welcome" screen for the Euler-Problem-Submenu in
 * the GUI. It contains some info on the project and a how-to text that can be displayed
 * in the respective text fields.
 * @author Vera Kreuter
 */
public class ActionGUIWelcomeEp extends Action {
    
    private EulerSolutionsConnector esc;
    
    public ActionGUIWelcomeEp() {
        super("General info", "General info on Project Euler", false);
    }
    
    public ActionGUIWelcomeEp(EulerSolutionsConnector esc) {
        super("General info", "General info on Project Euler", false);
        this.esc = esc;
    }

    @Override
    public String getInfoText() {
        return "Project Euler is a series of challenging mathematical/computer programming problems "
                + "that will require more than just mathematical insights to solve. "
                + "Although mathematics will help you arrive at elegant and efficient methods, "
                + "the use of a computer and programming skills will be required to solve most problems.";
    }

    @Override
    public String getSolutionString() {
        if (esc != null) {
            return "You can display the solutions to some Euler Problems here. Choose one from the list on the left.";
        }
        return "You can display the solutions to some Euler Problems here. Choose one from the list on the left."
                + "\n\n"
                + "There is no connection to the Euler Problems Solutions Database. Some Problems (e.g. 75) will "
                + "take a few minutes to display.";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        
    }

    @Override
    public void execute() {
        
    }
    
}
