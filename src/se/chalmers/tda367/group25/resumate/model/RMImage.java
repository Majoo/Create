package se.chalmers.tda367.group25.resumate.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class RMImage {

	private BufferedImage img;
	private SectionType secType;

	//-----Constructors-----//
	/**
	 * Creates an RMImage with a BufferedImage.
	 * 
	 * @param image
	 *				the image to make an RMImage of.
	 */
	public RMImage(BufferedImage image) {
		this.secType = SectionType.IMAGE;
		this.img = image;
	}

	// -----Queries-----//
	/**
	 * Get the BufferedImage.
	 * 
	 * @return image
	 */
	public BufferedImage getImage() {
		return img;
	}

	// -----Commands-----//
	/**
	 * Set a new image.
	 * 
	 * @param image
	 */
	public void setImage(BufferedImage image) {
		this.img = image;
	}
	
	/**
	 * Crop the Image of this RMImage.
	 * (NEEDS TO BE TESTED)
	 * 
	 * @param rect 
	 * 				a rectangle with the coordinates
	 * 				the image will have after the cropping.
	 */
	public void crop(Rectangle rect) {
		BufferedImage tmp = this.img.getSubimage(rect.x
				,rect.y, rect.width, rect.height);
		this.img = tmp;
		
	}

	/**
	 * Resize the Image of this RMImage.
	 * 
	 * @param x
	 *            percentage to resize horizontally
	 * @param y
	 *            percentage to resize vertically
	 */
	public void resize(int x, int y) {

	}

	/**
	 * Reorient the Image of this RMImage. A positive parameter rotates the
	 * image clockwise, and vice versa.
	 * 
	 * @param v
	 *            degrees to rotate
	 */
	public void reorient(int v) {

	}
	
	/**
	 * Grayscale the Image of this RMImage.
	 * (NEEDS TO BE TESTED)
	 */
	public void makeGray(){
		
		BufferedImage image = new BufferedImage(this.img.getWidth(), this.img.getHeight(),  
			    BufferedImage.TYPE_BYTE_GRAY);  
			Graphics g = this.img.getGraphics();  
			g.drawImage(this.img, 0, 0, null);  
			g.dispose();
	}

}