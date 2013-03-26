package backEnd;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import util.Palette;


/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class Workspace extends Observable implements Observer {

    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private Observer myObserver;
    private Model myModel;
    private Color myBackgroundColor;
    private Palette myPalette;
    private TurtleList myTurtleList;
    private int myIndex;

    /**
     * 
     * @param observer 
     * @param model  
     * @param index 
     */
    public Workspace(Observer observer, Model model, int index) {
        myObserver = observer;
        addObserver(myObserver);
        myModel = model;
        myIndex = index;
        myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        myPalette = new Palette();
        myTurtleList = new TurtleList(this);
        myTurtleList.addNewTurtle(0, 0);
    }
    
    /**
     * 
     * @param other 
     */
    public Workspace(Workspace other) {
        myBackgroundColor = new Color(other.getBackgroundColor().getRGB());
        myPalette = new Palette(other.getPalette());
        myTurtleList = new TurtleList(other.getTurtleList());
    }

    @Override
    public void update (Observable o, Object arg) {
        setChanged();
    }
    
    /**
     * Adds new turtle
     * @param x 
     * @param y 
     */
    public void addNewTurtle (int x, int y) {
        myTurtleList.addNewTurtle(x, y);
    }
    
    /**
     * 
     * @return turtlelist
     */
    public TurtleList getTurtleList () {
        return myTurtleList;
    }
    
    /**
     * 
     * @return gets background color
     */
    public Color getBackgroundColor () {
        return myBackgroundColor;
    }
    
    /**
     * 
     * @param colorIndex color to set
     */
    public void setBackground (int colorIndex) {
        try {
            myBackgroundColor = myPalette.getColor(colorIndex);
            setChanged();
        }
        catch (IndexOutOfBoundsException e) {
            myModel.showErrorMsg("ColorIndex");
        }
    }
    
    /**
     * 
     * @return gets palette
     */
    public Palette getPalette () {
        return myPalette;
    }
    
    /**
     * 
     * @param colorIndex colors to set
     * @param r 
     * @param g 
     * @param b 
     */
    public void setPalette (int colorIndex, int r, int g, int b) {
        myPalette.setColor(colorIndex, r, g, b);
        setChanged();
    }

    @Override
    protected void setChanged () {
        super.setChanged();
        notifyObservers();
    }

    
    /**
     * 
     * @return gets index of workspace
     */
    public int getIndex () {
        return myIndex;
    }
}
