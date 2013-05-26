package se.chalmers.tda367.group25.resumate.model;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

/**
 * A class to describe a document. A document has a template, a String,
 * text sections, an image and a FilePath. These can be set.
 */
public class Document implements DocumentInterface {

	private String currentTempl;
	private Map<SectionType, ITextSection> textSections = new HashMap<SectionType, ITextSection>(4);
	private Map<SectionType, String> texts = new HashMap<SectionType, String>(
			textSections.size());
	private RMImage rmI;

	// Unsurprisingly, the path to the file representation of this Document is
	// stored here. This variable is used for "quick save" functionality.
	private String filePath = "";

	/**
	 * Create a new Document using the default Template.
	 */
	public Document() {
		this("DEF_CV");
	}

	/**
	 * Create a new Document using the specified Template.
	 * 
	 * @param templ
	 *            the Template to which currentTempl will be set
	 */
	public Document(String templ) {
		// Set variables
		this.currentTempl = templ;
		rmI = new RMImage(null);
		// create Sections according to Template.
		createSections();
	}

	/*
	 * Create necessary Sections according to Template.
	 */
	private void createSections() {
		switch (currentTempl) {

		case "DEF_CV":
			checkSections(SectionType.INFO_TITLE);
			checkSections(SectionType.PERSONAL_INFO);
			checkSections(SectionType.HEADER);
			checkSections(SectionType.WORK_EXPERIENCE);
			checkSections(SectionType.EDUCATION_EXPERIENCE);
			break;
			
		case "DEF_PL":
			checkSections(SectionType.PERSONAL_INFO);
			checkSections(SectionType.HEADER);
			checkSections(SectionType.WORK_EXPERIENCE);
			break;
			
		case "CLASSY_CV":
			checkSections(SectionType.PERSONAL_INFO);
			checkSections(SectionType.HEADER);
			checkSections(SectionType.WORK_EXPERIENCE);
			break;	
		}
	}
	
	/**
	 * Checks if Sections have already been created; if they haven't, this method creates them.
	 * @param type
	 * 			the section to be checked
	 */
	private void checkSections(SectionType type){
		if (!textSections.containsKey(type)) {
			if(type.toString().contains("HEADER")){
				textSections.put(type, new SingleRowSection(25));
			} else if(type.toString().contains("PERSONAL") || type.toString().contains("TITLE")){
				textSections.put(type, new SingleRowSection(12));	
			}else if (type.toString().contains("EXPERIENCE")){
				textSections.put(type, new MultiRowSection());
			}
		}
	}
	
	// ---Getters---//

	/**
	 * Get the image in the RMImage of the Document.
	 * 
	 * @return the image
	 */
	public RMImage getImage() {
		// TODO Make clone safe
		return rmI;
	}

	/**
	 * Get the Map of the RMTexts of the Document. Used for IO purposes.
	 * 
	 * @return the Map of the RMTexts
	 */
	public Map<SectionType, ITextSection> getSectionTexts() {
		// TODO Make clone safe
		return textSections;
	}

	/**
	 * Gets the Strings from the Map of RMTexts. Used
	 * 
	 * @return List of Strings
	 */
	public Map<SectionType, String> getTexts() {
		return texts;
	}

	/**
	 * Gets the FilePath of the Document
	 * 
	 * @return 
	 * 		the FilePath of the Document
	 */
	public String getFilePath() {
		return filePath;
	}

	// ---Setters---//

	/**
	 * Sets the image of the RMImage of the Document.
	 * 
	 * @param image
	 *            image to be used in the document
	 */
	public void setImage(BufferedImage image) {
		this.rmI.setImage(image);
	}

	/**
	 * Change the Template and create Sections accordingly.
	 * 
	 * @param tmpl
	 *            the Template to change to
	 */
	public void setTemplate(String tmpl) {
		this.currentTempl = tmpl;
		createSections();
	}

