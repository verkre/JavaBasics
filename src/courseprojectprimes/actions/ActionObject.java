package courseprojectprimes.actions;

public class ActionObject {
    
    protected String description;
    
    public ActionObject() {
        description = "This is the generic description of the ActionObject superclass";
    }
    
    public String getDescription() {
        return description;
    }
    
    
    // TODO right now this method adds no functionality. Is there any reason to have it here
    // in the superclass and then override it in every single subclass? - Yes!
    public void go() {
        throw new RuntimeException("override me!");
    }
}
