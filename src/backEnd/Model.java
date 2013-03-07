package backEnd;



import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import controller.Workspace;
import functions.*;
import functions.math.*;
import functions.turtle.*;
import functions.bool.*;

public class Model {

    /**
     * Model object takes the user input and runs the associated command/function.
     * 
     * @author Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
     */

    private Workspace myController;
    private Turtle myTurtle;
    private Map<String, Function> myMap = new HashMap<String,Function>();


    public Model (Workspace controller) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        myController = controller;
        myTurtle = new Turtle(myController);
        // to be fixed
        // - general
        myMap.put(Block.BLOCK_OPEN, new Block(this));
        myMap.put("repeat", new Repeat(this));
        // - movments
		myMap.put("left", new Left(myTurtle, this));
		myMap.put("right", new Right(myTurtle, this));
		myMap.put("toward", new Toward(myTurtle, this));
		myMap.put("forward", new Forward(myTurtle, this));
		myMap.put("back", new Back(myTurtle, this));
		myMap.put("setxy", new SetXY(myTurtle, this));
		myMap.put("setheading", new SetHeading(myTurtle, this));
		myMap.put("pendown", new PenDown(myTurtle, this));
		myMap.put("penup", new PenUp(myTurtle, this));
		// - queries
		myMap.put("heading", new Heading(myTurtle, this));
		myMap.put("ispendown?", new IsPenDown(myTurtle, this));
		myMap.put("showing?", new IsVisible(myTurtle, this));
		myMap.put("xcor", new Xcor(myTurtle,this));
		myMap.put("ycor", new Ycor(myTurtle,this));
		// - math
		myMap.put("diff", new Difference(this));
		myMap.put("sum", new Sum(this));
		myMap.put("minus", new Minus(this));
		myMap.put("prod", new Product(this));
		myMap.put("div", new Quotient(this));
		myMap.put("mod", new Remainder(this));
		myMap.put("rand", new RandomNumber(this));
		// - bool
		myMap.put("less", new Less(this));
		myMap.put("greater", new Greater(this));
		myMap.put("equal", new Equal(this));
		myMap.put("neq", new NotEqual(this));
		myMap.put("and", new AndOperation(this));
		myMap.put("or", new OrOperation(this));
		myMap.put("not", new NotOperation(this));
		
    }
    
    public boolean isNumeric(String s) throws Exception {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
    
    /**
	 * Performs operation recursively.
	 * @param commandQueue
	 * @return
	 * @throws Exception
	 */
	public double performOperation(Queue<String> commandQueue) throws Exception {	
		String headOfQueue = commandQueue.poll();
		if (isNumeric(headOfQueue)) return Double.parseDouble(headOfQueue);
		return myMap.get(headOfQueue).execute(commandQueue);
		
	}
    
	public void processString(String command) throws Exception {
		Queue<String> commandQueue = Parser.queueCommands(command);
		while (!commandQueue.isEmpty()) {
			performOperation(commandQueue);
			System.out.println("\n");
		}
	}
	
	
	
	
}
