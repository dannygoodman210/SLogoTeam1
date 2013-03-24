package backEnd;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import util.Palette;


public class Workspace extends Observable implements Observer {

    private static final String DEFAULT_RESOURCES = "resources.FrontEnd";
    private Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private Observer myObserver;
    private Model myModel;
    private Color myBackgroundColor;
    private Palette myPalette;
    private ResourceBundle myResources;
    private TurtleList myTurtleList;
    private int myIndex;

    public Workspace (Observer observer, Model model, int index) {
        myObserver = observer;
        addObserver(myObserver);
        myModel = model;
        myIndex = index;
        initializeResources();
        myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        myPalette = new Palette();
        myTurtleList = new TurtleList(this);
        myTurtleList.addNewTurtle();
    }

    public Workspace (Workspace other) {
        initializeResources();
        myBackgroundColor = new Color(other.getBackgroundColor().getRGB());
        myPalette = new Palette(other.getPalette());
        myTurtleList = new TurtleList(other.getTurtleList());
    }

    @Override
    public void update (Observable o, Object arg) {
        setChanged();
    }

    public void addNewTurtle () {
        myTurtleList.addNewTurtle();
    }

    public TurtleList getTurtleList () {
        return myTurtleList;
    }

    public Color getBackgroundColor () {
        return myBackgroundColor;
    }

    public void setBackground (int colorIndex) {
        try {
            myBackgroundColor = myPalette.getColor(colorIndex);
            setChanged();
        }
        catch (IndexOutOfBoundsException e) {
            myModel.showErrorMsg(myResources.getString("colorIndex"));
        }
    }

    public Palette getPalette () {
        return myPalette;
    }

    public void setPalette (int colorIndex, int r, int g, int b) {
        myPalette.setColor(colorIndex, r, g, b);
        setChanged();
    }

    @Override
    protected void setChanged () {
        super.setChanged();
        notifyObservers();
    }

    private void initializeResources () {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES);
    }

    public int getIndex () {
        return myIndex;
    }
}
