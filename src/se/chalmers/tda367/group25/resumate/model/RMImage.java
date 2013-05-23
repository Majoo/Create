package se.chalmers.tda367.group25.resumate.model;

import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.views.MenuBar;

public class RMImage {

	private BufferedImage origImg;
	private BufferedImage curImg;
	private SectionType secType;

	//-----Constructors-----//

	/**
	 * Creates an empty RMImage. 
	 **/
	public RMImage(){
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
		this.curImg = image;
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
	 * (DOESN'T WORK QUITE AS IT SHOULD
	 * somtimes RasterFormatException is thrown)
	 * 
	 * @param rect 
	 * 				a rectangle with the coordinates
	 * 				the image will have after the cropping.
	 */
	public void crop(Rectangle rect) {
		this.curImg = this.curImg.getSubimage(rect.x
				,rect.y, rect.width-rect.x, rect.height-rect.y);
	}

	/**
	 * Scale the image to the width and height given as parameter.
	 * 
	 * @param width
	 * 				the width of the product
	 * @param height
	 * 				the height of the product
	 */
	public void scaleImage(int width, int height) {
	    int preWidth  = curImg.getWidth();
	    int preHeight = curImg.getHeight();

	    double scaleX = (double)width/preWidth;
	    double scaleY = (double)height/preHeight;
	    AffineTransform affineTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
	    AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform,
	    		AffineTransformOp.TYPE_BILINEAR);

	    this.curImg = affineTransformOp.filter(
	        curImg,new BufferedImage(width, height, curImg.getType()));
	    
	}

	/**
	 * Grayscale the Image of this RMImage.
	 */
	public void makeGray(){		
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		ColorConvertOp op = new ColorConvertOp(cs, null);
		this.curImg = op.filter(this.origImg, null); 
	}

}