package se.chalmers.tda367.group25.resumate.controllers;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.Template;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;

public class MainController {

	private DocumentController documentController;
	private IOController ioController;
	private MainView mainView;

	/* An application with the default document is created. */
	public MainController() {
		documentController = new DocumentController(new Document(),
				new DocumentView());
		ioController = new IOController();
	}

	// Isn't this unnecessary? New Documents should be created in
	// DocumentController, or?
	// /**
	// * Creates a new Document with the specified Template.
	// *
	// * @param templ
	// * the Template on which to base the Document
	// */
	// public void createDocument(Template templ) {
	// Document doc = new Document(templ);
	// }

	/**
	 * Quit. Documents should be saved
	 */
	public void quit() {

	}
}
