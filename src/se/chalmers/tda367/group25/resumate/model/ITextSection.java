package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;

import javax.swing.text.JTextComponent;

public interface ITextSection {

	public void changeSize(JTextComponent section, int size);
	public void changeFont(JTextComponent section, String font);
	public void changeColor(JTextComponent section, Color col, String colour);
	public void replaceText(JTextComponent section, String replace,
			String replaceWith);
	
	public String getFont();
	public String getColor();
	public int getSize();
	
	
}
