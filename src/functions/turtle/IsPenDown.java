package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class IsPenDown extends TurtleQuery {

    public IsPenDown(Turtle turtle, Model model) {
        super(turtle, model);
    }

    @Override
    public double execute(String[] input) {
        if(getTurtle().isPenDown()) {
            return 1;
        }
        return 0;
    }
}
