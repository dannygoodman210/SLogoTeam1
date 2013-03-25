package backEnd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

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
	 * Saves a map to a properties file
	 * @param map
	 * 
	 *
	 */
	public void saveToFile(Map<String, ?> map) {
		Properties prop = new Properties();
		Set<String> keys = map.keySet();
		
		for(String key : keys){
			prop.setProperty(key, map.get(key).toString());
		}
		
		try {
			prop.store(new FileOutputStream(DEFAULTFILE), null);
		} catch (IOException e) {
			//generate error;
		}
	
	}
	
	public void loadFromFile(){
		ResourceBundle userExecutables = ResourceBundle.getBundle(DEFAULTFILE);
		Set<String> keys = userExecutables.keySet();
		for(String key : keys){
			Instruction toExecute;
			if((userExecutables.getString(key).charAt(0)+"").equals(OPENBRACKET)){
				toExecute = myModel.formatString(DEFINE + key + " " + userExecutables.getString(key));
				System.out.println(toExecute.toString());
				myModel.process(toExecute);	
			}
			else{
				toExecute = myModel.formatString(MAKE + key + " " + userExecutables.getString(key));
				System.out.println(toExecute.toString());
				myModel.process(toExecute);
			}
		}
	}
}
