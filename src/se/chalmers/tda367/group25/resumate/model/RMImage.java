package se.chalmers.tda367.group25.resumate.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RMImage {

	private BufferedImage origImg;
	private BufferedImage curImg;
	private SectionType secType;
	private ImageIO imIO;

	//-----Constructors-----//

	/*
	 * Creates an RMImage with default BufferedImage
	 */
	public RMImage(){
		try{
			origImg = imIO.read(new File("C:\\Users\\Patricia\\workspace\\Images\\resources\\RMImageTestbild.jpg"));
		}catch(IOException e){
			System.out.println("Kunde inte ladda in bilden fr�n fil till rmimage");
		}
		this.secType = SectionType.IMAGE;
	}

	/**
	 * Creates an RMImage with a BufferedImage. This image will
	 * not be changed. Changes will be made on a copy of this image.
	 * 
	 * @param image
	 *				the image to make an RMImage of.
	 */
	public RMImage(BufferedImage image) {
		this.secType = SectionType.IMAGE;
		this.origImg = image;
		this.curImg = image;
	}

	// -----Queries-----//
	/**
	 * Get the original BufferedImage.
	 * 
	 * @return the original BufferedImage
	 */
	public BufferedImage getOrigImage() {
		return origImg;
	}
	
	/**
	 * Get the current BufferedImage.
	 * 
	 * @return the current BufferedImage
	 */
	public BufferedImage getCurImage() {
		return curImg;
	}

	// -----Commands-----//
	/**
	 * Set a new image.
	 * 
	 * @param image
	 */
	public void setImage(BufferedImage image) {
		this.origImg = image;
	}
	
	/**
	 * Reset the image. Will return to the format in which 
	 * the image was first uploaded.
	 */
	public void resetImage(){
		this.curImg = this.origImg;
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
		BufferedImage tmp = this.origImg.getSubimage(rect.x
				,rect.y, rect.width, rect.height);
		this.origImg = tmp;

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
	 */
	public void makeGray(){
		System.out.println("Inne i makeGray");
		
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		ColorConvertOp op = new ColorConvertOp(cs, null);
		this.curImg = op.filter(this.origImg, null); 
	}

}