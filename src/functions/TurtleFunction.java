package functions;

import backEnd.Turtle;
public abstract class TurtleFunction extends Function {
    private Turtle myTurtle;
    
    public TurtleFunction (Turtle turtle) {
        myTurtle = turtle;
    }
    
    @Override
    public abstract String execute(String input);
    
    public Turtle getTurtle () {
        return myTurtle;
    }
}
