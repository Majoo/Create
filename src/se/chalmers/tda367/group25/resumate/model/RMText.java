package se.chalmers.tda367.group25.resumate.model;

/**
 * A class which represents a section with text
 * of a template.
 * 
 * @author ResuMate
 *
 */
public class RMText {

	private String text;
	private SectionType secType;
	private String font;
	private int size;
	private String style;

	/**
	 * Default constructor of a RMtext Section in a Document.
	 */
	public RMText() {
		this.secType = SectionType.EMPTY;
	}

	/**
	 * Constructs a RMText with the specified SectionType in a Document.
	 * 
	 * @param sectionType
	 *            the specified SectionType, deciding what kind of Section this
	 *            RMText is
	 */
	public RMText(SectionType sectionType) {
		this.secType = sectionType;
	}

	/**
	 * Returns the String text from this RMText.
	 * 
	 * @return the String text from this RMText
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Returns SectionType of this RMText.
	 * 
	 * @return the SectionType of this RMText
	 */
	public SectionType getSecType() {
		return this.secType;
	}

	/**
	 * Sets the String text to the parameter input.
	 * 
	 * @param input
	 *            the new String to which to set the String text
	 */
	public void setText(String input) {
		this.text = input;
	}
	
	
	/**
	 * Changes the font of the RMText depending  on the 
	 * parameter font.
	 * 
	 * @param font
	 *           the name of the chosen font 
	 */
	public void changeFont(String font){
		this.font = font;
	}
	
	/**
	 * Changes the size of the RMText depending on the 
	 * parameter size.
	 * 
	 * @param size
	 *            the size set for the text
	 */
	public void changeSize(int size){
		this.size = size;
	}
	
	/**
	 * Changes the style of the RMText depending on the 
	 * parameter style.
	 * 
	 * @param size
	 *            the name of the chosen style 
	 */
	public void changeStyle(String style){
		this.style = style;
	}

	/**
	 * Searches after the String input in variable text
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public void findText(String input){
		//TODO: Soya
	}

}