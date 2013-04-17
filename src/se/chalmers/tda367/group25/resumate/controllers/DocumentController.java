package se.chalmers.tda367.group25.resumate.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Template;
import se.chalmers.tda367.group25.resumate.utils.TemplateToSections;
import se.chalmers.tda367.group25.resumate.views.ResumateView;

public class DocumentController {

	private Document doc;
	private ResumateView view;
	
	public DocumentController(ResumateView v){
		doc = new Document();
		view = v;
	}
	
	public void changedTemplate(Template templateName){
		List <SectionType> secs = TemplateToSections.translate(templateName);
		List <String> text = new ArrayList <String>(3);
			for(int i = 0; i < secs.size(); i++) {
				text.add(doc.getTexts().get(secs.get(i)).getText());
			}
		doc.changeTemplate(templateName);
		view.updateTextInView(templateName, text);
	}
}
