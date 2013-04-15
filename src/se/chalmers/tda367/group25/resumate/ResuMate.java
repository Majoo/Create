package se.chalmers.tda367.group25.resumate;



import java.util.ArrayList;

import java.util.List;



import se.chalmers.tda367.group25.resumate.utils.TemplateStorage;


public class ResuMate {

	

	private List<Document> docs = new ArrayList<Document>();

	

	public ResuMate(){

		Document doc = new Document();

		docs.add(doc);

	}

	

	public void createDocument(String templ){

		Document doc = new Document(TemplateStorage.getTemplate(templ));

		docs.add(doc);

	}

	

	public Document getDoc(int i){

		return docs.get(i);

	}



}