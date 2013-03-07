package functions.turtle;

import java.util.Queue;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class Home extends TurtleFunction {
	/**
     * Brings turtle to initial location. Returns the distance traveled
     * @author Eunsu Ryu
     */
    
    public Home(Turtle turtle, Model model) {
        super(turtle, model);
    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//    	return executing? Double.valueOf(getTurtle().goHome()) : null;
    	
		if (executing) {
			Double arg = getTurtle().goHome();
			System.out.println(" HOME: " + arg);
			return Double.valueOf(arg);
		} return null;
		
    }

}
