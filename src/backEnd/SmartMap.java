package backEnd;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import functions.Constant;

public class SmartMap {
    private final String MAPLOADERROR = "There was an error when loading the functions!";
    private final String MAPGETERROR = "You attempted to access an undefined variable or function";



    private Map<String, Executable> myFunctions;
    private Map<String, Executable> myUserExecutables;
    private Model myModel;
    private MapResourceManager myResourceManager;

    public SmartMap(Model model){
        myModel = model;
        myUserExecutables = new HashMap<String, Executable>();
        Factory factory = new Factory();
        myResourceManager = new MapResourceManager(model);

        try {
            myFunctions = factory.make(model);
        } catch (ClassNotFoundException e){
            myModel.showErrorMsg(MAPLOADERROR);
        } catch (NoSuchMethodException e){
            myModel.showErrorMsg(MAPLOADERROR);
        } catch (SecurityException e){
            myModel.showErrorMsg(MAPLOADERROR);
        } catch (InstantiationException e){
            myModel.showErrorMsg(MAPLOADERROR);
        } catch(IllegalAccessException e){
            myModel.showErrorMsg(MAPLOADERROR);
        } catch(IllegalArgumentException e){
            myModel.showErrorMsg(MAPLOADERROR);
        } catch(InvocationTargetException e) {
            myModel.showErrorMsg(MAPLOADERROR);
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
            try{
                int value = Integer.parseInt(key);
                return new Constant(value);
            }catch(NumberFormatException e){
                myModel.showErrorMsg(MAPGETERROR);
            }
        }
        return new Constant(0);
    }

    public boolean contains(String key){
        return myFunctions.containsKey(key) || myUserExecutables.containsKey(key);
    }

    public void add(String name, Executable function) {
        int workSpaceIndex = myModel.getController().getWorkspaceIndex();
        myUserExecutables.put(workSpaceIndex+name, function);
    }

    public void save(){
        myResourceManager.saveToFile(myUserExecutables);
    }

    public void load(String root){
        myResourceManager.loadFromFile(root);
    }
}
