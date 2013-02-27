package functions;

import backEnd.Turtle;
public abstract class TurtleFunction extends Function {
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle) {
        myTurtle = turtle;
    }
    
    public Turtle getTurtle () {
        return myTurtle;
    }

    
	public String[] getOutput(String[] args) {
		String[] output = new String[args.length-2];
        for(int i = 2; i < args.length ; i++){
        	output[i-2] = args[i];
        }
        return output;
    }
}
