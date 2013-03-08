package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;
import functions.Function;

public class IsVisible extends Function {

    public IsVisible(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        if(getTurtle().isVisible()) {
            return 1;
        }
        return 0;
    }
}
