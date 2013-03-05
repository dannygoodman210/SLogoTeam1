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
        Map<String, Function> map = new HashMap();
        
//        Function repeat = new Repeat(model);
//        map.put("repeat", repeat);
        
        Function forward = new Forward(turtle, model);
        map.put("forward", forward);
        map.put("fd", forward);
        Function left = new Left(turtle, model);
        map.put("left", left);
        map.put("lt", left);
        Function right = new Right(turtle, model);
        map.put("right", right);
        map.put("rt", right);
        Function back = new Back(turtle, model);
        map.put("back", back);
        map.put("bk", back);
        Function towards = new Towards(turtle, model);
        map.put("towards", towards);
        Function setheading = new SetHeading(turtle, model);
        map.put("setheading", setheading);
        map.put("seth", setheading);
        Function pendown = new PenDown(turtle, model);
        map.put("pendown", pendown);
        map.put("pd", pendown);
        Function penup = new PenUp(turtle, model);
        map.put("penup", penup);
        map.put("pu", penup);
        Function setxy = new SetXY(turtle, model);
        map.put("setxy", setxy);
        Function sum = new Sum(model);
        map.put("sum", sum);
        map.put("+", sum);
        Function diff = new Difference(model);
        map.put("difference", diff);
        map.put("-", diff);
        Function prod = new Product(model);
        map.put("product", prod);
        map.put("*", prod);
        Function quot = new Quotient(model);
        map.put("quotient", quot);
        map.put("/", quot);
        Function remain = new Remainder(model);
        map.put("remainder", remain);
        map.put("%", remain);
        Function minus = new Minus(model);
        map.put("minus", minus);
        map.put("~", minus);
        Function max = new RandomNumber(model);
        map.put("max", max);
        Function less = new Less(model);
        map.put("less", less);
        Function greater = new Greater(model);
        map.put("greater", greater);
        Function equal = new Equal(model);
        map.put("equal", equal);
        Function notEqual = new NotEqual(model);
        map.put("notequal", notEqual);
        Function andOperation = new AndOperation(model);
        map.put("and", andOperation);
        Function orOperation = new OrOperation(model);
        map.put("or", orOperation);
        Function notOperation = new NotOperation(model);
        map.put("not", notOperation);
        Function xcor = new Xcor(turtle, model);
        map.put("xcor", xcor);
        Function ycor = new Ycor(turtle, model);
        map.put("ycor", ycor);
        Function heading = new Heading(turtle, model);
        map.put("heading", heading);
        Function ispendown = new IsPenDown(turtle, model);
        map.put("pendown?", ispendown);
        Function isvisible = new IsVisible(turtle, model);
        map.put("showing?", isvisible);
        return map;
    }
}
