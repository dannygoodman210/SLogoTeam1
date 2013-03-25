package functions.turtle;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class Heading extends Function {

    public Heading(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        return getTurtleList().get(getTurtleList().size() - 1).getHeading();
    }

}
