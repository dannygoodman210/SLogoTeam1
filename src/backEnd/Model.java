package backEnd;

import controller.Controller;
import java.util.ArrayList;
import java.util.List;


public class Model {

    /**
     * Model object takes the user input and runs the associated command/function.
     * 
     * @author Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
     */

    private SmartMap myMap;
    private Controller myController;
    private List<Workspace> myWorkspaces;

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
     * The model handles execute, processString can be called recursively to
     * deal with situations such as repeat. Executes all commands that you give it. 
     * 
     * @param s from workspace or recursive command
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

    public SmartMap getMap () {
        return myMap;
    }

    public Controller getController () {
        return myController;
    }

    public void addWorkspace () {
        myWorkspaces.add(new Workspace(myController, this, myWorkspaces.size()));
    }

    public TurtleList getTurtleList () {
        return myWorkspaces.get(myController.getWorkspaceIndex()).getTurtleList();
    }

    public void showErrorMsg (String text) {
        myController.showErrorMsg(text);
    }

    public Turtle getLastTurtle() {
        return getTurtleList().getLastActive();
    }

    public double addNewTurtle(int x, int y) {
        myWorkspaces.get(myController.getWorkspaceIndex()).addNewTurtle(x, y);
        return 1;
    }

    public int getTurtleListLength(){
        return getTurtleList().size();
    }

    public void loadFile(String name) {
        myMap.load(name);
    }


	public void saveFile(String filePath) {
		myMap.save(filePath);
	}
	
    public Executable get(String s) {
        return myMap.get(s);
    }

	public Workspace getCurrentWorkspace() {
		return myWorkspaces.get(myController.getWorkspaceIndex());
	}


}

