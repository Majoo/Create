package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Styles;

/**
 * A class which represents a section with text of a template.
 * 
 * @author ResuMate
 * 
 */
public class RMText {

	private String text;
	private SectionType secType;
	private String font;
	private Color color;
	private int size;
	private boolean bold;
	private boolean italic;
	private boolean underline;
	private SimpleAttributeSet attributes = new SimpleAttributeSet();

	/**
	 * Default constructor of a RMtext Section in a Document.
	 */
	public RMText() {
		this(SectionType.EMPTY);
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

	// MUTATORS

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
	 * Changes the font of the RMText depending on the parameter font.
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 * 
	 * @param font
	 *            the font by which the section is to be customized with
	 */

	public void changeFont(JTextPane section, String font) {
		//Store the font in the model
		this.font = font;
		
		//Update the font in the view
		Font currentFont = section.getFont();
		section.setFont(new Font(font, currentFont.getStyle(), currentFont
				.getSize()));
		if (Styles.U) {
			changeStyle(section, "U");
		}
	}

	/**
	 * Changes the size of the RMText depending on the parameter size.
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 * @param size
	 *            the size by which the section is to be customized with
	 */
	public void changeSize(JTextPane section, int size) {
		//Store the size in the model
		this.size = size;
		
		//Update the size in the view
		Font currentFont = section.getFont();
		section.setFont(currentFont.deriveFont(currentFont.getStyle(), size));
		
	}

	/**
	 * Changes the style of the specific textarea 
	 * Checks wether the current style is the one which has been chosen. 
	 * If so then it will remove the specified style. 
	 * Changes the style of the RMText depending on the parameter style.
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 * @param style
	 *            the style by which the section is to be customized with
	 */

	public void changeStyle(JTextPane section, String style) {
		
		int start = 0;
		int end = section.getText().length();
		
		if(!section.getSelectedText().isEmpty()){
			start = section.getSelectionStart();
			end = section.getSelectedText().length();
		}
		
		switch (style) {
		case "B":
			bold = (StyleConstants.isBold(attributes)) ? false : true;
			StyleConstants.setBold(attributes, bold);
			break;
		case "I":
			italic = (StyleConstants.isItalic(attributes)) ? false : true;
			StyleConstants.setItalic(attributes, italic);
			break;
		case "U":
			underline = (StyleConstants.isUnderline(attributes)) ? false : true;
			StyleConstants.setUnderline(attributes, underline);
			break;
		default: // Do nothing, never invoked
		}
		// Setter style in the view
		section.getStyledDocument().setCharacterAttributes(start, end,
				attributes, false);
	}
	
	/**
	 * Changes the colour in the textarea 
	 * 
	 * @param section
	 * 			the textarea of which its colour is to be changed
	 * @param col
	 * 			the colour which the textarea is to be updated with
	 */
	
	public void changeColor(JTextPane section, Color col) {
		this.color = col;
		section.setForeground(col);
		
	}

	/**
	 * Replaces the a text with another
	 * 
	 * @param replace
	 *            the text to replace
	 * 
	 * @param replaceWith
	 *            the text to be replaced with
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 */
	public void replaceText(JTextPane section, String replace,
			String replaceWith) {
		//Store the text in the model
		this.setText(section.getText());
		//Update the text in the view
		section.setText(section.getText().replaceAll(replace, replaceWith));
		
	}

	// GETTERS

	/**
	 * Returns SectionType of this RMText.
	 * 
	 * @return the SectionType of this RMText
	 */
	public SectionType getSecType() {
		return this.secType;
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
	 * Returns the font of the RMText
	 */
	public String getFont() {
		return this.font;
	}

	/**
	 * Returns the size of the RMText
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Returns the colour of the RMText
	 */
	public Color getColor(){
		return this.color;
	}


}