package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;
import functions.Function;

public class IsPenDown extends Function {

    public IsPenDown(Model model) {
        super(model);
    }

    @Override
    public double execute(String[] input) {
        if(getTurtle().isPenDown()) {
            return 1;
        }
        return 0;
    }
}
