package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public class SetHeading extends Function {

    public SetHeading(Model model){
        super(model);
    }

    @Override
    public double execute(String[] input) {
        double angle = getValue(input);
        getTurtle().setHeading(angle);
        return angle;
    }

}
