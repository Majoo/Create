package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeListener;
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
 	 * Is invoked in subclasses with the propper JEditorPanes.
 	 */
	public TemplatePanel(){		
		this.pcs = new PropertyChangeSupport(this);
	}

	//-----Getters-----
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
	
	//-----Setters-----
	
	/**
	 * Sets the personal information-textarea.
	 * 
	 * @param The JEditorPane for personal information
	 */
	public void setPersonalInfo(JEditorPane personalInfoText) {
		this.personalInfoText = personalInfoText;
	}

	/**
	 * Sets the working experience-textarea.
	 * 
	 * @param The JEditorPane for working experience
	 */
	public void setWorkingExperience(JEditorPane workingExperienceText) {
		this.workingExperienceText = workingExperienceText;
	}

	/**
	 * Sets the (other) textarea.
	 * 
	 * @param JEditorPane for other texts
	 */
	public void setOther(JEditorPane otherText) {
		this.otherText = otherText;
	}
	
	/**
	 * Sets the image container
	 * 
	 * @return JEditorPane for image
	 */
	public void setImageContainer(JEditorPane imageContainer) {
		this.imageContainer = imageContainer;
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

	
	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}
	
	//This is here so that the subclasses can use this pcs to send further events.
	public PropertyChangeSupport getPcs() {
		return this.pcs;
	}
}
