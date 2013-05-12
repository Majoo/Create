package se.chalmers.tda367.group25.resumate.experimentText;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/**
	 * Create the panel.
	 */
	
	public TemplatePanel(){
		this.otherText = new JEditorPane();
	}
	
	public TemplatePanel(JEditorPane pIT, JEditorPane wET, JEditorPane oT) {
		this.personalInfoText = pIT;
		this.workingExperienceText = wET;
		this.otherText = oT;
	}

	/**
	 * Returns the text of the personal information-textarea.
	 * 
	 * @return String in the JEditorPane for personal information
	 */
	public String getPersonalInfo() {
		return personalInfoText.getText();
	}

	/**
	 * Returns the text of the working experience-textarea.
	 * 
	 * @return String in the JEditorPane for working experience
	 */
	public String getWorkingExperienceText() {
		return workingExperienceText.getText();
	}

	/**
	 * Returns the text of the (other) textarea.
	 * 
	 * @return String in the JEditorPane for working experience
	 */
	public JEditorPane getOtherText() {
		return otherText;
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
	
	/**
	 * Adds an observer to this class 
	 * 
	 * @param PCL
	 * 			the observer to be added
	 */
	public void addObserver(PropertyChangeListener PCL){
		pcs.addPropertyChangeListener(PCL);
		
	}
	
	/**
	 * Removes an observer of this class
	 * 
	 * @param PCL
	 * 			the observer to be removed
	 */
	public void removeObserver(PropertyChangeListener PCL){
		pcs.removePropertyChangeListener(PCL);
	}

	/**
	 * @return the pcs
	 */
	public PropertyChangeSupport getPcs() {
		return this.pcs;
	}

}
