package se.chalmers.tda367.group25.resumate.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeSupport;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

public abstract class TemplatePanel extends JPanel {

	private Container PersonalInfoText;
	private Container  WorkingExperienceText;
	private Container  OtherText;
	private Container imageContainer;
	private PropertyChangeSupport pcs;
	private Boolean isUnderlined = false;
	
	/**
	 * Create the panel.
	 */
	public TemplatePanel(Container pIT, Container wET, Container oT) {
		this.PersonalInfoText = pIT;
		this.WorkingExperienceText = wET;
		this.OtherText = oT;
	}

	/**
	 * Returns the text in the personalInfo JEditorPane.
	 * 
	 * @return String in the JEditorPane for personal info
	 */
	public String getPersonalInfo() {
		return null;
	}

	/**
	 * Returns the text in the workingExperience JEditorPane.
	 * 
	 * @return String in the JEditorPane for working experience
	 */
	public String getWorkingExperienceText() {
		return null;
	}

	public String getOtherText() {
		return null;
	}

	/**
	 * Searches after the text input in variable text
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * 
	 * @param input
	 *			the String which is to be found            
	 */
	public void findText(JEditorPane section, String input){
		//TODO: Change!
		Scanner in = new Scanner(section.getText());
		while(in.hasNext()){
			if(in.findInLine(input) != null){
				int startIndex = in.findInLine(input).indexOf(input);
				int endIndex = in.findInLine(input).lastIndexOf(input, startIndex);	
				section.setSelectionStart(startIndex);
				section.setSelectionEnd(endIndex);
			}
		}			           			          
	}
	
	
	/**
	 * Replaces the a text with another
	 * 
	 * @param replace
	 * 			the text to replace
	 * 
	 * @param replaceWith
	 * 			the text to be replaced with
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 */
	public void replaceText(String replace, String replaceWith, JEditorPane section){
		section.setText(section.getText().replaceAll(replace, replaceWith));
	}
	
	/**
	 * Changes the font of the specific textarea
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * 
	 * @param font
	 * 			the font by which the section is to be customized with
	 */
	
	public void changeFont(JEditorPane section, String font){
		Font f = section.getFont();
		section.setFont(new Font(font, f.getStyle(), f.getSize()));	
	}
	
	/**
	 * Changes the size of the specific textarea
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * @param size
	 * 			the size by which the section is to be customized with
	 */
	public void changeSize(JEditorPane section, int size){
		Font f = section.getFont();
		section.setFont(new Font(f.getFontName(), f.getStyle(), size));	
	}

	/**
	 * Changes the size of the specific textarea
	 * Checks wether the current style is the one which has been chosen.
	 * If so then it will remove the specified style and become plain.
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * @param style
	 * 			the style by which the section is to be customized with
	 */
	
	public void changeStyle(JEditorPane section, String style){
		Font currentFont = section.getFont();
		Font font = currentFont;
		
		switch(style){
		case "B":
			if(!currentFont.isBold()){	
				font = new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize());
			}else{
				font = currentFont.deriveFont(currentFont.getStyle() & ~Font.BOLD);
			}
			break;
		
		case "I":	
			if(!currentFont.isItalic()){	
				font = new Font(currentFont.getFontName(), Font.ITALIC, currentFont.getSize());
			}else{
				font = currentFont.deriveFont(currentFont.getStyle() & ~Font.ITALIC);
			}
			break;
		
		case "U":
			/*
			 * I need some help here, what is to be preferred? Should I let this be this way (which I do not want to)
			 * or should I choose the Map attributes to be <TextAttribute, Integer> and then typecast currentFont.getAttributes();
			 */
			Map attributes = currentFont.getAttributes();
			if(isUnderlined){
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		       
			} else {
				attributes.put(TextAttribute.UNDERLINE, -1);
			}
			isUnderlined = !isUnderlined;
	        font = currentFont.deriveFont(attributes);	
		}
		section.setFont(font);	
	}

}
