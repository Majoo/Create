package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class TextController {

	private Document doc;

	public TextController(Document doc) {
		this.doc = doc;
	}

	// A method which updates the text stored in the documents sections.
	public void updateText(InputMethodEvent arg0, String text) {

		if (arg0.getSource().equals("workingExperienceText")) {
			doc.changeText(SectionType.WORK_EXPERIENCE, text);
		} else if (arg0.getSource().equals("personalInfoText")) {
			doc.changeText(SectionType.PERSONAL_INFO, text);
		}

	}

	public void updateText(ActionEvent arg0, String text) {

		if (arg0.getSource().equals("workingExperienceText")) {
			doc.changeText(SectionType.WORK_EXPERIENCE, text);
		} else if (arg0.getSource().equals("personalInfoText")) {
			doc.changeText(SectionType.PERSONAL_INFO, text);
		}

	}

}
