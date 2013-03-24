package backEnd;

import functions.turtle.TurtleFunction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TurtleList {
    private List<Turtle> myTurtles;
    private Set<Integer> myActiveTurtleIDs;
    
    public TurtleList () {
        myTurtles = new ArrayList<Turtle>();
        myActiveTurtleIDs = new HashSet<Integer>();
    }
    
    public void add (Turtle turtle) {
        myTurtles.add(turtle);
        myActiveTurtleIDs.add(turtle.getID());
       
    }
    
    public Turtle get (int id) {
    	for(Turtle t : myTurtles){
    		if (t.getID() == id){
    			return t; 
    		}
    	}
    	return null;
    }
    
    
    public Turtle getLastActive () {
        return myTurtles.get((int)myActiveTurtleIDs.toArray()[0]);
    }
    
    /*
    public double switchTurtle (int id) {
        if (!myActiveTurtles.contains(myTurtles.get(id))){
            myActiveTurtles.add(myTurtles.get(id));
            return 1;
        }
        myActiveTurtles.remove(myTurtles.get(id));
        return 0;
    }
    */
    
    public void Activate(int ID){
    	myActiveTurtleIDs.add(ID);
    }
    public void Disactivate(int ID){
    	myActiveTurtleIDs.remove(ID);
    }
    
    public void execute(TurtleFunction function, double[] values){
        for (Turtle t: myTurtles) {
        	if(myActiveTurtleIDs.contains(t.getID())){
        		function.process(t, values);
        	}
        }
    }
    
    public int size () {
        return myTurtles.size();
    }
}
