package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public class PenDown extends Function {
    

    public PenDown(Model model){
        super(model);
    }

    @Override
    public double execute(String[] input) {
        getTurtle().setPenDown(true);
        return 1;
    }

}
