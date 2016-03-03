package jbcourseproject;

import jbcourseproject.actions.Action;
import jbcourseproject.actions.ActionExitToMainMenu;
import java.util.ArrayList;

public class MenuInterface {
    
    private ArrayList<Action> menuItems;
    
    public MenuInterface(ArrayList<Action> availableMenuItems) {
        this.menuItems = availableMenuItems;
    }
    
    /**
     * Displays descriptions of available menu items, lets user choose one and calls its execute method.
     * @return false if the user chose the exit-to-main-menu option, true otherwise
     */
    public boolean displayAndChooseFromMenu() {
        System.out.println("\n");
        // print a newline before the menu because it looks better
        for (int i = 0; i < this.menuItems.size(); i++) {
            System.out.printf("%d - " + this.menuItems.get(i).getDescription() + "%n", i);
        }
        int userChoice = new UserInput().askInputInteger(0, this.menuItems.size() - 1);
        
        // to return to main menu: return false if user chose the exit option (= exit object)
        if (this.menuItems.get(userChoice) instanceof ActionExitToMainMenu) {
            return false;
        }
        this.menuItems.get(userChoice).execute();
        return true;
    }
    
}
