package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.views.DocumentView;

public class DocumentController {

	// Each value (List) holds a Document object and a DocumentView object
	private Map<Integer, List<Object>> docAndDocView;
	// The current used set of Document and DocumentView
	private int curID;

	/**
	 * Constructs a new DocumentController with the DocumentView to be placed in
	 * the docAndDocView Map. Max elements in the Map is set to 20.
	 */
	public DocumentController() {
		// Instantiate Map
		this.docAndDocView = new HashMap<Integer, List<Object>>(20);
		
		//create first document
		Document d = new Document();
		List<Object> first = new ArrayList(2);
		first.add(d);
		
		setCurrentID(0);
		this.docAndDocView.put(getCurrentID(), first);
	}

	//GETTERS
	/**
	 * Get the Document in the List<Object> given
	 * @param pair
	 * 				the pair to be separated
	 */
	public Document separateDoc(List<Object> pair){
		Document d = null;
		for (Object o : pair) {
			if (o instanceof Document) {
				d = (Document) o;
			}
		}
		return d;
	}
	
	/**
	 * Get the DocumentView in the List<Object> given
	 * @param pair
	 * 				the pair to be separated
	 */
	public DocumentView separateDocView(List<Object> pair){
		DocumentView v = null;
		for (Object o : pair) {
			if (o instanceof DocumentView) {
				v = (DocumentView) o;
			}
		}
		return v;
	}
	
	/**
	 * Get the Document associated with the DocumentView given as parameter.
	 * @param
	 * 			docView - the DocumentView to extract the Document from
	 */
	public Document separateDocument(DocumentView docView){
		//Get the List that contains the DocView
		List<Object> curDocAndDocView = null;
		for (List<Object> value : this.docAndDocView.values()) {
			if (value.contains(docView)) {
				curDocAndDocView = value;
			}
		}
		//Get the Document from this List
		Document d = null;
		for(Object o: curDocAndDocView){
			if(o instanceof Document){
				d = (Document)o;
			}
		}
		System.out.println(d+" in docCon.separateDocument(docview)");
		return d;
	}

	
	/**
	 * Returns the Key to the current DocAndDocView couple currently in use by
	 * the user.
	 * 
	 * @return The String Key to the current couple
	 */
	public int getCurrentID() {
		return this.curID;
	}

	/**
	 * Returns the Document from the value (List) in the Map docAndDocView
	 * specified by the parameter ID.
	 * 
	 * @param ID
	 *            the ID of the Document to return
	 * @return the Document in given by the parameter ID
	 */
	public Document getDoc(int id) {
		List<Object> list = docAndDocView.get(new Integer(id));
		Document doc;
		for (Object o : list) {
			if (o instanceof Document) {
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
	public DocumentView getView(int id) {
		List<Object> list = docAndDocView.get(new Integer(id));
		DocumentView v;
		for (Object o : list) {
			if (o instanceof DocumentView) {
				v = (DocumentView) o;
				return v;
			}
		}
		return null;
	}
	
	//SETTERS
	/**
	 * Update the image of the Document associated with the BufferedImage img.
	 * 
	 * @param doc
	 * 					The Document to put the BufferedImage in
	 * @param img
	 * 					The BufferedImage to put in the Document
	 */
	public void updateImage(Document doc, BufferedImage img) {
		doc.setImage(img);
		
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
	public void addDoc(int ID, Document d) {
		List<Object> list;
		if (!docAndDocView.containsKey(ID)) {
			list = new ArrayList<Object>(2);
			docAndDocView.put(ID, list);
		}
		docAndDocView.get(ID).add(d);
		//Problem: om listan redan finns och redan innehåller en av varje.

	}

	/**
	 * Adds the DocumentView to the list put as a value of the key ID.
	 * 
	 * @param ID
	 *            the ID to put the DocumentView under
	 * @param v
	 *            the DocumentView to add
	 */
	public void addDocView(int ID, DocumentView v) {
		List<Object> list;
		if (!docAndDocView.containsKey(ID)) {
			list = new ArrayList<Object>(2);
			docAndDocView.put(ID, list);
		}
		docAndDocView.get(ID).add(v);
		//Problem: om listan redan finns och redan innehåller en av varje.

	}

	/**
	 * Sets which DocAndDocView couple is the one currently in use by the user.
	 * 
	 * @param current
	 *            the String Key
	 */
	public void setCurrentID(int currentID) {
		this.curID = currentID;
	}
		
}
