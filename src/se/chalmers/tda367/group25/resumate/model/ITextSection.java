package se.chalmers.tda367.group25.resumate.model;

import java.awt.Color;
import java.util.List;

import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

public interface ITextSection {

	public void changeSize(JTextComponent section, int size);
	public void changeFont(JTextComponent section, String font);
	public void changeStyle(JTextComponent section, String style);
	public void changeColor(JTextComponent section, Color col, String colour);
	
	public SectionType getSecType();
	public List <String> getText();
	
	public String getFont();
	public String getColor();
	public int getSize();
	
	
}
