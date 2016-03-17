package kreuter.primeseuler.interfaces;

/**
 * An object that has an execute() method so it can be included in a menu on
 * the text UI and executed from there.
 * @author Vera Kreuter
 */
public interface ExecutableTUI extends MenuItem {

    /**
     * This is called by the text UI when the user chooses the respective Action 
     * from the (main or sub) menu. 
     * It should either get the solution (string) and print it to the SysOut, or 
     * print the solution plus additional information, or do do something else 
     * entirely (like exit the program).
     */
    void execute();

}
