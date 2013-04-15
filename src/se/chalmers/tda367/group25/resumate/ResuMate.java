package se.chalmers.tda367.group25.resumate;

import java.util.ArrayList;
import java.util.List;

public class ResuMate {
	
	private List<Document> docs = new ArrayList<Document>();
	
	public ResuMate(){
		Document doc = new Document();
		docs.add(doc);
		//return;
	}
	
	public void createDocument(String templ){
		Document doc = new Document(TemplateStorage.getTemplate(templ));
		docs.add(doc);
	}
	
	public Document getDoc(int i){
		return docs.get(i);
	}

}