/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.actions;

/**
 *
 * @author Vera Kreuter
 */
public class ActionGUIWelcome extends Action {
    
    private Long inputNumber;

    public ActionGUIWelcome() {
        super("Start here", "This application offers some tools for prime numbers as well as solutions to some problems from projecteuler.com", false);
    }

    @Override
    public String getInfoText() {
        return "This program provides some tools to check whether a number is a prime number, "
                + "as well as to compute prime factors and lists of prime numbers."
                + "\n"
                + "It can also show the solutions to some problems from projecteuler.com"
                + "\n\n"
                + "You can go back and forth between the tools by using the tabs above.";
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
