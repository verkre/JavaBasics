package courseprojectprimes.actions;

public class ActionObjectExit extends ActionObject {

    public ActionObjectExit() {
        description = "Exit";
    }
    

    @Override
    public void go() {
        System.exit(0);
    }
    
    
}
