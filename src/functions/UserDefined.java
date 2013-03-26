package functions;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;
import functions.Constant;

public class UserDefined extends Function {

    private final String OPENBRACKET = "[";
    private final String CLOSEBRACKET = "]";

    private Instruction myParams;
    private Instruction myCommands;

    public UserDefined(Model model, Instruction params, Instruction commands) {
        super(model);
        myParams = params;
        myCommands = commands;
    }

    @Override 
    public double execute (Instruction toExecute) {
        for (int i = 0; i < myParams.length(); i++) {
            getModel().getMap().put(myParams.get(i), new Constant((int) getReturnValue(toExecute)));
        }
        double returnValue = getReturnValue(myCommands);
        return returnValue;
    }

    public String toString(){
        return OPENBRACKET + " " + myParams.toString() + CLOSEBRACKET
                + " " + OPENBRACKET + " " + myCommands.toString() + CLOSEBRACKET;
    }
}
