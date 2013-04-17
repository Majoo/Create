package se.chalmers.tda367.group25.resumate.controllers;

import javax.swing.event.CaretEvent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class TextController {

	private Document doc;
	private RMText rmt = new RMText();
	
	//A method which updates the text stored in the documents sections.
	public void updateText(CaretEvent arg0, String text){
		
		rmt.setText(text);
		
		if (!doc.getTexts().containsKey(SectionType.WORK_EXPERIENCE) || 
			!doc.getTexts().containsKey(SectionType.PERSONAL_INFO) ){
			doc.createSections();
		}

		if (arg0.getSource().equals("workingExperienceText")){	
			doc.getTexts().put(SectionType.WORK_EXPERIENCE, rmt);
		}
		else if (arg0.getSource().equals("personalInfoText")){
			doc.getTexts().put(SectionType.WORK_EXPERIENCE, rmt);		
		}
			
			
			
	}
		
	
}
