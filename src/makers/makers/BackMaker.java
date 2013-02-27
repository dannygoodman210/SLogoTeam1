package makers;

import backEnd.Turtle;
import functions.Back;
import functions.Function;


public class BackMaker extends TurtleMaker {
    
    public BackMaker (Turtle turtle) {
        super(turtle);
    }
    
    @Override
    public Function make (String s) {
        double distance = Double.parseDouble(s.substring(0, s.indexOf(' ')));
        return new Back(getTurtle(), distance);
    }
    
    @Override
    public String cutString (String s) {
        return s.substring(s.indexOf(' ')).trim();
    }
}
