package se.chalmers.tda367.group25.resumate.model;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Template;

public class Document {

	private Template currentTempl;
	// Sections
	private Map<SectionType, RMText> texts = new HashMap<SectionType, RMText>(3);
	private RMImage rmI;

	private List<Document> history;

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
		history = new LinkedList<Document>();
		this.currentTempl = templ;
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
			if (!texts.containsKey(SectionType.HEADER)) {
				texts.put(SectionType.HEADER, new RMText(SectionType.HEADER));
			}

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
		// TODO Make clone safe
		return rmI;
	}

	/**
	 * Get the Map of the RMTexts of the Document. Used for IO purposes.
	 * 
	 * @return the Map of the RMTexts
	 */
	public Map<SectionType, RMText> getTexts() {
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
			strings.put(SectionType.HEADER, texts.get(SectionType.HEADER)
					.getText());
		}
		if (texts.containsKey(SectionType.PERSONAL_INFO)) {
			strings.put(SectionType.PERSONAL_INFO,
					texts.get(SectionType.PERSONAL_INFO).getText());
		}
		if (texts.containsKey(SectionType.WORK_EXPERIENCE)) {
			strings.put(SectionType.WORK_EXPERIENCE,
					texts.get(SectionType.WORK_EXPERIENCE).getText());
		}
		if (texts.containsKey(SectionType.EMPTY)) {
			strings.put(SectionType.EMPTY, texts.get(SectionType.EMPTY)
					.getText());
		}
		return strings;
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
		if (!texts.containsKey(SectionType.WORK_EXPERIENCE)
				|| !texts.containsKey(SectionType.PERSONAL_INFO)) {
			createSections();
		}

		texts.get(st).setText(text);
	}
}