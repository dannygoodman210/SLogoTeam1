package util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;


/**
 * ShapePalette class holds a list of Shapes much like the Palette class.
 * This Palette is immutable however. Shapes cannot be added at run time.
 * 
 * @author Danny Goodman
 */
public class ShapePalette {

    private static final String SHAPE_RESOURCE = "resources.Shapes";
    private List<Shape> myShapes;
    private ResourceBundle myResources;

    /**
     * Creates Default ShapePalette
     */
    public ShapePalette () {
        myResources = ResourceBundle.getBundle(SHAPE_RESOURCE);
        myShapes = makeDefaultPalette();
    }

    /**
     * returns the Shape given by the shapeIndex
     * 
     * @param shapeIndex
     * @return
     */
    public Shape getShape (int shapeIndex) {
        return myShapes.get(shapeIndex);
    }

    /** 
     * Returns size of the list
     * 
     * @return
     */
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

    /**
     * Returns biggest index of ShapePalette.
     * 
     * @return
     */
    public static int biggestIndex () {
        return ResourceBundle.getBundle(SHAPE_RESOURCE).keySet().size() - 1;
    }
}
