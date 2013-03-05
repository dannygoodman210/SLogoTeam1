package functions;

import backEnd.Model;
import backEnd.Turtle;

public class SetHeading extends TurtleFunction {

    public SetHeading(Turtle turtle, Model model){
        super(turtle, model);
    }

    @Override
    public double execute(String[] input) {
        double angle = getValue(input);
        getTurtle().setHeading(angle);
        return angle;
    }

}
