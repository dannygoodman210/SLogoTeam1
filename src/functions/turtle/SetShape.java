package functions.turtle;

import util.ShapePalette;
import backEnd.Model;
import backEnd.Turtle;


/**
 * Sets the shape of the turtle
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class SetShape extends TurtleFunction {
        
    private static final int INPUT_VALUES = 1;
    
    public SetShape(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
    	int shape = (int) values[0];
    	if(shape <= ShapePalette.biggestIndex() && shape >= 0){
        turtle.setShapeIndex(shape);
    	}
    	else{
    	    getModel().showErrorMsg("ShapeIndex");
    	}
    }
}
