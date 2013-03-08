package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public class Back extends Function {
    
    public Back (Model model) {
        super(model);
    }
    
    @Override
    public double execute (String[] input) {
    	double distance = getValue(input);
        getTurtle().move(-distance);
        return distance;
    }
    

}
