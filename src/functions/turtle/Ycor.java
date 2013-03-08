package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;
import functions.Function;

public class Ycor extends Function {

    public Ycor(Model model) {
        super(model);
    }


    @Override
    public double execute(String[] input) {
        return getTurtle().getLocation().y;
    }
}
