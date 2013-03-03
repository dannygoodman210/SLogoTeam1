package backEnd;

import java.util.HashMap;
import java.util.Map;

import functions.AndOperation;

import functions.Difference;
import functions.Equal;
import functions.Forward;
import functions.Function;
import functions.Greater;
import functions.Heading;
import functions.IsPenDown;
import functions.IsVisible;
import functions.Left;
import functions.Back;
import functions.Less;
import functions.Minus;
import functions.NotEqual;
import functions.NotOperation;
import functions.OrOperation;
import functions.PenDown;
import functions.PenUp;
import functions.Product;
import functions.Quotient;
import functions.RandomNumber;
import functions.Remainder;
import functions.Repeat;
import functions.Right;
import functions.SetHeading;
import functions.SetXY;
import functions.Sum;
import functions.Towards;
import functions.Xcor;
import functions.Ycor;


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
        Function pendown = new PenDown(turtle);
        map.put("pendown", pendown);
        map.put("pd", pendown);
        Function penup = new PenUp(turtle);
        map.put("penup", penup);
        map.put("pu", penup);
        Function setxy = new SetXY(turtle);
        map.put("setxy", setxy);
        
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
        
        
        Function less = new Less();
        map.put("less", less);
        Function greater = new Greater();
        map.put("greater", greater);
        Function equal = new Equal();
        map.put("equal", equal);
        Function notEqual = new NotEqual();
        map.put("notequal", notEqual);
        
        Function andOperation = new AndOperation(model);
        map.put("and", andOperation);
        Function orOperation = new OrOperation(model);
        map.put("or", orOperation);
        Function notOperation = new NotOperation(model);
        map.put("not", notOperation);
        
        Function xcor = new Xcor(turtle);
        map.put("xcor", xcor);
        Function ycor = new Ycor(turtle);
        map.put("ycor", ycor);
        Function heading = new Heading(turtle);
        map.put("heading", heading);
        Function ispendown = new IsPenDown(turtle);
        map.put("pendown?", ispendown);
        Function isvisible = new IsVisible(turtle);
        map.put("showing?", isvisible);
        
        return map;
    }
}
