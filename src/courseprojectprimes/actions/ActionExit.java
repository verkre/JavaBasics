package courseprojectprimes.actions;

public class ActionExit extends Action {

    public ActionExit() {
    }
    
    @Override
    public String giveDescription() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
    
    
}
