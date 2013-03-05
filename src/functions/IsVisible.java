package functions;

import backEnd.Model;
import backEnd.Turtle;

public class IsVisible extends TurtleQuery {

    public IsVisible(Turtle turtle, Model model) {
        super(turtle, model);
    }

    @Override
    public double execute(String[] input) {
        if(getTurtle().isVisible()) {
            return 1;
        }
        return 0;
    }
}
