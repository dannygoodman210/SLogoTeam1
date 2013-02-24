package backEnd;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    
    /**
     * this function makes all the makers that can be used to get the functions
     * we need.
     * 
     * @param turtle for the turtle commands
     * @return map of makers
     */
    public Map<String, Makers> make (Turtle turtle) {
        Map<String, Makers> map = new HashMap<String, Makers>();
        return map;
    }
}
