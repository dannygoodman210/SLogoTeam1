package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import functions.Constant;
import controller.Controller;



/**
 * WorkspaceManager handles the data associated with all workspaces such as
 * the turtle and any user defined command by storing them in a list and retrieving
 * them using the index of the currently selected workspace.
 * 
 * @author David Le, Francesco Agosti, Danny Goodman
 */
public class WorkspaceManager {

	private List<Turtle> myTurtles;
	private List<HashMap<String,Executable>> myUserExecutables;
	private Controller myController;
	 
	/**
	 * Initializes the list used to contain the turtles and sets the controller
	 * 
	 * @param controller
	 */
	 public WorkspaceManager(Controller controller) {
		 myTurtles = new ArrayList<Turtle>();
		 myController = controller;
		 myUserExecutables = new ArrayList<HashMap<String, Executable>>();
		 
	 }
	 
	 /**
	  * Adds a turtle and a map to the our lists
	  */
	 public void addDimension () {
		 myTurtles.add(new Turtle(myController));
		 myUserExecutables.add(new HashMap<String,Executable>());
	 }
	 
	 /**
	  * Returns the turtle associated with the active workspace
	  * @return turtle
	  */
	 public Turtle getTurtle () {
		 return myTurtles.get(getWorkspaceIndex());
	 }
	 
	 public Controller getController(){
	     return myController;
	 }
	 
	 public void addFunction(String key, Executable ex){
		 myUserExecutables.get(getWorkspaceIndex()).put(key, ex);
	 }
	 
	 public Executable getExecutable(String key){
		 return myUserExecutables.get(getWorkspaceIndex()).get(key);
	 }
	 
	 public boolean contains(String key){
		 if(!myUserExecutables.isEmpty()){
			 return myUserExecutables.get(getWorkspaceIndex()).containsKey(key);
		 }
		 return false;
	 }
	 
	 public void addVariable(String key, int val){
		 myUserExecutables.get(getWorkspaceIndex()).put(key, new Constant(val));
	 }
	
	 /**
	  * Returns the workspace index of the currently selected workspace
	  * 
	  * @return index
	  */
	 private int getWorkspaceIndex () {
		 return myController.getWorkspaceIndex();
	 }
}
