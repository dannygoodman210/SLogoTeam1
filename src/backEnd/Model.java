package backEnd;

import java.util.HashMap;
import java.util.Map;

import controller.Workspace;
import functions.Function;

public class Model {

    private Workspace myController;
    private Turtle myTurtle;
    private Interpreter myInterpreter;
    private Map<String,Integer> myVariables;
    
    public Model (Workspace controller) {
        myController = controller;
        myTurtle = new Turtle(myController);
        myInterpreter = new Interpreter(myTurtle, this);
        myVariables = new HashMap<String, Integer>();
    }
    
    /**
     * The main purpose of this method is to clean up the input string
     * and convert it into an array, which is more convenient. It also 
     * checks for / substitutes variables. 
     * 
     * @param input String received from workspace
     * @return a tidy array of strings
     */
    public String[] formatString(String input){
    	String[] args = input.trim().toLowerCase().split("\\s+");
    	return args;
    }
    
    
    
    /**
     * The model handles execute, processString can be called recursively to 
     * deal with situations such as repeat
     * 
     * @param s from workspace or recursive command
     * @return output that should be printed in the GUI
     * 
     */
    public void processString(String[] input) {
    	String[] toExecute = input;
    	while(toExecute.length !=0){
    		Function function = myInterpreter.processString(toExecute);
        	function.execute(toExecute);
        	toExecute = function.getOutput(toExecute);
    	}
    }
}
