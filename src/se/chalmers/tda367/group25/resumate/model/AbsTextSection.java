package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.text.JTextComponent;

public abstract class AbsTextSection implements ITextSection {

	private String font;
	private String color;
	private int size;

	public AbsTextSection(String font, String color,
			int size) {
		this.font = font;
		this.color = color;
		this.size = size;
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
		// Update the size in the view
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
		this.font = font;
		// Update the font in the view
		Font currentFont = section.getFont();
		section.setFont(new Font(font, currentFont.getStyle(), currentFont
				.getSize()));
	}

	/**
	 * Changes the colour in the textarea
	 * 
	 * @param section
	 *            the textarea of which its colour is to be changed
	 * @param col
	 *            the colour which the textarea is to be updated with
	 */
	public void changeColor(JTextComponent section, Color col, String colour) {
		this.color = colour;
		// Update the colour in the view
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
	public void replaceText(JTextComponent section, String replace,
			String replaceWith) {
		//Update the text in the view
		section.setText(section.getText().replaceAll(replace, replaceWith));
	}

	

	// GETTERS

	/**
	 * Returns the font of the text section
	 */
	public String getFont() {
		return this.font;
	}

	/**
	 * Returns the size of the text section
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Returns the colour of the text section
	 */
	public String getColor() {
		return this.color;
	}

}
