package backEnd;

import functions.Function;
import java.util.Map;
import makers.Maker;

public class Interpreter {
    private Map<String, Maker> myMakers;
    
    /**
     * Currently using a "maker" class implementation. This allows us to have
     * multiple instances of the same function, which can help us to deal with 
     * repeats and the such
     * 
     * @param turtle to pass to factory
     * @param model to pass to factor
     */
    public Interpreter (Turtle turtle, Model model) {
        Factory factory = new Factory();
        myMakers = factory.make(turtle, model);
    }
    
    public Function processString (String s) {
        String key = getKey(s);
        return myMakers.get(key).make(s.trim().substring(s.trim().indexOf(' ')).trim());
    }
    
    public String cutString (String s) {
        String key = getKey(s);
        return myMakers.get(key).cutString(s.trim().substring(s.trim().indexOf(' ')).trim());
    }
    
    private String getKey (String s) {
        String trimmed = s.trim();
        return trimmed.substring(0, trimmed.indexOf(' ')).toLowerCase();   
    }
}
