package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class SetPenColor extends TurtleFunction {
        
    private static final int INPUT_VALUES = 1;
    
    public SetPenColor(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
    	int colorIndex = (int) values[0];
        turtle.setPenColorIndex(colorIndex);
    }
}
