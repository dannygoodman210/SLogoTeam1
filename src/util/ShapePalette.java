package util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;


public class ShapePalette {

    private static final String SHAPE_RESOURCE = "resources.Shapes";
    private List<Shape> myShapes;
    private ResourceBundle myResources;

    public ShapePalette () {
        myResources = ResourceBundle.getBundle(SHAPE_RESOURCE);
        myShapes = makeDefaultPalette();
    }

    public Shape getShape (int shapeIndex) {
        return myShapes.get(shapeIndex);
    }

    public int size () {
        return myShapes.size();
    }

    private List<Shape> makeDefaultPalette () {
        List<Shape> palette = new ArrayList<Shape>();
        Enumeration<String> shapeKeys = myResources.getKeys();
        while (shapeKeys.hasMoreElements()) {
            String key = shapeKeys.nextElement();
            palette.add(new Shape(myResources.getString(key)));
        }
        return palette;
    }

    public static int biggestIndex () {
        return ResourceBundle.getBundle(SHAPE_RESOURCE).keySet().size() - 1;
    }
}
