package se.chalmers.tda367.group25.resumate.model;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Template;

public class Document implements DocumentInterface{

	private Template currentTempl;
	// Sections
	private Map<SectionType, ITextSection> texts = new HashMap<SectionType, ITextSection>(4);
	private RMImage rmI;

	// Unsurprisingly, the path to the file representation of this Document is
	// stored here. This variable is used for "quick save" functionality.
	private String filePath = "";

	/**
	 * Create a new Document using the default Template.
	 */
	public Document() {
		this(Template.DEF_CV);
	}

	/**
	 * Create a new Document using the specified Template.
	 * 
	 * @param templ
	 *            the Template to which currentTempl will be set
	 */
	public Document(Template templ) {
		// Set variables
		this.currentTempl = templ;
		rmI = new RMImage(null);
		// create Sections according to Template.
		createSections();
	}

	/**
	 * Create necessary Sections according to Template. Checks if Sections have
	 * already been created; if they haven't, this method creates them
	 */
	private void createSections() {
		switch (currentTempl) {

		case DEF_CV:

			if (!texts.containsKey(SectionType.PERSONAL_INFO)) {
				texts.put(SectionType.PERSONAL_INFO, new PersonalInformationSection());
			}
			if (!texts.containsKey(SectionType.HEADER)) {
				texts.put(SectionType.HEADER, new Header());
			}
			if (!texts.containsKey(SectionType.WORK_EXPERIENCE)) {
				texts.put(SectionType.WORK_EXPERIENCE, new TextSection(
						SectionType.WORK_EXPERIENCE));
			}
			
			break;
		case DEF_PL:
			if (!texts.containsKey(SectionType.PERSONAL_INFO)) {
				texts.put(SectionType.PERSONAL_INFO, new TextSection(
						SectionType.PERSONAL_INFO));
			}
			if (!texts.containsKey(SectionType.HEADER)) {
				texts.put(SectionType.HEADER, new Header());
			}
			if (!texts.containsKey(SectionType.WORK_EXPERIENCE)) {
				texts.put(SectionType.WORK_EXPERIENCE, new TextSection(
						SectionType.WORK_EXPERIENCE));
			}

			break;
		case CLASSY_CV:
			if (!texts.containsKey(SectionType.PERSONAL_INFO)) {
				texts.put(SectionType.PERSONAL_INFO, new PersonalInformationSection());
			}
			if (!texts.containsKey(SectionType.HEADER)) {
				texts.put(SectionType.HEADER, new Header());
			}
			if (!texts.containsKey(SectionType.WORK_EXPERIENCE)) {
				texts.put(SectionType.WORK_EXPERIENCE, new TextSection(
						SectionType.WORK_EXPERIENCE));
			}
			if (!texts.containsKey(SectionType.EDUCATION)) {
				texts.put(SectionType.EDUCATION, new TextSection(
						SectionType.EDUCATION));
			}
			break;
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
	public Map<SectionType, ITextSection> getTexts() {
		// TODO Make clone safe
		return texts;
	}

	/**
	 * Gets the Strings from the Map of RMTexts. Used
	 * 
	 * @return List of Strings
	 */
	public Map<SectionType, String> getStrings() {
		Map<SectionType, String> strings = new HashMap<SectionType, String>(
				texts.size());
		if (texts.containsKey(SectionType.HEADER)) {
			
			for (String text: texts.get(SectionType.HEADER).getText())	
			strings.put(SectionType.HEADER, text);
		}
		if (texts.containsKey(SectionType.PERSONAL_INFO)) {
			for(String text: texts.get(SectionType.PERSONAL_INFO).getText())
			strings.put(SectionType.PERSONAL_INFO, text);
		}
		if (texts.containsKey(SectionType.WORK_EXPERIENCE)) {
			for(String text: texts.get(SectionType.WORK_EXPERIENCE).getText())
			strings.put(SectionType.WORK_EXPERIENCE, text);
		}
		if (texts.containsKey(SectionType.EDUCATION)) {
			for(String text: texts.get(SectionType.EDUCATION).getText())
			strings.put(SectionType.EDUCATION, text);
		}
		return strings;
	}

	/**
<<<<<<< HEAD
	 * Gets the FilePath of the
=======
	 * Gets the FilePath of the Document
>>>>>>> master
	 * 
	 * @return 
	 * 			the FilePath of the Document
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
	public void setTemplate(Template tmpl) {
		this.currentTempl = tmpl;
		createSections();
	}

	/**
	 * Change the content of an RMText in the Map of the RMTexts of the
	 * Document. If the specified RMText Section doesn't exist, create it
	 * 
	 * @param st
	 *            the SectionType identity of the RMText
	 * @param text
	 *            the text to change to
	 */
	public void setText(SectionType st, String text) {
		if (!texts.containsKey(st)) {
			createSections();
		}

		//texts.get(st).setText(text);
	}

	/**
	 * 
	 * @param strings
	 */
	public void setAllTexts(Map<SectionType, String> strings) {
//		texts.putAll(strings);
	}
}