/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.actions;

/**
 *
 * @author Vera Kreuter
 */
public class ActionWelcome extends Action {
    
    private Long inputNumber;

    public ActionWelcome() {
        super("Start here", "This application offers some tools for prime numbers as well as solutions to some problems from projecteuler.com", false);
    }

    @Override
    public String getInfoText() {
        return "Sorry, this welcome screen is yet to be prettified.";
    }

    @Override
    public void execute() {
        // this should never be called - nothing to execute here.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
