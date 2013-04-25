package se.chalmers.tda367.group25.resumate.views;

import java.awt.Container;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

public abstract class TemplatePanel extends JPanel {

	private Container PersonalInfoText;
	private Container  WorkingExperienceText;
	private Container  OtherText;
	private Container imageContainer;
	private PropertyChangeSupport pcs;
	
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
	 * Searches after the String input in variable text
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public void findText(String input, JEditorPane section){
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
	
}
