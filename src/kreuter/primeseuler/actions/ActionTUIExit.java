package kreuter.primeseuler.actions;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kreuter.primeseuler.database.EulerSolutionsConnector;

/**
 * Main menu item/action: Exit the program.
 */
public class ActionTUIExit extends Action {
    
    private Long inputNumber = null;
    private EulerSolutionsConnector esc;

    public ActionTUIExit(EulerSolutionsConnector esc) {
        super("Exit", "Exit", false);
        this.esc = esc;
    }
    
    @Override
    public void execute() {
        if (esc != null) {
            try {
                esc.getConnection().close();
            } catch (SQLException ex) {
                // TODO do something with this exception?
            }
        }
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
