package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeEvent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;

public class MainController {

	private DocumentController documentController;
	private IOController ioController;
	private MainView mainView;

	/* An application with the default document is created. */
	public MainController() {
		documentController = new DocumentController();
		ioController = new IOController();
	}

	/**
	 * Handles Events from further down in the hiearchy, eg. MainView
	 * by switching depending on which label the eventname is given.
	 * 
	 * @param e
	 *            the Event to handle
	 */
	public void propertyChange(PropertyChangeEvent e) {
		
		switch(e.getPropertyName()){
			case "TEXT_ENTERED":
				
				break;
		
			case "TEXTFONT_CHANGED":
				
				break;	
			
			case "TEXTSIZE_CHANGED":
				
				break;
			
			case "FIND_TEXT":
				
				break;
			
			case "SAVE_DOC":
				
				break;
			
			case "SAVE_DOC_AS":
				
				break;
			
			case "PRINT_DOC":
				
				break;
			
			case "EXPORT_DOC":
				
				break;
			
			case "OPEN_DOC":
				
				break;
			
			case "RENAME_DOC":
				
				break;
				
			case "NEW_DOC":
				
				break;
				
			case "SEND_DOC":
				
				break;
				
			case "TEMPLATE_CHANGED":
				
				break;
				
			case "INSERT_IMAGE":
				
				break;
				
			case "CROP_IMAGE":
				
				break;
				
			case "RESIZE_IMAGE":
				
				break;
				
			case "REORIENT_IMAGE":
				
				break;
				
			case "UNDO_ACTION":
				
				break;
				
			case "REDO_ACTION":
				
				break;

			default: 
				//Do nothing, never invoked
				break;
		}

	}

	/**
	 * Quit. Documents should be saved
	 */
	public void quit() {

	}
}
