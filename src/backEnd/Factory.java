package backEnd;

import java.util.HashMap;
import java.util.Map;
import makers.BackMaker;
import makers.ForwardMaker;
import makers.Maker;

public class Factory {
    
    /**
     * this function makes all the makers that can be used to get the functions
     * we need.
     * 
     * @param turtle for the turtle commands
     * @return map of makers
     */
    public Map<String, Maker> make (Turtle turtle, Model model) {
        Map<String, Maker> map = new HashMap<String, Maker>();
        Maker forward = new ForwardMaker(turtle);
        map.put("forward", forward);
        map.put("fd", forward);
        Maker back = new BackMaker(turtle);
        map.put("back", back);
        map.put("bk", back);
        return map;
    }
}
