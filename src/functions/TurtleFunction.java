package functions;

import backEnd.Model;
import backEnd.Turtle;

public abstract class TurtleFunction extends Function {
    private static final int DEFAULT_CUT = 2;
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle, Model model) {
        super(DEFAULT_CUT, model);
        myTurtle = turtle;
    }
    
    public TurtleFunction (Turtle turtle, int cut, Model model) {
        super(cut, model);
        myTurtle = turtle;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
}
