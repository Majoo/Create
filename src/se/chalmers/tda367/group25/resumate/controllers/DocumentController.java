package se.chalmers.tda367.group25.resumate.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
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
		doc.changeTemplate(templateName);
		view.updateTextInView(templateName, doc.getTexts());
	}
}
