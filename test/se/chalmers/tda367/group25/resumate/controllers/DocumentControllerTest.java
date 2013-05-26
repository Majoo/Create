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
		int id = 2;
		docCon.addDocView(id, dv);

		assertTrue(docCon.getView(id) == dv);
	}

	@Test
	public void getDocTest() {
		assertTrue(docCon.getDoc(docCon.getCurrentID()) != null);

	}

	@Test
	public void separateDocTest() {
		docCon.addDocView(3, dv);
		Document doc = docCon.separateDocument(dv);

		assertTrue(doc == docCon.getDoc(3));

	}

}
