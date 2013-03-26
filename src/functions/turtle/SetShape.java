package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class SetShape extends TurtleFunction {
        
    private static final int INPUT_VALUES = 1;
    
    public SetShape(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
<<<<<<< HEAD
    	int shape = (int) values[0];
        turtle.setShapeIndex(shape);
=======
        int shapeIndex = (int) values[0];
        turtle.setShapeIndex(shapeIndex);
>>>>>>> 2e7df058fd05ee83987b129e6a480fd5659f57d2
    }
}
