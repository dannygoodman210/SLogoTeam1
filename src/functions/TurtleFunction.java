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
    
    
	public String getOutput(String input) {
		String[] args = input.split("\\s+");
		String output = "";
        for(int i = 2; i < args.length ; i++){
        	output += args[i];
        }
        return output;
	}
}
