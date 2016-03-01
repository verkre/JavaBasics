/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectprimes.actions;


/**
 *
 * @author Vera Kreuter
 */
public class ExitToMainMenu extends Action {
    
    @Override
    public String giveDescription() {
        return "Back to main menu";
    }
    
    @Override
    public void execute() {
    // this method is not used, but has to be here because of Executable interface inherited from Action.
    }
    
}
