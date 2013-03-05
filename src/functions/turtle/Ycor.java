package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class Ycor extends TurtleQuery {

    public Ycor(Turtle turtle, Model model) {
        super(turtle, model);
    }


    @Override
    public double execute(String[] input) {
        return getTurtle().getLocation().y;
    }
}
