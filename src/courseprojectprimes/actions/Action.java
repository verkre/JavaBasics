package courseprojectprimes.actions;

public abstract class Action implements Executable{
    
    private String description;
    
    public Action() {
        description = giveDescription();
    }
    
    protected abstract String giveDescription();
    
    public String getDescription() {
        return description;
    }
    
    
    // since this class now implements the interface Executable (with method executable()) this abstract method is not necessary anymore
//    @Override
//    public abstract void execute();
}
