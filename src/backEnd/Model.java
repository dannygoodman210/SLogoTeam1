package backEnd;

import controller.Controller;
import java.util.ArrayList;
import java.util.List;


/**
 * The model keeps track of the state of the SLogo
 * 
 * @author challenherzberg-brovold
 *
 */
public class Model {

    /**
     * Model object takes the user input and runs the associated command/function.
     * 
     * @author Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
     */

    private SmartMap myMap;
    private Controller myController;
    private List<Workspace> myWorkspaces;

    /**
     * 
     * @param controller Our workspace
     */
    public Model (Controller controller) {
        myController = controller;
        myMap = new SmartMap(this);
        myWorkspaces = new ArrayList<Workspace>();
    }

    /**
     * The main purpose of this method is to clean up the input string
     * and convert it into an array, which is more convenient. It also
     * checks for / substitutes variables.
     * 
     * @param input String received from workspace
     * @return a tidy array of strings
     */
    public Instruction formatString (String input) {
        String[] args = input.trim().toLowerCase().split("\\s+");
        return new Instruction(args);
    }

    /**
     * @param toExecute incoming Instruction to be processes
     * @return output that should be printed in the GUI
     * 
     */

    public double processInstruction (Instruction toExecute) {
        return toExecute.process(myMap);
    }

    /**
     * Executes an instruction, but only up to one return (ie. only up to a constant).
     * Ex: for  fd 50 left 50  it will only execute fd 50. 
     * @param toExecute  
     * @return
     */
    public double process (Instruction toExecute) {
        Executable function = myMap.get(toExecute.get(0));
        double value = function.execute(toExecute.progress());
        return value;
    }
    
    /**
     * Gets the map of function
     * @return the map
     */
    public SmartMap getMap () {
        return myMap;
    }

    /**
     * 
     * @return the workspace
     */
    public Controller getController () {
        return myController;
    }
    
    /**
     * adds a new workspace
     */
    public void addWorkspace () {
        myWorkspaces.add(new Workspace(myController, this, myWorkspaces.size()));
    }
    
    /**
     * getter for our turtlelist
     * @return 
     */
    public TurtleList getTurtleList () {
        return myWorkspaces.get(myController.getWorkspaceIndex()).getTurtleList();
    }
    
    /**
     * throws errow messages to the GUI
     * @param text error to throw
     */
    public void showErrorMsg (String text) {
        myController.showErrorMsg(text);
    }
    
    /**
     * gets last turtle in the list
     * @return last turtle
     */
    public Turtle getLastTurtle() {
        return getTurtleList().getLastActive();
    }
    
    /**
     * Adds new turtle
     * @param x coordinate of turtle
     * @param y coordinate of turtle
     * @return 
     */
    public double addNewTurtle(int x, int y) {
        myWorkspaces.get(myController.getWorkspaceIndex()).addNewTurtle(x, y);
        return 1;
    }
    
    /**
     * gets length of the list
     * @return length
     */
    public int getTurtleListLength() {
        return getTurtleList().size();
    }
    
    /**
     * loads a file
     * @param name filename
     */
    public void loadFile(String name) {
        myMap.load(name);
    }

    /**
     * saves a file
     * @param filePath where to save it to
     */
    public void saveFile(String filePath) {
        myMap.save(filePath);
    }

    /**
     * 
     * @param s gets function from map
     * @return function
     */
    public Executable get(String s) {
        return myMap.get(s);
    }

    /**
     * gets the active workspace
     * @return
     */
    public Workspace getCurrentWorkspace() {
        return myWorkspaces.get(myController.getWorkspaceIndex());
    }


}

