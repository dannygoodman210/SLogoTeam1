package backEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * Allows you to write and save your variables and user defined functions. 
 * @author Francesco Agosti
 *
 */
public class MapResourceManager {

    private static final String LOADERROR = "There was an error loading you file. Try again.";
    private static final String SAVEERROR = "There was an error saving your information.";
    private static final String OPENBRACKET = "[";
    private static final String MAKE = "make ";
    private static final String DEFINE = "to ";

    private Model myModel;

    /**
     * 
     * @param model 
     */
    public MapResourceManager(Model model) {
        myModel = model;
    }


    /**
     * Saves a map to a properties file. Note that the contents of the written file
     * will not distinguish between variables that belong to different workspaces. 
     * However, if you assign a variable (:example) different values in different workspaces
     * you will find an instance of each value in the file (there will be duplicates).
     * File will be written to DEFAULTFILE.  
     * @param map 
     * @param filename 
     *
     */
    public void saveToFile(Map<String, ?> map, String filename) {
        Properties prop = new Properties();
        Set<String> keys = map.keySet();

        for (String key : keys) {
            String keyToWrite = key.substring(1);
            prop.setProperty(keyToWrite, map.get(key).toString());
        }

        try {
            prop.store(new FileOutputStream(filename), null);
        } 
        catch (IOException e) {
            myModel.showErrorMsg(SAVEERROR);
        }

    }
    /**
     * Loads variables and user defined functions from a file. When it loads the file all
     * variables and user defined functions will belong exclusively to your current workspace. 
     * 
     * @param root 
     */
    public void loadFromFile(String root) {
        Properties userExecutables = new Properties();
        try {
            userExecutables.load(new FileInputStream(root));
        } 
        catch (IOException e) {
            myModel.showErrorMsg(LOADERROR);
        }

        Set<String> keys = userExecutables.stringPropertyNames();
        for (String key : keys) {
            Instruction toExecute;
            if ((userExecutables.getProperty(key).charAt(0) + "").equals(OPENBRACKET)) {
                toExecute = myModel.formatString(DEFINE + key + " " + 
                        userExecutables.getProperty(key));
                myModel.process(toExecute);
            }
            else {
                toExecute = myModel.formatString(MAKE + key + 
                                                 " " + userExecutables.getProperty(key));
                myModel.process(toExecute);
            }
        }
    }
}
