package makers;

import backEnd.Turtle;

public abstract class TurtleMaker extends Maker {
    private Turtle myTurtle;
    
    public TurtleMaker (Turtle turtle) {
        myTurtle = turtle;
    }
    
    public Turtle getTurtle () {
        return myTurtle;
    }
}
