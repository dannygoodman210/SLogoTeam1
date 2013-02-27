package backEnd;

import java.util.HashMap;
import java.util.Map;

import functions.Forward;
import functions.Function;
import functions.Left;
import functions.Repeat;


public class Factory {
    
    /**
     * this function makes all the makers that can be used to get the functions
     * we need.
     * 
     * @param turtle for the turtle commands
     * @return map of makers
     */
    public Map<String, Function> make (Turtle turtle, Model model) {
        Map<String, Function> map = new HashMap<String, Function>();
        
        Function forward = new Forward(turtle);
        map.put("forward", forward);

        
        Function repeat = new Repeat(model);
        map.put("repeat", repeat);
        
        Function left = new Left(turtle);
        map.put("left", left);

        return map;
    }
}
