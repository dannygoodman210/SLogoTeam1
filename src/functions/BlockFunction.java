package functions;

import backEnd.Model;

public class BlockFunction extends Function {
	
	
	private Model myModel;
	
	public BlockFunction(Model model){
		myModel = model;
	}
	
	
	public Model getModel(){
		return myModel;
	}
	
	@Override
	public void execute(String[] input) {
		
	}


	@Override
    public String[] getOutput(String[] args){
    	int newReps = Integer.parseInt(args[1]) - 1;
    	if(newReps == 0){
    		int[] blockLocs = getBlockLocation(args);
    		int restLength = args.length - blockLocs[1] - 1;
    		String[] restArgs = new String[restLength];
    		for(int i = 0; i < restLength ; i++){
    			restArgs[i] = args[i+blockLocs[i]+1];
    		}
    		return restArgs;
    	}
    	args[1] = newReps + "";
    	return args.clone();
    }
	
	/**
	 * Used to allow the use of
	 * @param args
	 * @return returns an array of length 2. The first element is the location (index) of '['
	 * and the second is the location (index) of ']'. 
	 */
	public int[] getBlockLocation(String[] args){
		int bracket1 = 0;
		int bracket2 = 0;
		//the loop goes backwards because you want the first block (in the case when there are multiple)
		for(int i = args.length-1; i >= 0 ; i--){
			if(args[i].equals("[")){
				bracket1 = i;
			}
			if(args[i].equals("]")){
				bracket2 = i;
			}	
		}
		return new int[] {bracket1, bracket2};
	}
	
	

}
