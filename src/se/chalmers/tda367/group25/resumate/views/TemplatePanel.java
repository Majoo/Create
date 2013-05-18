package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Transparency;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;


/**
 * A class which represents the core of a Template. It holds the
 * methods for accesing the text in the different fields, for 
 * styling the text in the textareas and basic functions involving writing.
 *
 */
public abstract class TemplatePanel extends JPanel implements FocusListener {

	private JEditorPane personalInfoText;
	private JEditorPane workingExperienceText;
	private JEditorPane otherText;
	private JLabel imageLbl;
	private JEditorPane currentSection;
	
	private PropertyChangeSupport pcs;
	
 	/**
 	 * Create the panel. 
 	 * Is invoked in subclasses with the propper JEditorPanes.
 	 */
	public TemplatePanel(){		
		
		//Initialize components & adding some settings 
		this.personalInfoText = new JEditorPane();
		personalInfoText.setText("[PERSONAL_INFO] \nNamn:  \nAdress: \nPostnummer: \nIgnoreraDetta:");
		personalInfoText.addFocusListener(this);
		
		this.otherText = new JEditorPane();
		otherText.setText("[HEADLINE]");
		otherText.addFocusListener(this);
		
		this.workingExperienceText = new JEditorPane();
		workingExperienceText.setText("[INFORMATION]");
		workingExperienceText.addFocusListener(this);

		this.imageLbl = new JLabel();
		this.imageLbl.setBackground(Color.cyan);
		setImageLabel(imageLbl);
		
		currentSection = getPersonalInfoText();
		this.pcs = new PropertyChangeSupport(this);
	}

	//-----Getters-----
	/**
	 * Returns the personal information-textarea.
	 * 
	 * @return The JEditorPane for personal information
	 */
	public JEditorPane getPersonalInfoText() {
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
	 * Returns the label for the image
	 * 
	 * @return JLabel for the image
	 */
	public JLabel getImageLabel(){
		return imageLbl;
	}
	
	/**
	 * Returns the textarea for the current section
	 * 
	 * @return JEditorPane for the section
	 */
	public JEditorPane getCurrentSection(){
		return currentSection;
	}
	
	//-----Setters for components------
	
	/**
	 * Sets the image container
	 * 
	 * @return JEditorPane for image
	 */
	public void setImageLabel(JLabel imageLabel) {
		this.imageLbl = imageLabel;
	}
	
	/**
	 *  Sets the current text area which currently was in focus
	 *  
	 * @param currentSection the current JEditorPane in focus
	 */
	public void setCurrentSection(JEditorPane currentSection){
		this.currentSection = currentSection;
	}
	
	//-----Setters for updating the view with new text/image-----
	/**
	 * Shows in view the image given as parameter.
	 * The idea is to get the image from the model and 
	 * use this method to show it.
	 * @param image 
	 * 				BufferedImage to be shown in view
	 */
	public void showImage(BufferedImage image){
		imageLbl.setIcon(new ImageIcon(image));
	}
	
	
	//-----Other setters-----
	/**
	 * Searches after the String input in variable text. 
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public void findText(JEditorPane section, String input) {

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
	
	@Override
	public void focusGained(FocusEvent arg0) {
		if(arg0.getComponent() instanceof JEditorPane){
			//updateCurrentSection();
			currentSection.setBorder(null);
			currentSection = (JEditorPane)arg0.getComponent();
			Paint p = Color.black;
			//currentSection.setBorder(BorderFactory.createDashedBorder(p));
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		//Do nothing, the JEditorPane which is in focus will remain until another one is focused
		
	}
}
