package functions;



import java.util.Queue;

import backEnd.Model;

public class Block extends Function {
	/**
     * Processes blocks
     * @author Eunsu Ryu
     */
	
	public static final String BLOCK_OPEN = "[";
	private static final String BLOCK_CLOSED = "]";
	
	public Block(Model model) {
		super(model);
	}
	
	
	/**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
	@Override
	public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//		Double arg = null;
//		while (!commandQueue.peek().equals(BLOCK_CLOSED)) {
//			arg = getModel().performOperation(commandQueue, executing);
//		}
//		commandQueue.poll();
//		return executing? arg : null;
		
		Double arg = null;
		if(executing) System.out.println("BLOCK BEGINS [");
		while (!commandQueue.peek().equals(BLOCK_CLOSED)) {
			arg = getModel().performOperation(commandQueue, executing);
		}
		commandQueue.poll();
		if (executing) {
			System.out.println("] BLOCK ENDS. BLOCK OUTPUT = " + arg);
			return arg;
		}
		else return null;
		


	}

}
