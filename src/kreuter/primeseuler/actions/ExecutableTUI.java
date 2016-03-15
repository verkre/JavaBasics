package kreuter.primeseuler.actions;

/**
 * An object that has a description and an execute() method so it can be included in a menu.
 * This interface is here just to test the use of interfaces - both its methods 
 * could be abstract methods in the Action superclass since that's the only class that 
 * implements it (right now).
 */
public interface ExecutableTUI {
    void execute();
    String getDescription();
    
}
