package functions.turtle;

import functions.TurtleFunction;
import backEnd.Executable;
import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class Forward extends TurtleFunction{
    
    public Forward (Turtle turtle, Model model) {
        super(turtle, model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
    	Executable nextFunction = getExecutable(toExecute.get(0));
    	double distance = nextFunction.execute(toExecute.progress());
        getTurtle().move(distance);
        return distance;
    }

}
