package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class Heading extends TurtleQuery {

    public Heading(Turtle turtle, Model model) {
        super(turtle, model);
    }


    @Override
    public double execute(String[] input) {
        return getTurtle().getHeading();
    }

}
