package functions;

import backEnd.Instruction;
import backEnd.Model;

/**
 * User defined function. This function runs the command associated with a specific user-defined function
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
 *
 */
public class UserDefined extends Function {

    private final String myOpenBracket = "[";
    private final String myCloseBracket = "]";

    private Instruction myParams;
    private Instruction myCommands;
    
    /**
     * functions the user can define
     * @param model 
     * @param params the parameters
     * @param commands commands to carry out
     */
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
    
    /**
     * toString
     */
    public String toString() {
        return myOpenBracket + " " + myParams.toString() + myCloseBracket
                + " " + myOpenBracket + " " + myCommands.toString() + myCloseBracket;
    }
}
