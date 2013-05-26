package se.chalmers.tda367.group25.resumate.model;

import java.awt.Rectangle;

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
