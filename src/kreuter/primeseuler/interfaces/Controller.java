package kreuter.primeseuler.interfaces;

import java.util.ArrayList;
import kreuter.primeseuler.actions.Action;

/**
 * Each class acting as a controller has to know about the available (main or sub)
 * menu items, to pass them to the UI.
 * @author Vera Kreuter
 */
public interface Controller {
    ArrayList<Action> getMenuItems();
}
