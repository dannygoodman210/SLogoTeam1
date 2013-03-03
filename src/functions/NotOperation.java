package functions;

import backEnd.Model;

public class NotOperation extends BooleanBlockFunction {
	
	public NotOperation(Model model) {
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
		String result = getModel().processString(body).trim();
		return !Boolean.parseBoolean(result) + "";
	}

}
