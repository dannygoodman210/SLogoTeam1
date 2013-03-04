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
        return myModel.getMap().get(args[1]).execute(newArray(args, 1));
    }
    
    @Override
    public String[] getOutput(String[] input) {
        if(!myModel.getMap().containsKey(input[1])) {
            return newArray(input, 2);
        }
        return myModel.getMap().get(input[1]).getOutput(newArray(input, 1));
    }
    
    private String[] newArray (String[] array, int overlap) {
        String[] output = new String[array.length - overlap];
        for(int i = overlap; i < array.length; i++) {
            output[i-overlap] = array[i];
        }
        return output;
    }
}
