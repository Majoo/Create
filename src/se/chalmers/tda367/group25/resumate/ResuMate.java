package se.chalmers.tda367.group25.resumate;


import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.utils.Template;


public class ResuMate {
	
	private User user;
	private List<Document> docs = new ArrayList<Document>();

	/*An application with the default document is created.*/
	public ResuMate(){
		Document doc = new Document();
		docs.add(doc);
	}

	/*Creates a new document*/
	public void createDocument(Template templ){
		Document doc = new Document(templ);
		docs.add(doc);

	}

	/*Get the document of index i*/
	public Document getDoc(int i){
		return docs.get(i);

	}
	
	/*Quit. Documents should be saved*/
	public void quit(){
		
	}
}