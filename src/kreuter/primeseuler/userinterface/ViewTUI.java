/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.userinterface;

import java.util.InputMismatchException;
import java.util.List;
import kreuter.primeseuler.Controller;
import kreuter.primeseuler.PrimesUtils;
import kreuter.primeseuler.actions.Action;
import kreuter.primeseuler.actions.ActionExitToMainMenu;

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
        this.actions = controller.getActions();
    }

    public static void main(String[] args) {
        new ViewTUI(new Controller()).go();
    }

    private void go() {
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
        int userChoice = askMenuItem(menuItems.size());
        
        // to return to main menu: return false if user chose the exit option (= exit object)
        if (menuItems.get(userChoice) instanceof ActionExitToMainMenu) {
            return false;
        }
        currentAction = menuItems.get(userChoice);
        if (currentAction.needsInputNumber()) {
            getInputLongInt();
        }
        currentAction.execute();
        return true;
    }

    private int askMenuItem(int numberOfChoices) {
        int upperBound = numberOfChoices - 1;
        System.out.printf("Please type a number between %d and %d. > ", 0, upperBound);
        int inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextInt();
            } catch(InputMismatchException inputNotInteger) {
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
        System.out.printf("Please type a number (" + currentAction.getLowerInputBound() + " or greater). > ");
        Long inputNumber;
        while (true) {
            try {
                inputNumber = new java.util.Scanner(System.in).nextLong();
            } catch(InputMismatchException ex) {
                System.out.print("That was not an integer. Please type an integer between " + currentAction.getLowerInputBound() + " and " + MAX_LONG + ". > ");
                continue;
            }
            // if input could be parsed to a long, ask the action whether it is valid; if it is, pass it on
            if (currentAction.isValidInput(inputNumber)) {
                currentAction.setInputNumber(inputNumber);
                return;
            } else {
                System.out.print("Invalid input. Number must be at least " + currentAction.getLowerInputBound() + ". > ");
            }
            
        }
    }

}
