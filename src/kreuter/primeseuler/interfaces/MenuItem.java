/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.interfaces;

/**
 *
 * @author Vera Kreuter
 */
public interface MenuItem {
    
    /**
     * Give a short description of the Action represented by the object that can
     * be printed on a GUI element or on the text UI. This description should be
     * quite short; it is complemented by the (longer) info text.
     *
     * @return A short description string.
     */
    String getDescription();
    
    /**
     * Return some string that contains the solution (using some input number if applicable)
     * surrounded by a short explaining sentence that can be printed on a GUI element or used
     * by the execute() method in the text UI.
     * @return A string containing the solution.
     */
    String getSolutionString();
}
