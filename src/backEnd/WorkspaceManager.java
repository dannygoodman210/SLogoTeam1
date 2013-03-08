package backEnd;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;

public class WorkspaceManager {

	private int myIndex;
	private List<Turtle> myTurtles;
	private Controller myController;
	 
	 public WorkspaceManager(Controller controller) {
		 myTurtles = new ArrayList<Turtle>();
		 //myTurtles.add(new Turtle(controller));
		 myController = controller;
		 myIndex = 0;
	 }
	 
	 public void addTurtle () {
		 myTurtles.add(new Turtle(myController));
	 }
	 
	 public Turtle getTurtle () {
		 myIndex = getWorkspaceIndex();
		 return myTurtles.get(myIndex);
	 }
	 
	 public Controller getController(){
	     return myController;
	 }
	
	 private int getWorkspaceIndex () {
		 return myController.getWorkspaceIndex();
	 }
}
