package se.chalmers.tda367.group25.resumate.controllers;
import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.controllers.DocumentController;
import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.views.DocumentView;


public class DocumentControllerTest {
	DocumentController docCon = new DocumentController();
	DocumentView dv = new DocumentView();

	@Test
	public void addDocViewTest() {
		String ID = "ID";
		docCon.addDocView(ID, dv);

		assert(docCon.getView(ID)== dv);
	}
	
	@Test
	public void getDocTest() {		
		Document doc = docCon.getDoc(docCon.getCurrent());
		
		assert(docCon.getDoc(docCon.getCurrent()) != null);
		
	}
	
	@Test
	public void separateDocTest() {
		docCon.addDocView("first", dv);
		Document doc = docCon.separateDocument(dv);
		
		assert(doc == docCon.getDoc("first"));
		
	}

}
