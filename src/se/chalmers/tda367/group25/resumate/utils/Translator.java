package se.chalmers.tda367.group25.resumate.utils;

import java.awt.Container;
import java.awt.Panel;

import javax.swing.JEditorPane;

import se.chalmers.tda367.group25.resumate.model.SectionType;
import se.chalmers.tda367.group25.resumate.model.Template;

public class Translator {

	/**
	 * Translates a DocumentView Panel to a Template.
	 * 
	 * @param p
	 *            the Panel to translate
	 * @return the corresponding Template
	 */
	public static Template panelToTemplate(Panel p) {
		
		String name  = p.getName();
		Template template = null;
		switch(name){
		case "CV_Def":
			template = Template.DEF_CV;
			break;
		
		default: //Do nothing, never invoked.
		
		}
		return template;
		
	}

	/**
	 * Translates a Container, typically a JEditorPane, to a SectionType.
	 * 
	 * @param c
	 *            the Container to translate
	 * @return the corresponding SectionType
	 */

	public static SectionType containerToSectionType(JEditorPane container) {
		
		String name = container.getName();
		SectionType section = null;
		
		switch(name){
		case "personalInfoText":
			section = SectionType.PERSONAL_INFO;
			break;
		case "workingExperienceText":
			section = SectionType.WORK_EXPERIENCE;
			break;
		case "otherText":
			section = SectionType.EMPTY;
			break;
		default: //Do nothing, never invoked.
		
		}
		return section;
	}
	
}
