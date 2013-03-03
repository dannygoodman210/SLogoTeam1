package functions;

public abstract class Function {
    
	private static final int DEFAULTCUT = 2;
    private int cutNumber;
    
    public Function(){
    	this(DEFAULTCUT);
    }
    
    public Function (int cut) {
        cutNumber = cut;
    }
    
    public abstract String execute (String[] input);
    
    public String[] getOutput (String[] args) {
        String[] output = new String[args.length - cutNumber];
        for (int i = cutNumber; i < args.length; i++) {
            output[i - cutNumber] = args[i];
        }
        return output;
    }
}
