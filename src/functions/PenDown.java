package functions;

import backEnd.Model;
import backEnd.Turtle;

public class PenDown extends TurtleFunction {
    
    private static final int DEFAULT_ARGS = 0;

    public PenDown(Turtle turtle, Model model){
        super(turtle, model, DEFAULT_ARGS);
    }

    @Override
    public double execute(String[] input) {
        getTurtle().setPenDown(true);
        return 1;
    }

}
