package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Styles;

public abstract class absTextSection implements ITextSection {

	private String font;
	private String color;
	private int size;
	private SectionType secType;
	private Map<String, Boolean> styles;

	public absTextSection(SectionType section,String font, String color, int size) {
		this.secType = section;
		this.font = font;
		this.color = color;
		this.size = size;
		
		if (section.equals(SectionType.HEADER)
				|| section.equals(SectionType.PERSONAL_INFO)) {
			this.styles = new HashMap<String, Boolean>();
			this.styles.put("B", Styles.B);
			this.styles.put("I", Styles.I);
			this.styles.put("U", Styles.U);
		}
	}

	// MUTATORS

	/**
	 * Changes the font of the text area depending on the parameter font.
	 * 
	 * @param section
	 *            the JTextComponent whose contents is to be customized
	 * 
	 * @param font
	 *            the font by which the section is to be customized with
	 */
	public void changeSize(JTextComponent section, int size) {
		this.size = size;
		Font currentFont = section.getFont();
		section.setFont(currentFont.deriveFont(currentFont.getStyle(), size));
	}

	/**
	 * Changes the size of the text area depending on the parameter size.
	 * 
	 * @param section
	 *            the JTextComponent whose contents is to be customized
	 * @param size
	 *            the size by which the section is to be customized with
	 */
	public void changeFont(JTextComponent section, String font) {
		// Store the font in the models
		this.font = font;
		// Update the font in the view
		Font currentFont = section.getFont();
		section.setFont(new Font(font, currentFont.getStyle(), currentFont
				.getSize()));
		if (Styles.U) {
			changeStyle(section, "U");
		}
	}

	public void changeStyle(JTextComponent section, String style) {
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
			//Styles.B = !Styles.B;
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
		//	Styles.I = !Styles.I;
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
			//Styles.U = !Styles.U;
			styles.put("U", Styles.U);
			font = currentFont.deriveFont(attributes);
		}
		section.setFont(font);
	}

	
	/**
	 * Changes the colour in the textarea 
	 * 
	 * @param section
	 * 			the textarea of which its colour is to be changed
	 * @param col
	 * 			the colour which the textarea is to be updated with
	 */
	public void changeColor(JTextComponent section, Color col, String colour) {
		this.color = colour;
		section.setForeground(col);

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
	public String getColor(){
		return this.color;
	}


}
