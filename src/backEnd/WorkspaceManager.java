package backEnd;

import java.util.ArrayList;
import java.util.List;

import controller.Workspace;

public class WorkspaceManager {

	private int myIndex;
	private List<Turtle> myTurtles;
	Workspace myController;
	 
	 public WorkspaceManager(Workspace controller) {
		 myTurtles = new ArrayList<Turtle>();
		 myTurtles.add(new Turtle(controller));
		 myController = controller;
		 myIndex = 0;
	 }
	 
	 public void addTurtle(){
		 myTurtles.add(new Turtle(myController));
	 }
	 
	 public Turtle getTurtle(){
		 return myTurtles.get(myIndex);
	 }
	
	
}
