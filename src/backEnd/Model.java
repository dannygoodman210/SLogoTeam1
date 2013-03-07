package backEnd;



import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import controller.Workspace;
import functions.*;
import functions.math.*;
import functions.turtle.*;
import functions.bool.*;

public class Model {

    /**
     * Model object takes the user input and runs the associated command/function.
     * 
     * @author Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
     */

    private Workspace myController;
    private Turtle myTurtle;
    private Map<String, Function> myMap = new HashMap<String,Function>();


    public Model (Workspace controller) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        myController = controller;
        myTurtle = new Turtle(myController);
        myMap = new Factory().make(myTurtle, this);

		
    }
    
    public boolean isNumeric(String s) throws Exception {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
    
    /**
	 * Performs operation recursively.
	 * @param commandQueue
	 * @return
	 * @throws Exception
	 */
	public double performOperation(Queue<String> commandQueue) throws Exception {	
		String headOfQueue = commandQueue.poll();
		if (isNumeric(headOfQueue)) return Double.parseDouble(headOfQueue);
		return myMap.get(headOfQueue).execute(commandQueue);
		
	}
    
	public void processString(String command) throws Exception {
		Queue<String> commandQueue = Parser.queueCommands(command);
		while (!commandQueue.isEmpty()) {
			performOperation(commandQueue);
			System.out.println("\n");
		}
	}
	
	
	
	
}
