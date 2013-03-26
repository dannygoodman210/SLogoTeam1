package backEnd;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import util.Palette;


/**
 * A workspace object is associated with the actual workspace in the Logo screen and is the data-source
 * of the workspace view. It is an observable class used to communicate changes of settings 
 * to the view (e.g. background color)
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
     * Getter for the list of turtles
     * @return turtlelist
     */
    public TurtleList getTurtleList () {
        return myTurtleList;
    }
    
    /**
     * Getter for background color
     * @return gets background color
     */
    public Color getBackgroundColor () {
        return myBackgroundColor;
    }
    
    /**
     * Sets background color of screen to that represented by color_index
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
     * Getter for the palette
     * @return gets palette
     */
    public Palette getPalette () {
        return myPalette;
    }
    
    /**
     * Sets color corresponding at given color_index to given r g b color values
     * @param colorIndex colors to set
     * @param r 
     * @param g 
     * @param b 
     */
    public void setPalette (int colorIndex, int r, int g, int b) {
        myPalette.setColor(colorIndex, r, g, b);
        setChanged();
    }

    /**
     * Workspace index getter
     * @return gets index of workspace
     */
    public int getIndex () {
        return myIndex;
    }

    @Override
    protected void setChanged () {
        super.setChanged();
        notifyObservers();
    }
}
