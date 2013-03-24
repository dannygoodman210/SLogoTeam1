package functions;

import backEnd.Instruction;
import backEnd.Model;

public class Switch extends Function {
    
    public Switch (Model model) {
        super(model);
    }
    @Override
    public double execute (Instruction toExecute) {
       return getTurtleList().switchTurtle((int) getReturnValue(toExecute));
       
    }

}
