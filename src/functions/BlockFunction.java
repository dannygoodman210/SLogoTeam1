package functions;

import backEnd.Model;

public abstract class BlockFunction extends Function {
	

	private Model myModel;
	

	public BlockFunction(Model model){
		myModel = model;
	}
	
	
	public Model getModel(){
		return myModel;
	}
	

	@Override
    public String[] getOutput(String[] args){
    	int newReps = Integer.parseInt(args[1]) - 1;
    	if(newReps == 0){
    		int[] blockLocs = getBlockLocation(args);
    		int restLength = args.length - blockLocs[1] - 1;
    		String[] restArgs = new String[restLength];
    		for(int i = 0; i < restLength ; i++){
    			restArgs[i] = args[i+blockLocs[1]+1];
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
		int bracket1Index = 0;
		int bracket2Index = 0;
		
		int bracket1Count = 0;
		int bracket2Count = 0;
		
		boolean bracket1Found = false;
		
		for(int i = 0 ; i < args.length ; i++) {
			
			if(bracket1Found && args[i].equals("[")){
				bracket1Count++;
			}
			if((!bracket1Found) && args[i].equals("[")){
				bracket1Index = i;
				bracket1Found = true;
				bracket1Count = 1;
			}

			if(args[i].equals("]")){
				bracket2Count++;	
			}

			if(bracket1Found && (bracket2Count == bracket1Count)){
				bracket2Index = i;
				break;
			}
			
		}
		return new int[] {bracket1Index, bracket2Index};
	}
	
	

}
