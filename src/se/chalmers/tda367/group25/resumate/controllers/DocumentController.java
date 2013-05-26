package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.views.DocumentView;

public class DocumentController implements PropertyChangeListener{
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	// Each value (List) holds a Document object and a DocumentView object
	private Map<Integer, List<Object>> docAndDocView;
	// The current used set of Document and DocumentView
	private int curID;

	/**
	 * Constructs a new DocumentController with the first Document.
	 * Documents and DocumentViews are paired up, the DocumentView
	 * shows the Document it is paired up with. You can only have 20 
	 * Documents at once.
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

	// ---GETTERS--- //	
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
		return d;
	}

	
	/**
	 * Returns the Key to the Document and DocumentView couple currently in use.
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
		List<Object> list = docAndDocView.get(Integer.valueOf(id));
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
		List<Object> list = docAndDocView.get(Integer.valueOf(id));
		DocumentView v;
		for (Object o : list) {
			if (o instanceof DocumentView) {
				v = (DocumentView) o;
				return v;
			}
		}
		return null;
	}
	
	// ---SETTERS--- //
	
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
	 * Saves the texts from the template to the document
	 */
	public void saveTexts(){
		//Setting texts for personal information
		getDoc(getCurrentID()).setText(SectionType.NAME_PERSONAL, getView(getCurrentID()).getTemplatePanel().getNameField().getText());
		getDoc(getCurrentID()).setText(SectionType.ADDRESS_PERSONAL, getView(getCurrentID()).getTemplatePanel().getAddressField().getText());
		getDoc(getCurrentID()).setText(SectionType.CITYZIPCODE_PERSONAL, getView(getCurrentID()).getTemplatePanel().getCityField().getText());
		getDoc(getCurrentID()).setText(SectionType.PHONE_PERSONAL, getView(getCurrentID()).getTemplatePanel().getPhoneField().getText());
		getDoc(getCurrentID()).setText(SectionType.EMAIL_PERSONAL, getView(getCurrentID()).getTemplatePanel().getEmailField().getText());
		getDoc(getCurrentID()).setText(SectionType.EMPTY1_PERSONAL, getView(getCurrentID()).getTemplatePanel().getEmptyField1().getText());
		getDoc(getCurrentID()).setText(SectionType.EMPTY2_PERSONAL, getView(getCurrentID()).getTemplatePanel().getEmptyField2().getText());
		
		//Setting texts for work experience and education
		getDoc(getCurrentID()).setText(SectionType.WORK_EXPERIENCE, getView(getCurrentID()).getTemplatePanel().getWorkingExperienceText().getText());
		getDoc(getCurrentID()).setText(SectionType.EDUCATION, getView(getCurrentID()).getTemplatePanel().getEducationText().getText());
		
		//Setting texs for the headers
		getDoc(getCurrentID()).setText(SectionType.WORK_HEADER,getView(getCurrentID()).getTemplatePanel().getWorkExpHeader().getText());
		getDoc(getCurrentID()).setText(SectionType.EDU_HEADER, getView(getCurrentID()).getTemplatePanel().getEduHeader().getText());

		//Save text to model
		getDoc(getCurrentID()).setAllTexts();
	}
	
	//-----PropertyChanged-Methods------
	
	 /** Adds a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be registered
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be unregistered
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}
	

	/**
	 * Fires the propertychange event further to the main controller
	 * where the events are to be handled.
	 * 
	 * @param arg0
	 * 		the source of the event
	 * 		
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		try{
			pcs.firePropertyChange(arg0.getPropertyName(),arg0.getOldValue(),
					arg0.getNewValue());
		} catch (NullPointerException e){
			System.out.println("Caught NullPointerException " +
					"in DocumentControllers propertyChange");
		}
	}	
}
