package functions;

import backEnd.Turtle;

public class Forward extends TurtleFunction{
    
    public Forward (Turtle turtle) {
        super(turtle);
    }
    
    @Override
    public void execute (String input) {
    	String[] args = input.split("\\s+");
    	int myDistance = Integer.parseInt(args[1]);
        getTurtle().move(myDistance);
        
    }

<<<<<<< HEAD
    public String getOutput(String input) {
	String[] args = input.split("\\s+");
	String output = "";
        for(int i = 2; i < args.length ; i++){
            output += args[i];
        }
        return output;
    }
=======
>>>>>>> dd80252a84f0ee5e4a2e43f20822d12e7b0ea7f5

}
