package functions;

import backEnd.Turtle;

public class Forward extends TurtleFunction{
    
    public Forward (Turtle turtle) {
        super(turtle);
    }
    
    @Override
    public String execute (String[] args) {
    	int distance = Integer.parseInt(args[1]);
        getTurtle().move(distance);
        return distance + "";
    }

}
