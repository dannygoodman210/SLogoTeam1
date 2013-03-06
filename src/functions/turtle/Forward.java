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
    	double distance = getModel().process(toExecute);
        getTurtle().move(distance);
        return distance;
    }

}
