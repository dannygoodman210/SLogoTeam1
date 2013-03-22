package backEnd;

import functions.turtle.TurtleFunction;
import java.util.ArrayList;
import java.util.List;

public class TurtleList {
    private List<Turtle> myTurtles;
    
    public TurtleList () {
        myTurtles = new ArrayList<Turtle>();
    }
    
    public void add (Turtle turtle) {
        myTurtles.add(turtle);
    }
    
    public Turtle get (int id) {
        return myTurtles.get(id);
    }
    
    public void execute(TurtleFunction function, double[] values){
        for (Turtle t: myTurtles) {
            function.process(t, values);
        }
    }
    
    public int size () {
        return myTurtles.size();
    }
}
