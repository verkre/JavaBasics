package courseprojectprimes.actions;

public class ActionObject {
    
    protected String description;
    
    public ActionObject() {
        description = "This is the generic description of the ActionObject superclass";
    }
    
    public String getDescription() {
        return description;
    }
    
    
    public void go() {
        throw new RuntimeException("override me!");
    }
}
