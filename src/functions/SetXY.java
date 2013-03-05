package functions;

import backEnd.Model;
import backEnd.Turtle;

public class SetXY extends TurtleFunction {

    public SetXY(Turtle turtle, Model model){
        super(turtle, model);
    }

    @Override
    public double execute(String[] input) {
        double[] values = getValue(input, 2);
        getTurtle().setLocation(values[0], values[1]);
        return values[0] + values[1];
    }

}
