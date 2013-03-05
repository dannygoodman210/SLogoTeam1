package functions;

import backEnd.Model;
import backEnd.Turtle;

public class Right extends TurtleFunction {

    public Right (Turtle turtle, Model model){
        super(turtle, model);
    }

    @Override
    public double execute(String[] input) {
        double angle = getValue(input);
        getTurtle().rotate(-angle);
        return angle;
    }
}
