package se.chalmers.tda367.group25.resumate.model;

import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

/**
 * A class to describe an image. The image will be stored in the shape it
 * was set. A copy of it can be cropped, scaled and made gray. You access this
 * enhanced image with getCurImage(). It can be reset to the shape it was set.
 */
public class RMImage implements IImage{
	//The original image
	private BufferedImage origImg;
	//The current image with all changes
	private BufferedImage curImg;

	//-----Constructors-----//

	/**
	 * Creates an empty RMImage. 
	 **/
	public RMImage(){
	}

	/**
	 * Creates an RMImage with a BufferedImage. 
	 * 
	 * @param image
	 *				the image to make an RMImage of.
	 */
	public RMImage(BufferedImage image) {
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
	 * UNFINISHED DOESN'T WORK QUITE AS IT SHOULD
	 * somtimes RasterFormatException is thrown)
	 * 
	 * @param rect 
	 * 				a rectangle with the coordinates
	 * 				the image will have after the cropping.
	 */
	public void crop(Rectangle rect) {
		// TODO
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