package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.text.JTextComponent;

/**
 * AbsTextSection is an abstract class for representing a text section. The 
 * size, font and color of the text section can be changed. 
 * Also, all text can be replaced.
 */
public abstract class AbsTextSection implements ITextSection {

	private String font;
	//A String representation of the color of this text section
	private String color;
	private int size;

	/**
	 * Creates a new AbsTextSection with the specified font, size & color.
	 * Envoked by its subclasses.
	 * 
	 * @param font
	 * 				the font of the new instance
	 * @param color
	 * 				the color of the new instance
	 * @param size
	 * 				the size of the new instance
	 */
	protected AbsTextSection(String font, String color,
			int size) {
		this.font = font;
		this.color = color;
		this.size = size;
	}

	// GETTERS

	@Override
	public String getFont() {
		return this.font;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public String getColor() {
		return this.color;
	}
	
	// MUTATORS

	@Override
	public void changeSize(JTextComponent section, int size) {
		this.size = size;
		// Update the size in the view
		Font currentFont = section.getFont();
		section.setFont(currentFont.deriveFont(currentFont.getStyle(), size));
	}

	@Override
	public void changeFont(JTextComponent section, String font) {
		this.font = font;
		// Update the font in the view
		Font currentFont = section.getFont();
		section.setFont(new Font(font, currentFont.getStyle(), currentFont
				.getSize()));
	}

	@Override
	public void changeColor(JTextComponent section, Color col, String colour) {
		this.color = colour;
		// Update the colour in the view
		section.setForeground(col);

	}
	
	@Override
	public void replaceText(JTextComponent section, String replace,
			String replaceWith) {
		//Update the text in the view
		section.setText(section.getText().replaceAll(replace, replaceWith));
	}
	

}
