package backEnd;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import functions.Constant;

public class SmartMap {

    private Map<String, Executable> myMap;
    private Model myModel;

    public SmartMap(Model model){
    	myModel = model;
        Factory factory = new Factory();

        //TEMPORARY!!!!!!!!!!
        try {
            myMap = factory.make(model);
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
        if(myMap.containsKey(key)){
            return myMap.get(key);
        }
        else if(myMap.containsKey(workSpaceIndex + key)){
        	return myMap.get(workSpaceIndex + key);
       	}
        else{
            int value = Integer.parseInt(key);
            return new Constant(value);
        }
    }

    public boolean isNumber(String a){
        return !myMap.containsKey(a);
    }
    
    public void add(String name, Executable function) {
    	int workSpaceIndex = myModel.getController().getWorkspaceIndex();
        myMap.put(workSpaceIndex+name, function);
    }
}
