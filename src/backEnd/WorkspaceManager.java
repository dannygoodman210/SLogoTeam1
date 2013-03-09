package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Workspace;
import functions.Constant;

public class WorkspaceManager {

	private int myIndex;
	private List<Turtle> myTurtles;
	private List<Map<String, Executable>> myUserExecutables;
	private Workspace myController;
	 
	 public WorkspaceManager(Workspace controller) {
		 myTurtles = new ArrayList<Turtle>();
		 myController = controller;
		 myIndex = 0;
	 }
	 
	 public void addTurtle(){
		 myTurtles.add(new Turtle(myController));
	 }
	 
	 public Turtle getTurtle(){
		 return myTurtles.get(myIndex);
	 }
	 
	 public void addFunction(String key, Executable ex){
		 myUserExecutables.get(myIndex).put(key, ex);
	 }
	 
	 public Executable getExecutable(String key){
		 return myUserExecutables.get(myIndex).get(key);
	 }
	 
	 public boolean contains(String key){
		 return myUserExecutables.get(myIndex).containsKey(key);
	 }
	 
	 public void addVariable(String key, int val){
		 myUserExecutables.get(myIndex).put(key, new Constant(val));
	 }
	
	
}
