package makers;

import backEnd.Turtle;
import functions.Forward;
import functions.Function;

public class ForwardMaker extends TurtleMaker {
    
    public ForwardMaker (Turtle turtle) {
        super(turtle);
    }
    
    @Override
    public Function make (String s) {
        double distance = Double.parseDouble(s.substring(0, s.indexOf(' ')));
        return new Forward(getTurtle());
    }

}
