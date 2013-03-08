package functions;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class UserDefined extends Function {
    
    private Instruction myInstruction;
    
    public UserDefined (Model model, Instruction instruction) {
        super(model);
        myInstruction = instruction;
    }
    
    @Override 
    public double execute (Instruction toExecute) {
        return getModel().processInstruction(myInstruction.clone());
    }
}
