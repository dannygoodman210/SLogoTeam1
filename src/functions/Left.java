package functions;

import backEnd.Model;
import backEnd.Turtle;

public class Left extends TurtleFunction {
    
    private Model myModel;
    
    public Left (Turtle turtle, Model model) {
        super(turtle);
        myModel = model;
    }

    @Override
    public double execute (String[] args) {
        double angle = getValue(args);
        getTurtle().rotate(angle);
        return angle;
    }
    
    private double getValue (String[] args) {
        if (!myModel.getMap().containsKey(args[1])){
            return Double.parseDouble(args[1]);
        }
        else {
            String[] input = new String[args.length - 2];
            for (int i = 2; i < args.length; i++) {
                input[i - 2] = args[i];
            }
            return myModel.getMap().get(args[1]).execute(input);
        }
    }

}
