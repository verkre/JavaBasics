/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kreuter.primeseuler.MainController;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.actions.ActionTUIExitToMainMenu;
import kreuter.primeseuler.interfaces.Controller;

/**
 *
 * @author Vera Kreuter
 */
public class ViewTUI extends View {
    
    private List<Action> actions;
    private Action currentAction;

    public ViewTUI() {
    }

    public ViewTUI(Controller controller) {
        this.actions = controller.getMenuItems();
    }

    public static void main(String[] args) {
        new ViewTUI(new MainController()).go();
    }

    private void go() {
        while (true) {
            displayAndChooseFromMenu();
        }
    }
        
    /**
     * This method is used to display the main menu items and let the user choose from them
     * at the start of the program, but is also called from the ActionEpSubcontroller to 
     * display the sub-menu of available Euler Problems. (A second instance of this class is
     * constructed there - more generally a new instance is constructed for every sub-menu/ sub-controller).
     * @return false only when a back-to-main-menu action is chosen by the user, to jump out of the current sub-menu.
     */
    public boolean displayAndChooseFromMenu() {
        System.out.println("\n");
        // print a newline before the menu because it looks better
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d - " + actions.get(i).getDescription() + "%n", i);
        }
        int userChoice = askMenuItem(actions.size());
        
        if (actions.get(userChoice) instanceof ActionTUIExitToMainMenu) {
            return false;
        }
        currentAction = actions.get(userChoice);
        if (currentAction.needsInputNumber()) {
            getInputLongInt();
        }
        currentAction.execute();
        return true;
    }

    private int askMenuItem(int numberOfChoices) {
        int upperBound = numberOfChoices - 1;
        int inputNumber;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Please type a number between %d and %d. > ", 0, upperBound);
        while (true) {
            try {
                inputNumber = Integer.parseInt(br.readLine());
            } catch(InputMismatchException | IOException inputNotInteger) {
                System.out.printf("That was not an integer. Please enter an integer between %d and %d. > ", 0, upperBound);
                continue;
            }
            if (inputNumber >= 0 && inputNumber <= upperBound) {
                return inputNumber;
            }
            else {
                System.out.printf("Invalid input. Please enter a number between %d and %d. > ", 0, upperBound);
            }
        }
    }

    private void getInputLongInt() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Please type a number (" + currentAction.getLowerInputBound() + " or greater). > ");
        Long inputNumber;
        while (true) {
            try {
                inputNumber = Long.parseLong(br.readLine());
            } catch (InputMismatchException | IOException ex) {
                System.out.print("That was not an integer. Please type an integer between " + currentAction.getLowerInputBound() + " and " + MAX_LONG + ". > ");
                continue;
            }
            // if input could be parsed to a long int, ask the action whether it is valid; if it is, pass it on
            if (currentAction.isValidInput(inputNumber)) {
                currentAction.setInputNumber(inputNumber);
                return;
            } else {
                System.out.print("Invalid input. Number must be at least " + currentAction.getLowerInputBound() + ". > ");
            }
        }
    }
}
