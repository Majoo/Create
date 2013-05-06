package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;


/**
 * A class which represents the core of a Template. It holds the
 * methods for accesing the text in the different fields, for 
 * styling the text in the textareas and basic functions involving writing.
 * @author Sara
 *
 */
public abstract class TemplatePanel extends JPanel {

	private JEditorPane personalInfoText;
	private JEditorPane workingExperienceText;
	private JEditorPane otherText;
	private JEditorPane imageContainer;
	private PropertyChangeSupport pcs;
	private Boolean isUnderlined = false;
	
	/**
	 * Create the panel.
	 */
	public TemplatePanel(){
		this.personalInfoText = new JEditorPane();
		this.workingExperienceText = new JEditorPane();
		this.otherText = new JEditorPane();
	}

	/**
	 * Returns the personal information-textarea.
	 * 
	 * @return The JEditorPane for personal information
	 */
	public JEditorPane getPersonalInfo() {
		return personalInfoText;
	}

	/**
	 * Returns the working experience-textarea.
	 * 
	 * @return The JEditorPane for working experience
	 */
	public JEditorPane getWorkingExperienceText() {
		return workingExperienceText;
	}

	/**
	 * Returns the (other) textarea.
	 * 
	 * @return JEditorPane for other texts
	 */
	public JEditorPane getOtherText() {
		return otherText;
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
		Font currentFont = section.getFont();
		section.setFont(new Font(font, currentFont.getStyle(), currentFont.getSize()));
		//Inform to RMtext via pcs
		if(isUnderlined){
			changeStyle(section,"U");
		}
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
		Font currentFont = section.getFont();
		section.setFont(currentFont.deriveFont(currentFont.getStyle(), size));
		//Inform to RMtext via pcs
	}

	/**
	 * Changes the style of the specific textarea
	 * Checks wether the current style is the one which has been chosen.
	 * If so then it will remove the specified style.
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
				font = currentFont.deriveFont(currentFont.getStyle() + Font.BOLD);
			}else{
				font = currentFont.deriveFont(currentFont.getStyle() & ~Font.BOLD);
			}
			break;
		
		case "I":	
			if(!currentFont.isItalic()){	
				font = currentFont.deriveFont(currentFont.getStyle() + Font.ITALIC);
			}else{
				font = currentFont.deriveFont(currentFont.getStyle() & ~Font.ITALIC);
			}
			break;
		
		case "U":
			Map  <TextAttribute, Integer> attributes = new HashMap  <TextAttribute, Integer>();
			if(isUnderlined){
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		       
			} else {
				attributes.put(TextAttribute.UNDERLINE, -1);
			}
			isUnderlined = !isUnderlined;
	        font = currentFont.deriveFont(attributes);	
		}
		section.setFont(font);	
		//Inform to RMtext via pcs
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
		//Inform to RMtext via pcs
		System.out.println("Johan was here");
	}
	
	/**
	 * Searches after the String input in variable text. 
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public void findText(String input, JEditorPane section) {

		// Removes the previous highlights if there were any. (Will be placed somewhere else in the GUI later)
		section.getHighlighter().removeAllHighlights();

		if (input.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Nothing to search");
			return;
		}
		/*
		 * Gets the text from the chosen editorpane and searches after the input from the beginning of the text.
		 */
		String content = section.getText();
		int start = content.indexOf(input, 0);
		int end;
		DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
				Color.YELLOW);
		int matchesFound = 0;
		boolean isSearching = true;
		
		/*
		 * Searches for the specific word.
		 * The text is found if the index of start is larger or equal to zero. The indexes of start and end it will change 
		 * so that it will be after the found word. The found word is marked by a highlighter.
		 */
		while (isSearching) {
			if (start >= 0) {
				++matchesFound;
				try {
					end = start + input.length();
					section.getHighlighter().addHighlight(start, end, painter);
					start = content.indexOf(input, end);

				} catch (BadLocationException e) {
					JOptionPane.showMessageDialog(null,
							"Error: " + e.getMessage());
				}
			} else {
				isSearching = false;
				if (matchesFound == 0) {
					JOptionPane.showMessageDialog(null, "'" + input
							+ "' not found.");
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Matches found: " + matchesFound);
	}

}
