package se.chalmers.tda367.group25.resumate.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

/**
 * A class which represents a section with text of a template.
 * 
 * @author ResuMate
 * 
 */
public class TextSection extends AbsTextSection{

	private String text = "";
	private boolean bold;
	private boolean italic;
	private boolean underline;
	private List <String> textList;
	private SimpleAttributeSet attributes = new SimpleAttributeSet();

	
	/**
	 * Constructs a RMText with the specified SectionType in a Document.
	 * 
	 * @param sectionType
	 *            the specified SectionType, deciding what kind of Section this
	 *            RMText is
	 */
	public TextSection(SectionType sectionType) {
		super(sectionType,"Tahoma", "Black", 16);
		textList = new ArrayList<String>(1);
		textList.add(text);
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
	public void replaceText(JTextComponent section, String replace,
			String replaceWith) {
		//Store the text in the model
		this.setText(section.getText());
		//Update the text in the view
		section.setText(section.getText().replaceAll(replace, replaceWith));
	}

	@Override
	public List<String> getText() {
		return null;
	}
	
	/**
	 * Returns the String text from this RMText.
	 * 
	 * @return the String text from this RMText
	 */



}