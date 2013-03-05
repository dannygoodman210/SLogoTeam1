package backEnd;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import functions.Function;
import functions.Repeat;
import functions.bool.AndOperation;
import functions.bool.Equal;
import functions.bool.Greater;
import functions.bool.Less;
import functions.bool.NotEqual;
import functions.bool.NotOperation;
import functions.bool.OrOperation;
import functions.math.Difference;
import functions.math.Minus;
import functions.math.Product;
import functions.math.Quotient;
import functions.math.RandomNumber;
import functions.math.Remainder;
import functions.math.Sum;
import functions.turtle.Back;
import functions.turtle.Forward;
import functions.turtle.Heading;
import functions.turtle.IsPenDown;
import functions.turtle.IsVisible;
import functions.turtle.Left;
import functions.turtle.PenDown;
import functions.turtle.PenUp;
import functions.turtle.Right;
import functions.turtle.SetHeading;
import functions.turtle.SetXY;
import functions.turtle.Towards;
import functions.turtle.Xcor;
import functions.turtle.Ycor;


public class Factory {
    
    /**
     * This function makes all the instances of classes. No need for modification. Just
     * add new class to ______.properties
     * 
     * @param turtle for the turtle commands
     * @return map of makers
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * 
     * 
     * 
     */
    public Map<String, Function> make (Turtle turtle, Model model) throws 
    ClassNotFoundException, NoSuchMethodException, SecurityException, 
    InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException {
    	final String TURTLE = "turtle";
    	final String DEFAULTLANG = "resources.English";
        Map<String, Function> map = new HashMap<String,Function>();
		Class[] paramTypes = {Turtle.class, Model.class};
        Object[] params = {turtle, model};
        
        ResourceBundle functions = ResourceBundle.getBundle(DEFAULTLANG);
        Enumeration<String> functionKeys = functions.getKeys();
        while(functionKeys.hasMoreElements()){
        	String key = functionKeys.nextElement();    
        	String classpath = functions.getString(key);
        	String directory = classpath.split("\\.")[1];
        
        	//need to refactor(duplicate code)
        	Class<?> current = Class.forName(classpath);
        	if(directory.equals(TURTLE)){
        		Constructor<?> currentConstructor = current.getConstructor(paramTypes);
        		Object toAdd = currentConstructor.newInstance(params);
        		Function toMap = (Function) toAdd;
        		map.put(key, toMap);
        	}
        	else{
        		Constructor<?> currentConstructor = current.getConstructor(Model.class);
        		Object toAdd = currentConstructor.newInstance(model);
        		Function toMap = (Function) toAdd;
        		map.put(key, toMap);
        		
        	}	
        }
       
        return map;
    }
   
 
}

	
