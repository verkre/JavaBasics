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
public class ActionWelcomeEp extends Action {
    
    public ActionWelcomeEp() {
        super("General info", "General info on Project Euler", false);
    }

    @Override
    public String getInfoText() {
        return "Project Euler is a series of challenging mathematical/computer programming problems "
                + "that will require more than just mathematical insights to solve. "
                + "Although mathematics will help you arrive at elegant and efficient methods, "
                + "the use of a computer and programming skills will be required to solve most problems.";
    }

    @Override
    public String getSolutionString() {
        return "You can display the solutions to some Euler Problems here. Choose one from the list on the left.";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        
    }

    @Override
    public void execute() {
        
    }
    
}
