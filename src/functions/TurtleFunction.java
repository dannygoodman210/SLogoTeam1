package functions;

import backEnd.Turtle;
public abstract class TurtleFunction extends Function {
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle) {
        myTurtle = turtle;
    }
    
    public Turtle getTurtle () {
        return myTurtle;
    }
}
