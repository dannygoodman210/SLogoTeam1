package functions;

import backEnd.Turtle;
public class Back extends TurtleFunction {
    
    public Back (Turtle turtle) {
        super(turtle);
    }
    @Override
    public String execute(String[] input) {
    	int distance = Integer.parseInt(input[1]);
        getTurtle().move(-distance);
        return "";
    }
    

}
