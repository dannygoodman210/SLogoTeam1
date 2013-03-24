package backEnd;

import functions.turtle.TurtleFunction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class TurtleList extends Observable implements Observer {
    private List<Turtle> myTurtles;
    private Set<Integer> myActiveIndexes;

    public TurtleList () {
        myTurtles = new ArrayList<Turtle>();
        myActiveIndexes = new HashSet<Integer>();
    }

    public TurtleList (Observer observer) {
        this();
        addObserver(observer);
    }

    public TurtleList (TurtleList other) {
        myTurtles = cloneTurtles(other.myTurtles);
        myActiveIndexes = new HashSet<Integer>(other.myActiveIndexes);
    }

    @Override
    public void update (Observable arg0, Object arg1) {
        setChanged();
    }

    public void add (Turtle turtle) {
        myTurtles.add(turtle);
        myActiveIndexes.add(myTurtles.size() - 1);
        setChanged();
    }

    public void addNewTurtle () {
        Turtle turtle = new Turtle(this);
        add(turtle);
    }

    public Turtle get (int id) {
        return myTurtles.get(id);
    }

    public Set<Integer> getActiveIndexes () {
        return myActiveIndexes;
    }

    public double switchTurtle (int id) {
        // if (!myActiveTurtles.contains(myTurtles.get(id))) {
        // myActiveTurtles.add(myTurtles.get(id));
        // return 1;
        // }
        // myActiveTurtles.remove(myTurtles.get(id));
        if (!myActiveIndexes.contains(id)) {
            myActiveIndexes.add(id);
            setChanged();
            return 1;
        }
        myActiveIndexes.remove(id);
        setChanged();
        return 0;
    }

    public void execute (TurtleFunction function, double[] values) {
        for (int i : myActiveIndexes) {
            function.process(myTurtles.get(i), values);
        }
    }

    public int size () {
        return myTurtles.size();
    }

    @Override
    protected void setChanged () {
        super.setChanged();
        notifyObservers();
    }

    private List<Turtle> cloneTurtles (List<Turtle> cloneFrom) {
        List<Turtle> cloneTo = new ArrayList<Turtle>();
        for (Turtle t : cloneFrom) {
            cloneTo.add(new Turtle(t));
        }
        return cloneTo;
    }
}
