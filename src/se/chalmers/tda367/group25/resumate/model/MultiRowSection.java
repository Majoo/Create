package se.chalmers.tda367.group25.resumate.model;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * A class which represents a section with text of multiple rows. 
 * The size, font, style and color of the text section can be changed. 
 * Also, all text can be replaced. The text can be changed.
 */
public class MultiRowSection extends AbsTextSection{

	private String text = "";
	private boolean bold;
	private boolean italic;
	private boolean underline;
	private SimpleAttributeSet attributes = new SimpleAttributeSet();

	
	/**
	 * Constructs a new MutliRowSection with the default attributes.
	 */
	public MultiRowSection() {
		super("Tahoma", "Black", 16);
	}
	
	/**
	 * Sets the text of this MultiRowSection to the parameter text.
	 * 
	 * @param text
	 *            the text to be set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Changes the style of the specific textarea 
	 * Checks whether the current style is the one which has been chosen. 
	 * If so then it will remove the specified style. 
	 * Changes the style of the MutliRowSection depending on the parameter style.
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
		// Sets style in the view
		section.getStyledDocument().setCharacterAttributes(start, end,
				attributes, false);
	}

	/**
	 * Returns the text in this MutliRowSection as a String.
	 * 
	 * @return the text in this MutliRowSection as a String
	 */

	public String getText(){
		return text;
	}

}