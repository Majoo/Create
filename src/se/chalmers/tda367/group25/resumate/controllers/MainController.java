package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeEvent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;

public class MainController {

	private DocumentController docCon;
	private IOController ioCon;
	private MainView mainView;

	/**
	 * An application with the default document is created.
	 **/
	public MainController() {
		docCon = new DocumentController();
		ioCon = new IOController();
		mainView = new MainView();
	}

	/**
	 * Handles Events from further down in the hierarchy, eg. MainView by
	 * switching depending on which label the event name is given.
	 * 
	 * @param e
	 *            the Event to handle
	 */
	public void propertyChange(PropertyChangeEvent e) {

		switch (e.getPropertyName()) {
		case Labels.TEXT_ENTERED:

			break;

		case Labels.TEXTFONT_CHANGED:

			break;

		case Labels.TEXTSIZE_CHANGED:

			break;

		case Labels.FIND_TEXT:

			break;

		case Labels.SAVE_DOC:
			ioCon.chooseFunction(Labels.SAVE_DOC, null,
					docCon.getDoc(docCon.getCurrent()));
			break;

		case Labels.SAVE_DOC_AS:

			break;

		case Labels.PRINT_DOC:
			ioCon.chooseFunction(Labels.PRINT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(), null);
			break;

		case Labels.EXPORT_DOC:
			ioCon.chooseFunction(Labels.EXPORT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(), null);
			break;

		case Labels.OPEN_DOC:
			ioCon.chooseFunction(Labels.OPEN_DOC, null, null);
			break;

		case Labels.RENAME_DOC:

			break;

		case Labels.NEW_DOC:

			break;

		case Labels.SEND_DOC:
			ioCon.chooseFunction(Labels.SEND_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(), null);
			break;

		case Labels.TEMPLATE_CHANGED:

			break;

		case Labels.INSERT_IMAGE:

			break;

		case Labels.CROP_IMAGE:

			break;

		case Labels.RESIZE_IMAGE:

			break;

		case Labels.REORIENT_IMAGE:

			break;

		case Labels.UNDO_ACTION:

			break;

		case Labels.REDO_ACTION:

			break;

		default:
			// Do nothing, never invoked
			break;
		}

	}

	/**
	 * Quit. Documents should be saved
	 */
	public void quit() {

	}
}