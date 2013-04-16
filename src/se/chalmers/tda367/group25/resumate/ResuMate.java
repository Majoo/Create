package se.chalmers.tda367.group25.resumate;


import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.utils.Template;


public class ResuMate {
	private List<Document> docs = new ArrayList<Document>();


	public ResuMate(){
		Document doc = new Document();
		docs.add(doc);
	}

	public void createDocument(Template templ){
		Document doc = new Document(templ);
		docs.add(doc);

	}

	public Document getDoc(int i){
		return docs.get(i);

	}
}