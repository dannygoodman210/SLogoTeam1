package functions;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;
import functions.Constant;

public class UserDefined extends Function {
    
    private Instruction myParams;
    private Instruction myCommands;
    
    public UserDefined (Model model, Instruction params, Instruction commands) {
        super(model);
        myParams = params;
        myCommands = commands;
    }
    
    @Override 
    public double execute (Instruction toExecute) {
        for (int i = 0; i < myParams.length(); i++) {
            getModel().getMap().add(myParams.get(i), new Constant((int) getReturnValue(toExecute)));
        }
        double returnValue = executeBlock(myCommands);
        return returnValue;
    }
}
