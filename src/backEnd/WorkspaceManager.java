package backEnd;

import java.util.ArrayList;
import java.util.List;

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
	Controller myController;
	 
	/**
	 * Initializes the list used to contain the turtles and sets the controller
	 * 
	 * @param controller
	 */
	 public WorkspaceManager(Controller controller) {
		 myTurtles = new ArrayList<Turtle>();
		 myController = controller;
	 }
	 
	 /**
	  * Adds a turtle to the list of turtles
	  */
	 public void addTurtle () {
		 myTurtles.add(new Turtle(myController));
	 }
	 
	 /**
	  * Returns the turtle associated with the active workspace
	  * @return turtle
	  */
	 public Turtle getTurtle () {
		 return myTurtles.get(getWorkspaceIndex());
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
