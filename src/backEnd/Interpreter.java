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
     * @param turtle turtle to pass to factory
     */
    public Interpreter (Turtle turtle, Model model) {
        Factory factory = new Factory();
        myMakers = factory.make(turtle, model);
        // Still need to make the abstract class Makers
    }
    
    public Function processString (String s) {
        String trimmed = s.trim();
        String key = trimmed.substring(0, trimmed.indexOf(' ')).toLowerCase();
        Function function = myMakers.get(key).make(trimmed.substring(s.indexOf(' ')).trim());
        return function;
    }
}
