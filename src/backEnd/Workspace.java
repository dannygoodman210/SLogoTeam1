package backEnd;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import util.Palette;

public class Workspace extends Observable {
    
    private static final String DEFAULT_RESOURCES = "resources.FrontEnd";
    private Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private Observer myObserver;
    private Model myModel;
    private Color myBackgroundColor;
    private Palette myPalette;
    private ResourceBundle myResources;
    private TurtleList myTurtleList;
    

    public Workspace(Observer observer, Model model){
        myObserver = observer;
        addObserver(myObserver);
        myModel = model;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES);
        myBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        myPalette = new Palette();
        myTurtleList = new TurtleList();
        myTurtleList.add(new Turtle(myObserver));
    }
    
    public void addTurtle(Turtle turtle){
        myTurtleList.add(turtle);
    }
    
    public TurtleList getTurtleList(){
        return myTurtleList;
    }
    
    public void setBackground(int colorIndex){
        try{
            myBackgroundColor = myPalette.getColor(colorIndex);
            setChanged();
        }
        catch(IndexOutOfBoundsException e){
            myModel.showErrorMsg(myResources.getString("colorIndex"));
        }
    }
    
    public Color getBackgroundColor(){
        return myBackgroundColor;
    }
    
    public void setPalette(int colorIndex, int r, int g, int b){
        myPalette.setColor(colorIndex, r, g, b);
        setChanged();
    }
    
    @Override
    protected void setChanged () {
        super.setChanged();
        notifyObservers();
    }
}
