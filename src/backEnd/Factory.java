package backEnd;

import java.util.HashMap;
import java.util.Map;
import functions.Difference;
import functions.Forward;
import functions.Function;
import functions.Left;
import functions.Back;
import functions.Minus;
import functions.Product;
import functions.Quotient;
import functions.RandomNumber;
import functions.Remainder;
import functions.Repeat;
import functions.Right;
import functions.SetHeading;
import functions.Sum;
import functions.Towards;


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
        
        Function repeat = new Repeat(model);
        map.put("repeat", repeat);
        
        Function forward = new Forward(turtle);
        map.put("forward", forward);
        map.put("fd", forward);
        Function left = new Left(turtle);
        map.put("left", left);
        map.put("lt", left);
        Function right = new Right(turtle);
        map.put("right", right);
        map.put("rt", right);
        Function back = new Back(turtle);
        map.put("back", back);
        map.put("bk", back);
        Function towards = new Towards(turtle);
        map.put("towards", towards);
        Function setheading = new SetHeading(turtle);
        map.put("setheading", setheading);
        map.put("seth", setheading);
        Function sum = new Sum();
        map.put("SUM", sum);
        map.put("+", sum);
        Function diff = new Difference();
        map.put("difference", diff);
        map.put("-", diff);
        Function prod = new Product();
        map.put("product", prod);
        map.put("*", prod);
        Function quot = new Quotient();
        map.put("quotient", quot);
        map.put("/", quot);
        Function remain = new Remainder();
        map.put("remainder", remain);
        map.put("%", remain);
        Function minus = new Minus();
        map.put("minus", minus);
        map.put("~", minus);
        Function max = new RandomNumber();
        map.put("max", max);
        return map;
    }
}
