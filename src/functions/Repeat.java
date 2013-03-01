package functions;

import backEnd.Model;

public class Repeat extends BlockFunction{
    

    public Repeat(Model model) {
    	super(model);
    }
    
    @Override
    public void execute(String[] input) {
    	
    	int[] blockLocs = getBlockLocation(input);
    	int blockLength = blockLocs[1] - blockLocs[0] - 1;
    	String[] body = new String[blockLength];
    	
    	for(int i = 0 ; i < body.length ; i++){
    		body[i] = input[i+3];
    	}	
    	getModel().processString(body);
    }
    
    

    

}
