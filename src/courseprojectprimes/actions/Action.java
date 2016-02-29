package courseprojectprimes.actions;

public abstract class Action {
    
    private String description;
    
    public Action() {
        description = giveDescription();
    }
    
    protected abstract String giveDescription();
    
    public String getDescription() {
        return description;
    }
    
    public abstract void execute();
}
