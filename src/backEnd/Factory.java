package backEnd;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


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
    public Map<String, Executable> make (Model model) throws 
    ClassNotFoundException, NoSuchMethodException, SecurityException, 
    InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException {
        Map<String, Executable> map = new HashMap<String, Executable>();

        ResourceBundle functions = ResourceBundle.getBundle(DEFAULTLANG);
        Enumeration<String> functionKeys = functions.getKeys();
        while(functionKeys.hasMoreElements()){
            String key = functionKeys.nextElement();    
            String classpath = functions.getString(key);
            Class<?> current = Class.forName(classpath);
            Constructor<?> currentConstructor = current.getConstructor(Model.class);
            Object toAdd = currentConstructor.newInstance(model);
            Function toMap = (Function) toAdd;
            map.put(key, toMap);	
        }
        return map;
    }
}

	
