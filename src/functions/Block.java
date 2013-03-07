package functions;



import java.util.Queue;

import backEnd.Model;

public class Block extends Function {
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
	public double execute(Queue<String> commandQueue) throws Exception {
		double arg = 0;
		System.out.println("BLOCK BEGINS [");
		while (!commandQueue.peek().equals(BLOCK_CLOSED)) {
			arg = getModel().performOperation(commandQueue);
		}
		commandQueue.poll();
		System.out.println("] BLOCK ENDS. BLOCK OUTPUT = " + arg);
		return arg;

	}

}
