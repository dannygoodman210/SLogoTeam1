package functions;

import backEnd.Turtle;


public class Left extends TurtleFunction {
    
    public Left (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String execute (String[] args) {
        int angle = Integer.parseInt(args[1]);
        getTurtle().rotate(angle);
        return angle+"";
    }

}
