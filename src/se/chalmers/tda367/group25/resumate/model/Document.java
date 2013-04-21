package se.chalmers.tda367.group25.resumate.model;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class Document {

	private Template currentTempl;
	// Sections
	private Map<SectionType, RMText> texts = new HashMap<SectionType, RMText>(3);
	private RMImage rmI;

	private History history;

	/**
	 * Create a new Document using the default Template.
	 */
	public Document() {
		new Document(Template.DEF_CV);
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
		history = new History();
		rmI = new RMImage(null);
		// create Sections according to Template.
		createSections();
	}

	/**
	 * Create necessary Sections according to Template. Checks if Sections have
	 * already been created; if they haven't, this method creates them
	 */
	public void createSections() {
		switch (currentTempl) {

		case DEF_CV:

			if (!texts.containsKey(SectionType.PERSONAL_INFO)) {
				texts.put(SectionType.PERSONAL_INFO, new RMText(
						SectionType.PERSONAL_INFO));
			}
			if (!texts.containsKey(SectionType.WORK_EXPERIENCE)) {
				texts.put(SectionType.WORK_EXPERIENCE, new RMText(
						SectionType.WORK_EXPERIENCE));
			}
			// texts.add(new RMText(SectionType.EMPTY));
			break;
		case DEF_PL:
			if (!texts.containsKey(SectionType.PERSONAL_INFO)) {
				texts.put(SectionType.PERSONAL_INFO, new RMText(
						SectionType.PERSONAL_INFO));
			}
			// texts.add(new RMText(SectionType.EMPTY));
			break;
		case CLASSY_CV:
			if (!texts.containsKey(SectionType.PERSONAL_INFO)) {
				texts.put(SectionType.PERSONAL_INFO, new RMText(
						SectionType.PERSONAL_INFO));
			}
			if (!texts.containsKey(SectionType.WORK_EXPERIENCE)) {
				texts.put(SectionType.WORK_EXPERIENCE, new RMText(
						SectionType.WORK_EXPERIENCE));
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
		return rmI;
	}

	// ---Setters---//

	/**
	 * Sets the image of the RMImage of the Document.
	 * 
	 * @param image
	 *            image to be used in the document
	 */
	public void setImage(Image image) {
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
	 * Get the Map of the RMTexts of the Document.
	 * 
	 * @return the Map of the RMTexts
	 */
	public Map<SectionType, RMText> getTexts() {
		return texts;
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
	public void changeText(SectionType st, String text) {
		if (!texts.containsKey(SectionType.WORK_EXPERIENCE)
				|| !texts.containsKey(SectionType.PERSONAL_INFO)) {
			createSections();
		}

		texts.get(st).setText(text);
	}

	/**
	 * Change the Template of the Document.
	 * 
	 * @param temp
	 *            the Template to change to
	 */
	public void changeTemplate(Template temp) {
		/*
		 * List <SectionType> secs = TemplateToSections.translate(temp); List
		 * <String> text = new ArrayList <String>(3); for(int i = 0; i <
		 * secs.size(); i++) { text.add(texts.get(secs.get(i)).getText()); }
		 */
		setTemplate(temp);
	}

}