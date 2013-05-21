package se.chalmers.tda367.group25.resumate.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.controllers.DocumentController;
import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.views.DocumentView;


public class DocConTest {

	@Test
	public void addDocViewTest() {
		DocumentController docCon = new DocumentController();
		DocumentView dv = new DocumentView();
		String ID = "ID";
		
		docCon.addDocView(ID, dv);

		assert(docCon.getView(ID)== dv);
	}
	
	@Test
	public void getDocTest() {
		DocumentController docCon = new DocumentController();
		
		Document doc = docCon.getDoc(docCon.getCurrent());
		
		assert(docCon.getDoc(docCon.getCurrent()) != null);
		
	}
	
	@Test
	public void separateDocTest() {
		DocumentController docCon = new DocumentController();
		DocumentView dv = new DocumentView();
		
		docCon.addDocView("first", dv);
		
		Document doc = docCon.separateDocument(dv);
		
		assert(doc == docCon.getDoc("first"));
		
	}

}
