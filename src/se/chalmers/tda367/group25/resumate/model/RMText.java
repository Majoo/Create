package se.chalmers.tda367.group25.resumate.model;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JEditorPane;
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
	private int size;
	private Map<String, Boolean> styles;

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
		styles = new HashMap<String, Boolean>();
		styles.put("B", Styles.B);
		styles.put("I", Styles.I);
		styles.put("U", Styles.U);
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
	 *            the JEditorPane whose contents is to be customized
	 * 
	 * @param font
	 *            the font by which the section is to be customized with
	 */

	public void changeFont(JEditorPane section, String font) {
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
	 *            the JEditorPane whose contents is to be customized
	 * @param size
	 *            the size by which the section is to be customized with
	 */
	public void changeSize(JEditorPane section, int size) {
		//Store the size in the model
		this.size = size;
		
		//Update the size in the view
		Font currentFont = section.getFont();
		section.setFont(currentFont.deriveFont(currentFont.getStyle(), size));
		
	}

	/**
	 * Changes the style of the specific textarea Checks wether the current
	 * style is the one which has been chosen. If so then it will remove the
	 * specified style. Changes the style of the RMText depending on the
	 * parameter style.
	 * 
	 * @param section
	 *            the JEditorPane whose contents is to be customized
	 * @param style
	 *            the style by which the section is to be customized with
	 */

	public void changeStyle(JEditorPane section, String style) {
		Font currentFont = section.getFont();
		Font font = currentFont;

		switch (style) {
		case "B":
			if (!Styles.B) {
				font = currentFont.deriveFont(currentFont.getStyle()
						+ Font.BOLD);
			} else {
				font = currentFont.deriveFont(currentFont.getStyle()
						& ~Font.BOLD);
			}
			Styles.B = !Styles.B;
			styles.put("B", Styles.B);
			break;

		case "I":
			if (!Styles.I) {
				font = currentFont.deriveFont(currentFont.getStyle()
						+ Font.ITALIC);
			} else {
				font = currentFont.deriveFont(currentFont.getStyle()
						& ~Font.ITALIC);
			}
			Styles.I = !Styles.I;
			styles.put("I", Styles.I);
			break;

		case "U":
			Map<TextAttribute, Integer> attributes = new HashMap<TextAttribute, Integer>();
			if (!Styles.U) {
				attributes.put(TextAttribute.UNDERLINE,
						TextAttribute.UNDERLINE_ON);

			} else {
				attributes.put(TextAttribute.UNDERLINE, -1);
			}
			Styles.U = !Styles.U;
			styles.put("U", Styles.U);
			font = currentFont.deriveFont(attributes);
		}
		section.setFont(font);
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
	 *            the JEditorPane whose contents is to be customized
	 */
	public void replaceText(JEditorPane section, String replace,
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
	 * Returns a map with the styles of the RMText
	 */
	public Map<String, Boolean> getStyles() {
		return styles;
	}

}