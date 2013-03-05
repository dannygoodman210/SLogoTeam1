package functions;

import backEnd.Model;
import backEnd.Turtle;
import java.util.List;

public class Left extends TurtleFunction {
    
    private Model myModel;
    
    public Left (Turtle turtle, Model model) {
        super(turtle, model);
        myModel = model;
    }

    @Override
    public double execute (String[] args) {
        List<Double> values = getValue(args);
        getTurtle().rotate(values.get(0));
        return values.get(0);
    }
}
