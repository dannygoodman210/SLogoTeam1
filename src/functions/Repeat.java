package functions;

import backEnd.Model;

public class Repeat extends Function{
    private Model myModel;
    

    public Repeat(Model model) {
        myModel = model;
	}
    
    @Override
    public void execute(String[] input) {
    	String[] body = new String[input.length -2];
    	for(int i = 2 ; i < input.length ; i++){
    		body[i-2] = input[i];
    	}	
    	myModel.processString(body);
    }
    
    
    public String[] getOutput(String[] args){
    	int newReps = Integer.parseInt(args[1]) - 1;
    	if(newReps == 0){
    		return new String[0];
    	}
    	args[1] = newReps + "";
    	return args.clone();
    }
    

}
