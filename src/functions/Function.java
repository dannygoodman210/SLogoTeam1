package functions;

public abstract class Function {
    
    private int cutNumber;
    
    public Function (int cut) {
        cutNumber = cut;
    }
    
    public abstract void execute (String[] input);
    
    public String[] getOutput (String[] args) {
        String[] output = new String[args.length - cutNumber];
        for (int i = cutNumber; i < args.length; i++) {
            output[i - cutNumber] = args[i];
        }
        return output;
    }
}
