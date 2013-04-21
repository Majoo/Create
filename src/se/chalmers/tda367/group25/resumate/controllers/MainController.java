package se.chalmers.tda367.group25.resumate.controllers;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.Template;

public class MainController {

	private DocumentController documentController;
	private IOController ioController;

	/*An application with the default document is created.*/
	public MainController(){
		documentController = new DocumentController();
		ioController = new IOController();
	}

	/*Creates a new document with the specified template*/
	public void createDocument(Template templ){
		Document doc = new Document(templ);
	}
	
	/*Quit. Documents should be saved*/
	public void quit(){
		
	}
}
