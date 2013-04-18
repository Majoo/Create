package se.chalmers.tda367.group25.resumate.controllers;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Template;
import se.chalmers.tda367.group25.resumate.views.DocumentView;

public class DocumentController {

	private Document doc;
	private DocumentView view;
	
	public DocumentController(DocumentView v, Document doc){
		this.doc = doc;
		view = v;
	}
	
	public void changedTemplate(Template templateName){
		
		//Skicka hela map:en
		/*Map <String> text = new ArrayList <String>(3);
		text = doc.getTexts().
			for(int i = 0; i < secs.size(); i++) {
				text.add(doc.getTexts().get(secs.get(i)).getText());
			}
		doc.changeTemplate(templateName);
		view.updateTextInView(templateName, text);*/
	}
}
