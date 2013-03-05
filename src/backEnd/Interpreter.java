package backEnd;

import functions.Function;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Interpreter {
    private Map<String, Function> myFunctions;
    
    /**
     * Currently using a "maker" class implementation. This allows us to have
     * multiple instances of the same function, which can help us to deal with 
     * repeats and the such
     * 
     * @param turtle to pass to factory
     * @param model to pass to factor
     */
    public Interpreter (Turtle turtle, Model model) {
        Factory factory = new Factory();
        try {
			myFunctions = factory.make(turtle, model);
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Function processString (String[] s) {
        return myFunctions.get(s[0]);
    }

   
}
