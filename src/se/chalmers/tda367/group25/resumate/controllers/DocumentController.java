package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.concreteTemplatePanels.CV_Def;

public class DocumentController implements PropertyChangeListener{

	// Each value (List) holds a Document object and a DocumentView object
	private Map<String, List<Object>> docAndDocView;
	
	/**
	 * Constructs a new DocumentController with the 
	 * DocumentView to be placed in the docAndDocView Map. Max elements in
	 * the Map is set to 20.
	 */
	public DocumentController() {
		//instantiate map
		this.docAndDocView = new HashMap<String, List<Object>>(20);
		
		//create first document+view 
		Document d = new Document();
		DocumentView v = new DocumentView();
		v.addPropertyChangeListener(this);
		
		//and put it in the map
		List<Object> first = new ArrayList(2);
		first.add(d);
		first.add(v);
		this.docAndDocView.put(generateKey(), first);

	}

	/**
	 * Adds a new Document to the corresponding value (List) in the
	 * docAndDocView Map.
	 * 
	 * @param ID
	 *            the ID to give to the Document
	 * @param d
	 *            the Document to add
	 */
	public void addDoc(String ID, Document d) {
		if(!docAndDocView.containsKey(ID)){
			docAndDocView.put(ID, null);
		}
		docAndDocView.get(ID).add(d);
	}


	/**
	 * Adds a new DocumentView to the corresponding value (List) in the
	 * docAndDocView Map.
	 * 
	 * @param ID
	 *            the ID to give to the DocumentView
	 * @param v
	 *            the DocumentView to add
	 */
	public void addDocView(String ID, DocumentView v) {
		if(!docAndDocView.containsKey(ID)){
			docAndDocView.put(ID, null);
		}
		docAndDocView.get(ID).add(v);

	}

	/**
	 * Returns the Document from the value (List) in the Map docAndDocView
	 * specified by the parameter ID. 
	 * 
	 * @param ID
	 *            the ID of the Document to return
	 * @return the Document in given by the parameter ID
	 */
	public Document getDoc(String ID) {
		List<Object> list = docAndDocView.get(ID);
		Document doc;
		for(Object o: list){
			if(o instanceof Document){
				doc = (Document) o;
				return doc;
			}
		}
		return null;

	}

	/**
	 * Returns the DocumentView from the value (List) in the Map docAndDocView
	 * specified by the parameter ID.
	 * 
	 * @param ID
	 *            the ID of the DocumentView to return
	 * @return the DocumentView given by the parameter ID
	 */
	public DocumentView getView(String ID) {
		List<Object> list = docAndDocView.get(ID);
		DocumentView v;
		for(Object o: list){
			if(o instanceof DocumentView){
				v = (DocumentView) o;
				return v;
			}
		}
		return null;
	}

	/**
	 * Handles Events from the DocumentView objects in the docAndDocView Map.
	 * 
	 * @param e
	 *            the Event to handle
	 */
	public void propertyChange(PropertyChangeEvent e) {
		
		//Get the pair of Doc & DocView that are concerned (Stored in "value").
		List<Object> curDocAndDocView = null;
		for(List<Object> value: docAndDocView.values()){
			if(value.contains(e.getSource())){
				curDocAndDocView = value;
			}
		}
		//Separate the Doc and the DocView into "d" and "v".
		Document d;
		DocumentView v;
		for(Object o: curDocAndDocView){
			if(o instanceof Document){
				d = (Document)o;
			}
			if(o instanceof DocumentView){
				v = (DocumentView)o;
			}
		}
		
		//Do what needs to be done according to Label.
		switch(e.getPropertyName()){
		//Image handling:
		case  Labels.INSERT_IMAGE:
			
			break;
			
		case  Labels.CROP_IMAGE:
			
			break;
			
		case  Labels.RESIZE_IMAGE:
			
			break;
			
		case  Labels.REORIENT_IMAGE:
			
			break;
		//Text handling:
		}
		
	}

	/**
	 * Randomly generates a key for a value in the docAndDocView Map.
	 * 
	 * @return random key
	 */
	private String generateKey() {
		return "apa";
	}
}
