package functions;

import backEnd.Turtle;

public class Forward extends TurtleFunction{
    private double myDistance;
    
    public Forward (Turtle turtle) {
        super(turtle);
        myDistance = 0;
    }
    
    @Override
    public void execute (String input) {
    	String[] args = input.split("\\s+");
    	myDistance = Integer.parseInt(args[1]);
        getTurtle().move(myDistance);
        
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
