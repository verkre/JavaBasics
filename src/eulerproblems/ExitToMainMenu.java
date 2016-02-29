/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblems;

import courseprojectprimes.MenuInterface;
import courseprojectprimes.actions.Action;

/**
 *
 * @author Vera Kreuter
 */
public class ExitToMainMenu extends Action {
    
    @Override
    public String giveDescription() {
        return "Exit (returning to main menu doesn't work yet, sorry)";
    }
    
    @Override
    public void execute() {
//        System.exit(0);
        // TODO How can I go back to the main menu from here?
    }
}
