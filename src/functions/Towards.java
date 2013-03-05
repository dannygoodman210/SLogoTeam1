package functions;

import backEnd.Model;
import backEnd.Turtle;

public class Towards extends TurtleFunction {

    private static final int DEFAULT_ARGS = 2;
    
    public Towards(Turtle turtle, Model model){
        super(turtle, model, DEFAULT_ARGS);
    }

    @Override
    public double execute(String[] input) {
        double[] values = getValue(input, 2);
        double turn = getTurtle().setTowards(values[0], values[1]);
        return turn;
    }

}
