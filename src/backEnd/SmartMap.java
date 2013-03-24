package backEnd;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import functions.Constant;

public class SmartMap {

    private Map<String, Executable> myFunctions;
    private Map<String, Executable> myUserExecutables;
    private Model myModel;

    public SmartMap(Model model){
    	myModel = model;
    	myUserExecutables = new HashMap<String, Executable>();
        Factory factory = new Factory();

        //TEMPORARY!!!!!!!!!!
        try {
            myFunctions = factory.make(model);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Returns the value corresponding to a key from our map. If our map does not contain
     * the key, it assumes the value is a number and returns a constant. 
     * @param key
     * @return
     */
    public Executable get(String key){
    	int workSpaceIndex = myModel.getController().getWorkspaceIndex();
        if(myFunctions.containsKey(key)){
            return myFunctions.get(key);
        }
        else if(myUserExecutables.containsKey(workSpaceIndex + key)){
        	return myUserExecutables.get(workSpaceIndex + key);
       	}
        else{
            int value = Integer.parseInt(key);
            return new Constant(value);
        }
    }
    
    public boolean contains(String key){
    	return myFunctions.containsKey(key) || myUserExecutables.containsKey(key);
    }
    
    public void add(String name, Executable function) {
    	int workSpaceIndex = myModel.getController().getWorkspaceIndex();
        myUserExecutables.put(workSpaceIndex+name, function);
    }
}
