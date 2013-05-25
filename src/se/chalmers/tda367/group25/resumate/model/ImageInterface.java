package se.chalmers.tda367.group25.resumate.model;

import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public interface ImageInterface {
	
	/**
	 * Crop a Rectangle of the Image.
	 * 
	 * @param rect 
	 * 				a rectangle with the coordinates
	 * 				the image will have after the cropping.
	 */
	public void crop(Rectangle rect);
	
	/**
	 * Scale the image to the width and height given as parameter.
	 * 
	 * @param width
	 * 				the width of the product
	 * @param height
	 * 				the height of the product
	 */
	public void scaleImage(int width, int height);
	
	/**
	 * Grayscale the Image of this RMImage.
	 */
	public void makeGray();

}
