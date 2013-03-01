package functions;

import backEnd.Model;

public class Repeat extends BlockFunction{
    

    public Repeat(Model model) {
    	super(model);
    }
    
    @Override
    public void execute(String[] input) {
    	String[] body = new String[input.length -2];
    	for(int i = 2 ; i < input.length ; i++){
    		body[i-2] = input[i];
    	}	
    	getModel().processString(body);
    }
    
    

    

}
