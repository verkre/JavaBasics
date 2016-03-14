/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.userinterface;

import java.util.List;
import kreuter.primeseuler.Controller;
import kreuter.primeseuler.UserInput;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.actions.ActionExitToMainMenu;

/**
 *
 * @author Vera Kreuter
 */
public class ViewTUI extends View {
    
    private List<Action> actions;

    public ViewTUI() {
    }

    public ViewTUI(Controller controller) {
        this.actions = controller.getActions();
    }

    public static void main(String[] args) {
        new ViewTUI(new Controller()).go();
        // TODO move TUI code from UserInput to here.

    }

    public void go() {
        while (true) {
            displayAndChooseFromMenu(actions);
        }
    }
        
    public boolean displayAndChooseFromMenu(List<Action> menuItems) {
        System.out.println("\n");
        // print a newline before the menu because it looks better
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d - " + menuItems.get(i).getDescription() + "%n", i);
        }
        int userChoice = new UserInput().askInputInteger(0, menuItems.size() - 1);
        
        // to return to main menu: return false if user chose the exit option (= exit object)
        if (menuItems.get(userChoice) instanceof ActionExitToMainMenu) {
            return false;
        }
        menuItems.get(userChoice).execute();
        return true;
    }

    
    // TODO implement the getInput methods by using code from UserInput class
    public long getInputLongInt(long lowerBound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInputInteger(int lowerBound, int upperBound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInputInteger(int lowerBound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // methods for text output go here
    
    // TODO actually make this functional
}
