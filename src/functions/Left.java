package functions;

import backEnd.Turtle;

public class Left extends TurtleFunction {
    
    public Left (Turtle turtle) {
        super(turtle);
    }
    
    @Override

    public void execute(String[] args) {
    	int myAngle = Integer.parseInt(args[1]);
        getTurtle().setHeading(myAngle);
    }

    @Override
    public String[] getOutput (String[] input) {
        return new String[0];
    }

}

