package se.chalmers.tda367.group25.resumate.model;

import java.awt.Image;

public class RMImage {

	private Image image;
	private SectionType secType;

	public RMImage(Image image) {
		this.secType = SectionType.IMAGE;
		this.image = image;
	}

	/**
	 * Crop the Image of this RMImage.
	 * 
	 * @param x
	 *            pixels to crop horizontally
	 * @param y
	 *            pixels to crop vertically
	 */
	public void cropImage(int x, int y) {

	}

	/**
	 * Resize the Image of this RMImage.
	 * 
	 * @param x
	 *            percentage to resize horizontally
	 * @param y
	 *            percentage to resize vertically
	 */
	public void resizeImage(int x, int y) {

	}

	/**
	 * Reorient the Image of this RMImage. A positive parameter rotates the
	 * image counterclockwise, and vice versa.
	 * 
	 * @param v
	 *            degrees to rotate
	 */
	public void reorientImage(int v) {

	}

	// -----Getters-----//
	/**
	 * Get the Image.
	 * 
	 * @return image
	 */
	public Image getImage() {
		return image;
	}

	// -----Setters-----//
	/**
	 * Set a new image.
	 * 
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

}