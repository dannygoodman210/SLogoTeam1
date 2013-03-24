package backEnd;

import functions.turtle.TurtleFunction;
import java.util.ArrayList;
import java.util.List;

public class TurtleList {
    private List<Turtle> myTurtles;
    private List<Turtle> myActiveTurtles;
    
    public TurtleList () {
        myTurtles = new ArrayList<Turtle>();
        myActiveTurtles = new ArrayList<Turtle>();
    }
    
    public void add (Turtle turtle) {
        myTurtles.add(turtle);
        myActiveTurtles.add(turtle);
    }
    
    public Turtle get (int id) {
        return myTurtles.get(id);
    }
    
    public Turtle getLastActive () {
        return myActiveTurtles.get(myActiveTurtles.size() - 1);
    }
    
    public double switchTurtle (int id) {
        if (!myActiveTurtles.contains(myTurtles.get(id))){
            myActiveTurtles.add(myTurtles.get(id));
            return 1;
        }
        myActiveTurtles.remove(myTurtles.get(id));
        return 0;
    }
    public void execute(TurtleFunction function, double[] values){
        for (Turtle t: myActiveTurtles) {
            function.process(t, values);
        }
    }
    
    public int size () {
        return myTurtles.size();
    }
}
