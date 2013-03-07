package backEnd;



import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;

import controller.Workspace;
import functions.*;

public class Model {
	private static final  String TURTLE = "turtle";
	private static final String DEFAULTLANG = "resources.English";
    /**
     * Model object takes the user input and runs the associated command/function.
     * 
     * @author Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
     */

    private Workspace myController;
    private Turtle myTurtle;
    private Map<String, Function> myFunctionMap = new HashMap<String,Function>();
    private Map<String, Double> myVariableDictionary = new HashMap<String, Double>();


    public Model (Workspace controller) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        myController = controller;
        myTurtle = new Turtle(myController);
        myFunctionMap = makeMap(myTurtle, this);	
    }
    
    /**
     * TO BE REFACTORED.
     * Builds a map from function names to function classes
     * @param turtle
     * @param model
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public Map<String, Function> makeMap(Turtle turtle, Model model) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<String, Function> map = new HashMap<String, Function>();
		Class[] paramTypes = {Turtle.class, Model.class};
        Object[] params = {turtle, model};
        
        ResourceBundle functions = ResourceBundle.getBundle(DEFAULTLANG);
        Enumeration<String> functionKeys = functions.getKeys();
        while(functionKeys.hasMoreElements()){
        	String key = functionKeys.nextElement();    
        	String classpath = functions.getString(key);
        	String directory = classpath.split("\\.")[1];
        
        	//need to refactor(duplicate code)
        	Class<?> current = Class.forName(classpath);
        	if(directory.equals(TURTLE)){
        		Constructor<?> currentConstructor = current.getConstructor(paramTypes);
        		Object toAdd = currentConstructor.newInstance(params);
        		Function toMap = (Function) toAdd;
        		map.put(key, toMap);
        	}
        	else{
        		Constructor<?> currentConstructor = current.getConstructor(Model.class);
        		Object toAdd = currentConstructor.newInstance(model);
        		Function toMap = (Function) toAdd;
        		map.put(key, toMap);
        		
        	}	
        }
       
        return map;
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
	public Double performOperation(Queue<String> commandQueue, boolean executing) throws Exception {	
		String headOfQueue = commandQueue.poll();
		if (isNumeric(headOfQueue)) return Double.parseDouble(headOfQueue);
		if (myFunctionMap.containsKey(headOfQueue)) return myFunctionMap.get(headOfQueue).execute(commandQueue, executing);
		if (myVariableDictionary.containsKey(headOfQueue)) return myVariableDictionary.get(headOfQueue);
		return null;
	}
    
	public void processString(String command) throws Exception {
		Queue<String> commandQueue = Parser.queueCommands(command);
		while (!commandQueue.isEmpty()) {
			performOperation(commandQueue, true);
			System.out.println("\n");
		}
	}

	public Double putNewVariableInDictionary(String variableName, Double value){
		myVariableDictionary.put(variableName,value);
		return value;
	}
	
	
	
}
