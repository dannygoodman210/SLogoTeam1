package backEnd;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import functions.Function;

public class Factory {

    private static final  String TURTLE = "turtle";
    private static final String DEFAULTLANG = "resources.English";

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
     */
    public Map<String, Executable> make (Turtle turtle, Model model) throws 
    ClassNotFoundException, NoSuchMethodException, SecurityException, 
    InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException {
        Map<String, Executable> map = new HashMap<String, Executable>();
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

	
