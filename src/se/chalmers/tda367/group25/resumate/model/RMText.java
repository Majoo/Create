package se.chalmers.tda367.group25.resumate.model;

import javax.swing.JOptionPane;

public class RMText {

	private String text;
	private SectionType secType;

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

	// -----Getters-----//

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

	// -----Setters-----//

	/**
	 * Sets the String text to the parameter input.
	 * 
	 * @param input
	 *            the new String to which to set the String text
	 */
	public void setText(String input) {
		this.text = input;
	}

}