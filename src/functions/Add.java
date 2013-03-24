package functions;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class Add extends Function {

    public Add (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
        getModel().add(new Turtle(getModel().getController()));
        return 1;
    }

}