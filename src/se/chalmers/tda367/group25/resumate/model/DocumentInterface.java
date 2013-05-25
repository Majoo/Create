package se.chalmers.tda367.group25.resumate.model;

import java.awt.image.BufferedImage;

/**
 * An interface to describe a Document. 
 * A Document can have different inner structures. Usually 
 * this involves different storing of text, images, charts etc.
 * The only thing they have in common is that they hav a FilePath.
 */
public interface DocumentInterface {
	
	/**
	 * Gets the FilePath of the Document.
	 * 
	 * @return 
	 * 			the FilePath of the Document
	 */
	public String getFilePath();
	
}
