package backEnd;

import functions.Function;
import java.util.Map;

public class Interpreter {
    private Map<String, Makers> myMakers;
    
    /**
     * Currently using a "maker" class implementation. This allows us to have
     * multiple instances of the same function, which can help us to deal with 
     * repeats and the such
     * 
     * @param turtle turtle to pass to factory
     */
    public Interpreter (Turtle turtle, Model model) {
        Factory factory = new Factory();
        myMakers = factory.make(turtle);
        // Still need to make the abstract class Makers
    }
    
    public Function processString (String s) {
        String key = s.substring(0, s.indexOf(' '));
        Function function = myMakers.get(key).make(s.substring(s.indexOf(' ') + 1);
        return function;
    }
}
