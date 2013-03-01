package backEnd;

import java.util.HashMap;
import java.util.Map;
import functions.Difference;
import functions.Forward;
import functions.Function;
import functions.Left;
import functions.Back;
import functions.Sum;


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
        map.put("fd", forward);
        Function left = new Left(turtle);
        map.put("left", left);
        map.put("lt", left);
        Function back = new Back(turtle);
        map.put("back", back);
        map.put("bk", back);
        Function sum = new Sum();
        map.put("SUM", sum);
        map.put("+", sum);
        Function diff = new Difference();
        map.put("DIFFERENCE", diff);
        map.put("-", diff);
        return map;
    }
}
