package courseprojectprimes.actions;

public abstract class Action implements Executable {
    
    private String description;
    
    public Action() {
        description = giveDescription();
    }
    
    protected abstract String giveDescription();
    
    public String getDescription() {
        return description;
        
        // TODO overwrite getDescription method in each subclass, have it return the string directly
        // getDescription to Executable interface, or make it abstract here?
    }
    
}
