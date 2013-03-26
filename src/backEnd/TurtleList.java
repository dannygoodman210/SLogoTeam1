package backEnd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


/**
 * List of turtles
 * @author challenherzberg-brovold
 *
 */
public class TurtleList extends Observable implements Observer {
   
    private List<Turtle> myTurtles;
    private Set<Integer> myActiveIDs;
    private Observer myObserver;
    
    /**
     * Constructor
     */
    public TurtleList() {
        myTurtles = new ArrayList<Turtle>();
        myActiveIDs = new HashSet<Integer>();
    }
    
    /**
     * Alternate constructor
     * @param observer to notify of changes
     */
    public TurtleList(Observer observer) {
        this();
        myObserver = observer;
        addObserver(myObserver);
    }

    /**
     * 
     * @param other 
     */
    public TurtleList(TurtleList other) {
        myTurtles = cloneTurtles(other.myTurtles);
        myActiveIDs = new HashSet<Integer>(other.myActiveIDs);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        setChanged();
    }
    
    /**
     * 
     * @param turtle to be added to list
     */
    public void add(Turtle turtle) {
        myTurtles.add(turtle);
        myActiveIDs.add(turtle.getID());
        setChanged();
    }
    
    /**
     * adds new turtle at coordinates
     * @param x coordinate
     * @param y coordinate
     */
    public void addNewTurtle(int x, int y) {
        Turtle turtle = new Turtle(this, myTurtles.size());
        turtle.setLocation(x, y);
        add(turtle);

    }

    
    /**
     * 
     * @param id 
     * @return turtle to get
     */
    public Turtle get(int id) {
        for (Turtle t : myTurtles) {
            if (t.getID() == id) {
                return t; 
            }
        }
        return null;
    }
    
    /**
     * 
     * @return last active turtle
     */
    public Turtle getLastActive() {
        return myTurtles.get((Integer)myActiveIDs.toArray()[0]);
    }
    
    /**
     * 
     * @return active turtle ids
     */
    public Set<Integer> getActiveIDs () {
        return myActiveIDs;
    }
    
    /**
     * sets turtle to active
     * @param id of turtle
     */
    public void activate(int id) {
        myActiveIDs.add(id);
        setChanged();
    }
    
    /**
     * deactivates turtle
     * @param id of turtle
     */
    public void disactivate(int id) {
        myActiveIDs.remove(id);
        setChanged();
    }
    
    /**
     * deactivates all turtles
     */
    public void disactivateAll() {
        myActiveIDs.clear();
        setChanged();
    }

    /**
     * 
     * @return gets size of list
     */
    public int size() {
        return myTurtles.size();
    }
    
    /**
     * Activates even or odd zeros depending on input
     * @param oneOrZero one activates odds, odd activates evens
     * @return 
     */
    public int activateEvenOdd(int oneOrZero) {
        disactivateAll();
        int ret = 0;
        for (Turtle t: myTurtles) {
            if (t.getID() % 2 == oneOrZero) {
                ret = t.getID();
                activate(ret);
            }
        }
        return ret;
    }
   
    @Override
    protected void setChanged() {
        super.setChanged();
        notifyObservers();
    }

    private List<Turtle> cloneTurtles(List<Turtle> cloneFrom) {
        List<Turtle> cloneTo = new ArrayList<Turtle>();
        for (Turtle t : cloneFrom) {
            cloneTo.add(new Turtle(t));
        }
        return cloneTo;
    }
    
    /**
     * sets the active ids to desired
     * @param ids to be set
     */
    public void setActive(Set<Integer> ids) {
        myActiveIDs = ids;
    }

}
