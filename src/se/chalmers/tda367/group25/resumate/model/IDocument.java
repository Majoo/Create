package se.chalmers.tda367.group25.resumate.model;

/**
 * An interface to describe a Document. A Document can have different inner
 * structures. Usually this involves different storing of text, images, charts
 * etc. The only thing they have in common is that they have a FilePath.
 */
public interface IDocument {

	/**
	 * Gets the FilePath of the Document.
	 * 
	 * @return the FilePath of the Document
	 */
	public String getFilePath();

	/**
	 * Checks whether the Document has a stored file path.
	 * 
	 * @return true if filePath is initialized, false if empty
	 */
	public boolean hasFilePath();

}
