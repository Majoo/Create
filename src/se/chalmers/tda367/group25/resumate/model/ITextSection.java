package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;

import javax.swing.text.JTextComponent;

/**
 * ITextSection is an interface for representing a text section. The 
 * size, font and color of the text section can be changed. 
 * Also, all text can be replaced.
 */
public interface ITextSection {

	/**
	 * Changes the size of the text depending on the parameter size.
	 * 
	 * @param section
	 *            the JTextComponent whose size is to be customized
	 * 
	 * @param size
	 *            the new size of the text
	 */
	public void changeSize(JTextComponent section, int size);
	
	/**
	 * Changes the font of the text depending on the parameter font.
	 * 
	 * @param section
	 *            the JTextComponent whose font is to be customized
	 * 
	 * @param font
	 *            the new font of the text
	 */
	public void changeFont(JTextComponent section, String font);
	
	/**
	 * Changes the color of the text depending on the parameter color.
	 * 
	 * @param section
	 *            the JTextComponent whose color is to be customized
	 * 
	 * @param col
	 *            the new color of the text
	 *            
	 * @param colour
	 * 			  the name of the color. Needs to be given with a large first letter.
	 * 			  Example: "Cyan", "White" or "Black".
	 */
	public void changeColor(JTextComponent section, Color col, String colour);
	
	/**
	 * Replaces a String with another.
	 * 
	 * @param section
	 *            the JTextComponent in which text is to be replaced
	 * 
	 * @param replace
	 *            the text to be replaced
	 *            
	 * @param replaceWith
	 * 			  the text to replace with
	 */
	public void replaceText(JTextComponent section, String replace,
			String replaceWith);
	/**
	 * Get the font of the text.
	 * 
	 * @return
	 * 			the font of the text.
	 */
	public String getFont();
	
	/**
	 * Get a String representation of the color of the text.
	 * 
	 * @return
	 * 			a String representation of the color of the text.
	 */
	public String getColor();
	
	/**
	 * Get the size of the text.
	 * 
	 * @return
	 * 			the size of the text.
	 */
	public int getSize();
	
}
