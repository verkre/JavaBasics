/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.interfaces;

/**
 * An object that some information text additional to a short description, as well as a solution to
 * some mathematical problem, that can be displayed on a GUI element.
 * @author Vera Kreuter
 */
public interface ExecutableGUI extends MenuItem {
    
    /**
     * Return some information that explains the Action represented by
     * the object more than the description, and that can be printed on a GUI element.
     * @return A string containing additional information.
     */
    String getInfoText();
}
