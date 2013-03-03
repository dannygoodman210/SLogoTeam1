package functions;

import backEnd.Turtle;

public abstract class TurtleFunction extends Function {
    private static final int CUT = 2;
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle) {
        super(CUT);
        myTurtle = turtle;
    }
    
    public TurtleFunction (Turtle turtle, int cut) {
        super(cut);
        myTurtle = turtle;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
}
