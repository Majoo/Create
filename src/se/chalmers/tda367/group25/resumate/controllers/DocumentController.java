package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.views.DocumentView;

public class DocumentController {

	// Each value (List) holds a Document object and a DocumentView object
	private Map<String, List<Object>> docAndDocView;

	/**
	 * Constructs a new DocumentController with its first Document and first
	 * DocumentView to be placed in the docAndDocView Map.
	 * 
	 * @param doc
	 *            the first Document
	 * @param v
	 *            the first DocumentView
	 */
	public DocumentController() {
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
		return null;
	}

	/**
	 * Handles Events from the DocumentView objects in the docAndDocView Map.
	 * 
	 * @param e
	 *            the Event to handle
	 */
	public void propertyChange(PropertyChangeEvent e) {

	}

	/**
	 * Randomly generates a key for a value in the docAndDocView Map.
	 * 
	 * @return random key
	 */
	private String generateKey() {
		return null;
	}
}
