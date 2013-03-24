package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class Xcor extends Function {

    public Xcor(Model model) {
        super(model);
    }


    @Override
    public double execute(Instruction toExecute) {
        return getModel().getActiveTurtles().getLocation().x;
    }

}
