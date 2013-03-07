package backEnd;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Parser {

	public static Queue<String> queueCommands(String command) {
		Queue<String> commandQueue = new LinkedList<String>();
		Scanner scanner = new Scanner(command);
		while(scanner.hasNext()) {
			String token = scanner.next();
			commandQueue.add(token);
		}
		scanner.close();
		return commandQueue;
	}
	
	public static Queue<String> queueCommands(String[] command) {
		return queueCommands(AppendArrayIntoString(command));
	}
	
	private static String AppendArrayIntoString(String[] command) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < command.length; i++){
			buffer.append(command[i]);
			buffer.append(" ");
		}
		return buffer.toString();
	}
	
	public static Queue<String> copyQueue(Queue<String> queue) {
		return queueCommands(queue.toArray(new String[0]));
	}


}
