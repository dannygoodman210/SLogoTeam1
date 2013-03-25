package util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;


/**
 * This class represents an image on the screen and 
 * adds some utility functions to the Image class.
 * 
 * Note, Java only supports the formats: png, jpg, gif.
 * 
 * @author Robert C. Duvall
 */
public class Shape {
    private static final String IMAGE_LOCATION = "/images/";
    private static final int DEFAULT_WIDTH = 42;
    private static final int DEFAULT_HEIGHT = 50;
    private java.awt.Image myImage;
    private String myFileName;


    /**
     * Create an image from the given filename.
     */
    public Shape (String fileName) {
        setImage(fileName);
    }

    /**
     * Create a copy of image from the given other image.
     */
    public Shape (Shape other) {
        this(other.myFileName);
    }

    public boolean equals(Shape other){
    	if(other.getImage().equals(getImage()) && other.getFileName().equals(getFileName()))
    		return true;
    	else 
    		return false;
    	
    }
    
    public String getFileName(){
    	return myFileName;
    }
    
    public java.awt.Image getImage(){
    	return myImage;
    }
    
    /**
     * Set this image to the image referred to by the given filename.
     */
    public void setImage (String fileName) {
        myImage = new ImageIcon(getClass().getResource(IMAGE_LOCATION + fileName)).getImage();
        myFileName = fileName;
    }

    /**
     * Describes how to draw the image on the screen.
     */
    public void paint (Graphics2D pen, Point2D center) {
        paint(pen, center, 0);
    }

    /**
     * Describes how to draw the image rotated on the screen.
     */
    public void paint (Graphics2D pen, Point2D center, double angle) {
        // save current state of the graphics area
        AffineTransform old = new AffineTransform(pen.getTransform());
        // move graphics area to center of this shape
        pen.translate(center.getX(), center.getY());
        // rotate area about this shape
        pen.rotate(Math.toRadians(90 - angle));
        // draw as usual (i.e., rotated)
        pen.drawImage(myImage, -DEFAULT_WIDTH / 2, -DEFAULT_HEIGHT / 2,
                      DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        // restore graphics area to its old state, so our changes have no lasting effects
        pen.setTransform(old);
    }
}
