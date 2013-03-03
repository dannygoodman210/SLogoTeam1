package functions;

import java.util.Arrays;

import backEnd.Model;

public class AndOperation extends BooleanBlockFunction {

	public AndOperation(Model model) {
		super(model);
		
	}
	
	@Override
	public String execute(String[] input) {
		int[] blockLocs = getBlockLocation(input);
		int blockLength = blockLocs[1] - blockLocs[0] - 1;
		String [] body = new String[blockLength];
		for(int i = 0 ; i < body.length ; i++){
    		body[i] = input[i+2];
    	}
		String allOutputs = getModel().processString(body);
		String[] output = getModel().formatString(allOutputs);
		
		boolean result = true;
		for (int i = 0; i < output.length; i++) {
			result = result && Boolean.parseBoolean(output[i]);
		}
    	return result + "";
	}
	
	
}
