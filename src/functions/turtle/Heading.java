package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public class Heading extends Function {

    public Heading(Model model) {
        super(model);
    }


    @Override
    public double execute(Instruction instruction) {
        return getTurtle().getHeading();
    }

}
