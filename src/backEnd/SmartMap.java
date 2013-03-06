package backEnd;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import functions.Constant;
import functions.Function;

public class SmartMap {
	
	Map<String, Executable> myMap;
	
	public SmartMap(Turtle turtle, Model model){
		Factory factory = new Factory();
		try {
			myMap = factory.make(turtle, model);
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			//improve
			e.printStackTrace();
		}
	}
	
	public Executable get(String key){
		if(myMap.containsKey(key)){
			return myMap.get(key);
		}
		else{
			int value = Integer.parseInt(key);
			return new Constant(value);
		}

	}
	
	public boolean isNumber(String a){
		return !myMap.containsKey(a);
	}
	

}
