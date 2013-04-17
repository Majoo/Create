package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.event.InputMethodEvent;

import javax.swing.event.CaretEvent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class TextController {

	private Document doc;
	private RMText rmt = new RMText();
	
	public TextController(){
		doc = new Document();
	}
	
	//A method which updates the text stored in the documents sections.
	public void updateText(InputMethodEvent arg0, String text){
		
		if (arg0.getSource().equals("workingExperienceText")){	
			doc.changeText(SectionType.WORK_EXPERIENCE, text);
		}
		else if (arg0.getSource().equals("personalInfoText")){
			doc.changeText(SectionType.PERSONAL_INFO, text);		
		}
			
			
			
	}
		
	
}
