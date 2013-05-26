package se.chalmers.tda367.group25.resumate.model;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * A class which represents a section with text of a template.
 * 
 * @author ResuMate
 * 
 */
public class MultiRowSection extends AbsTextSection{

	private String text = "";
	private boolean bold;
	private boolean italic;
	private boolean underline;
	private SimpleAttributeSet attributes = new SimpleAttributeSet();

	
	/**
	 * Constructs a MutliRowSection with the specified SectionType in a Document.
	 * 
	 * @param sectionType
	 *            the specified SectionType, deciding what kind of Section this
	 *            MutliRowSection is
	 */
	public MultiRowSection() {
		super("Tahoma", "Black", 16);
	}
	
	/**
	 * Sets the String text to the parameter text.
	 * 
	 * @param text
	 *            the new String to which to set the String text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Changes the style of the specific textarea 
	 * Checks wether the current style is the one which has been chosen. 
	 * If so then it will remove the specified style. 
	 * Changes the style of the MutliRowSection depending on the parameter style.
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 * @param style
	 *            the style by which the section is to be customized with
	 */
	
	public void changeStyle(JTextPane sectiion, String style) {
		JTextPane section = (JTextPane)sectiion;
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
	 * Returns the String text from this MutliRowSection.
	 * 
	 * @return the String text from this MutliRowSection
	 */

	public String getText(){
		return text;
	}

}