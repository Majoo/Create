package se.chalmers.tda367.group25.resumate.model;

import java.awt.Image;



public class RMImage{
	
	private Image image;
	private SectionType secType;

	public RMImage(Image image){
		this.secType = SectionType.IMAGE;
		this.image = image;
	}

	//-----Getters-----//
	/**
	 * Get the Image.
	 * @return image
	 */
	public Image getImage(){
		return image;
	}
	
	//-----Setters-----//
	/**
	 * Set a new image.
	 * @param image
	 */
	public void setImage(Image image){
		this.image = image;
	}

}