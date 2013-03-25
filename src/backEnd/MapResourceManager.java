package backEnd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;


/**
 * Allows you to write 
 * @author Francesco Agosti
 *
 */
public class MapResourceManager {

	private final String DEFAULTFILE = "resources.userDefined";
	private final String OPENBRACKET = "]";
	private final String MAKE = "make ";
	private final String DEFINE = "to ";
	
	private Model myModel;
	
	public MapResourceManager(Model model){
		myModel = model;
	}
	
	
	/**
	 * Saves a map to a properties file. Note that the contents of the written file
	 * will not distinguish between variables that belong to different workspaces. 
	 * However, if you assign a variable (:example) different values in different workspaces
	 * you will find an instance of each value in the file (there will be duplicates).
	 * File will be written to DEFAULTFILE.  
	 * @param map
	 *
	 */
	public void saveToFile(Map<String, ?> map) {
		Properties prop = new Properties();
		Set<String> keys = map.keySet();
		
		for(String key : keys){
			String keyToWrite = key.substring(1);
			prop.setProperty(keyToWrite, map.get(key).toString());
		}
		
		try {
			prop.store(new FileOutputStream(DEFAULTFILE), null);
		} catch (IOException e) {
			//generate error;
		}
	
	}
	/**
	 * Loads variables and user defined functions from a file. When it loads the file all
	 * variables and user defined functions will belong exclusively to your current workspace. 
	 * 
	 */
	public void loadFromFile(String root){
		ResourceBundle userExecutables = ResourceBundle.getBundle(root);
		Set<String> keys = userExecutables.keySet();
		for(String key : keys){
			Instruction toExecute;
			if((userExecutables.getString(key).charAt(0)+"").equals(OPENBRACKET)){
				toExecute = myModel.formatString(DEFINE + key + " " + userExecutables.getString(key));
				myModel.process(toExecute);	
			}
			else{
				toExecute = myModel.formatString(MAKE + key + " " + userExecutables.getString(key));
				myModel.process(toExecute);
			}
		}
	}
}
