package makers;

import backEnd.Turtle;
import functions.Function;
import functions.Left;

public class LeftMaker extends TurtleMaker {
    
    public LeftMaker (Turtle turtle) {
        super(turtle);
    }
    
    @Override
    public Function make (String s) {
        double angle = Double.parseDouble(s.substring(0, s.indexOf(' ')));
        return new Left(getTurtle(), angle);
    }

    @Override
    public String cutString (String s) {
        return s.substring(s.indexOf(' ')).trim();
    }

}
