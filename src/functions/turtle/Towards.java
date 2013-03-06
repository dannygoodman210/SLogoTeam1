package functions.turtle;

import functions.TurtleFunction;
import backEnd.Executable;
import backEnd.Model;
import backEnd.Turtle;
import backEnd.Instruction;

public class Towards extends TurtleFunction {

    private static final int DEFAULT_ARGS = 2;
    
    
    public Towards(Turtle turtle, Model model){
        super(turtle, model, DEFAULT_ARGS);
    }

    @Override
    public double execute(Instruction toExecute) {
    	Executable nextFunction = getExecutable(toExecute.get(0));
        double value1 = nextFunction.execute(toExecute.progress());
        
        Executable nextNextFunction = getExecutable(toExecute.get(0));
        double value2 = nextFunction.execute(toExecute.progress());
        double turn = getTurtle().setTowards(value1, value2);
        return turn;
    }

}
