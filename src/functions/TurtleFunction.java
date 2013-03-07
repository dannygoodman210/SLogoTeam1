package functions;

import backEnd.Model;
import backEnd.Turtle;

public abstract class TurtleFunction extends Function {
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle, Model model) {
        super(model);
        myTurtle = turtle;
    }
 

    public Turtle getTurtle () {
        return myTurtle;
    }
}
