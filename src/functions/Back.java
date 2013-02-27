package functions;

import backEnd.Turtle;
public class Back extends TurtleFunction {
    
    public Back (Turtle turtle, double distance) {
        super(turtle);
    }
    @Override
    public void execute(String[] input) {
    	int myDistance = Integer.parseInt(input[1]);
        getTurtle().move(-myDistance);
    }
    

}
