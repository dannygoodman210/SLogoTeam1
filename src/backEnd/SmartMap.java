package backEnd;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import functions.Constant;
import functions.Function;

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

    public Executable get(String key){
        if(myMap.containsKey(key)){
            return myMap.get(key);
        }
        
        else if(myModel.getManager().contains(key)){
        	return myModel.getManager().getExecutable(key);
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
        myMap.put(name, function);
    }
}
