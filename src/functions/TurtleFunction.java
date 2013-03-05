package functions;

import backEnd.Model;
import backEnd.Turtle;

public abstract class TurtleFunction extends Function {
    private static final int DEFAULT_ARGS = 1;
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle, Model model) {
        super(DEFAULT_ARGS, model);
        myTurtle = turtle;
    }
    
    public TurtleFunction (Turtle turtle, Model model, int num) {
        super(num, model);
        myTurtle = turtle;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
}
