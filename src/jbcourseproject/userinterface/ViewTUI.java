/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.userinterface;

import jbcourseproject.Controller;
import jbcourseproject.MenuInterface;

/**
 *
 * @author Vera Kreuter
 */
public class ViewTUI extends View {

    public static void main(String[] args) {
        MenuInterface mainMenuInterface = new MenuInterface(new Controller().collectActionObjects());
        while (true) {
            mainMenuInterface.displayAndChooseFromMenu();
        }
        // TODO move TUI code from MenuInterface and UserInput to here.
 

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
