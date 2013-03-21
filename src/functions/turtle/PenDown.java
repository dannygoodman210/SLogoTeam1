package functions.turtle;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class PenDown extends Function {
    

    public PenDown(Model model){
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        getTurtle().setPenDown(true);
        return 1;
    }

}
