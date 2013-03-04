package backEnd;

import controller.Workspace;
import functions.Function;

public class Model {
	
/**
 * Model object takes the user input and runs the associated command/function.
 * 
 * @author Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
 */

    private Workspace myController;
    private Turtle myTurtle;
    private Interpreter myInterpreter;
    
    
    
    public Model (Workspace controller) {
        myController = controller;
        myTurtle = new Turtle(myController);
        myInterpreter = new Interpreter(myTurtle, this);
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
    public String processString(String[] input) {
    	String[] toExecute = input;
    	String output= "";
    	while(toExecute.length !=0){
    		Function function = myInterpreter.processString(toExecute);
        	String s = function.execute(toExecute);
        	output += (s + " ");
        	toExecute = function.getOutput(toExecute);
    	}
    	return output;
    	
    }
}
