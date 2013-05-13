package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeEvent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;

public class MainController {

	private DocumentController documentController;
	private IOController ioController;
	private MainView mainView;

	/**
	 *  An application with the default document is created. 
	 **/
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
		//Image handling:
		case Labels.INSERT_IMAGE:
			//send down.
		//Text handling:
		case Labels.TEXT_ENTERED:

			break;

		case Labels.TEXTFONT_CHANGED:

			break;	

		case Labels.TEXTSIZE_CHANGED:

			break;

		case Labels.FIND_TEXT:

			break;
		//IO handling:
		case Labels.SAVE_DOC:

			break;

		case  Labels.SAVE_DOC_AS:

			break;

		case  Labels.PRINT_DOC:

			break;

		case  Labels.EXPORT_DOC:

			break;

		case  Labels.OPEN_DOC:

			break;

		case  Labels.RENAME_DOC:

			break;

		case  Labels.NEW_DOC:

			break;

		case  Labels.SEND_DOC:

			break;

		case  Labels.TEMPLATE_CHANGED:

			break;
		//Undo/redo handling:
		case  Labels.UNDO_ACTION:

			break;

		case  Labels.REDO_ACTION:

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
