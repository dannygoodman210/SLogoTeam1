package functions;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;
import java.util.List;
import java.util.ArrayList;

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
        String[] paramValues = new String[myParams.length()];
        for (int i = 0; i < myParams.length(); i++) {
            paramValues[i] = toExecute.get(0);
            toExecute.progress();
        }
        Instruction params = new Instruction(paramValues);
        int returnValue = 0;
        for (int j = 0; j < myCommands.length(); j++) {
            returnValue += getModel().getMap().get(myCommands.get(j)).execute(params);
        }
        return returnValue;
    }
}
