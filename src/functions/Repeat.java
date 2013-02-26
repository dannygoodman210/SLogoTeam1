package functions;

import backEnd.Interpreter;
import backEnd.Model;

public class Repeat extends Function{
    private Interpreter myInterpreter;
    
    public Repeat(Interpreter interp) {
        myInterpreter = interp;
        
        // commands will have brackets around it
    }
    
    @Override
    public String execute(String input) {
    	String toExecute = input;
    	while(!toExecute.isEmpty()){
    		Function function = myInterpreter.processString(toExecute);
        	toExecute = function.execute(toExecute);
    	}
    	
    	String[] args = input.split("\\s+");
    	int newReps = Integer.parseInt(args[1]) - 1;
    	args[1] = newReps + "";
    	String output = "";
    	for(int i = 0; i < args.length ; i++){
    		output += args[i];
    	}
    	return output;
    }
    
    

}