	/**
	 * Saves the text from the sectiontype in textsections
	 * @param name
	 * 			the sectiontype which is to save text
	 * @param text
	 * 			the string which is to be saved
	 */
	public void setText(SectionType name, String text){
		if(name.toString().contains("PERSONAL")){
			SingleRowSection personalSec = (SingleRowSection)textSections.get(SectionType.PERSONAL_INFO);
			personalSec.setText(name, text);
			System.out.println(name +": " + personalSec.getText(name));
		}
		else if(name.toString().contains("HEADER")){
			SingleRowSection headerSec = (SingleRowSection)textSections.get(SectionType.HEADER);
			headerSec.setText(name, text);
		}
		else if(name.toString().contains("TITLE")){
			SingleRowSection headerSec = (SingleRowSection)textSections.get(SectionType.INFO_TITLE);
			headerSec.setText(name, text);
		}
		else if(name.toString().contains("EXPERIENCE")){
			MultiRowSection multiRowSec = (MultiRowSection)textSections.get(name);
			multiRowSec.setText(text);
		}
	}
	
	/**
	 * Saves all the texts in the text sections to the map texts.
	 */
	public void setAllTexts() {
		System.out.println("In setAllTexts");
		if (textSections.containsKey(SectionType.HEADER)) {
			SingleRowSection headerSec = (SingleRowSection)textSections.get(SectionType.HEADER);
			texts.put(SectionType.WORK_HEADER, headerSec.getText(SectionType.WORK_HEADER));
			texts.put(SectionType.EDU_HEADER, headerSec.getText(SectionType.EDU_HEADER));
		}
		if (textSections.containsKey(SectionType.INFO_TITLE)) {
			SingleRowSection titleSec = (SingleRowSection)textSections.get(SectionType.HEADER);
			texts.put(SectionType.NAME_TITLE, titleSec.getText(SectionType.NAME_TITLE));
			texts.put(SectionType.ADDRESS_TITLE, titleSec.getText(SectionType.ADDRESS_TITLE));
			texts.put(SectionType.CITYZIPCODE_TITLE, titleSec.getText(SectionType.CITYZIPCODE_TITLE));
			texts.put(SectionType.PHONE_TITLE, titleSec.getText(SectionType.PHONE_TITLE));
			texts.put(SectionType.EMAIL_TITLE, titleSec.getText(SectionType.EMAIL_TITLE));
			texts.put(SectionType.EMPTY1_TITLE, titleSec.getText(SectionType.EMPTY1_TITLE));
			texts.put(SectionType.EMPTY2_TITLE, titleSec.getText(SectionType.EMPTY2_TITLE));
		}
		if (textSections.containsKey(SectionType.PERSONAL_INFO)) {
			SingleRowSection personalSec = (SingleRowSection)textSections.get(SectionType.PERSONAL_INFO);
			texts.put(SectionType.NAME_PERSONAL, personalSec.getText(SectionType.NAME_PERSONAL));
			texts.put(SectionType.ADDRESS_PERSONAL, personalSec.getText(SectionType.ADDRESS_PERSONAL));
			texts.put(SectionType.CITYZIPCODE_PERSONAL, personalSec.getText(SectionType.CITYZIPCODE_PERSONAL));
			texts.put(SectionType.PHONE_PERSONAL, personalSec.getText(SectionType.PHONE_PERSONAL));
			texts.put(SectionType.EMAIL_PERSONAL, personalSec.getText(SectionType.EMAIL_PERSONAL));
			texts.put(SectionType.EMPTY1_PERSONAL, personalSec.getText(SectionType.EMPTY1_PERSONAL));
			texts.put(SectionType.EMPTY2_PERSONAL, personalSec.getText(SectionType.EMPTY2_PERSONAL));
		}
		if (textSections.containsKey(SectionType.WORK_EXPERIENCE)) {
			MultiRowSection workSec = (MultiRowSection)textSections.get(SectionType.WORK_EXPERIENCE);
			texts.put(SectionType.WORK_EXPERIENCE, workSec.getText());
		}
		if (textSections.containsKey(SectionType.EDUCATION_EXPERIENCE)) {
			MultiRowSection eduSec = (MultiRowSection)textSections.get(SectionType.EDUCATION_EXPERIENCE);
			texts.put(SectionType.EDU_HEADER, eduSec.getText());
		}
	}
	@Override
	public boolean hasFilePath() {
		return !(filePath.isEmpty());
	}
}