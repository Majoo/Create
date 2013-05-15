package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JEditorPane;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;

public class MainController implements PropertyChangeListener {

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
		mainView.addPropertyChangeListener(this);
	}

	/**
	 * Handles Events from further down in the hierarchy, eg. MainView by
	 * switching depending on which label the event name is given.
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
			//SectionType s = documentController.getDoc("apa").getCurrentSection();
			int size = (int)e.getNewValue();
			JEditorPane section = (JEditorPane)e.getOldValue();
			SectionType sectionType = Translator.containerToSectionType(section);
			docCon.getDoc("apa").getTexts().get(sectionType).changeSize(section, size);
			break;

		case Labels.FIND_TEXT:

			break;
		
		case  Labels.RENAME_DOC:

			break;

		case  Labels.NEW_DOC:

			break;

		case  Labels.TEMPLATE_CHANGED:

			break;
			
		//Undo/redo handling:
		case  Labels.UNDO_ACTION:

			break;

		case  Labels.REDO_ACTION:

			break;
		
		//IO handling:			
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

		case Labels.SEND_DOC:
			ioCon.chooseFunction(Labels.SEND_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(), null);
			break;
			
		//Other handling:
<<<<<<< HEAD
		case Labels.SEND_INITIAL_DOCVIEW:
			documentController.addDocView((String)e.getNewValue()
					,(DocumentView)e.getOldValue());
		default: 
			//Do nothing, never invoked
=======
				case Labels.SEND_INITIAL_DOCVIEW:
					String ID;
					DocumentView v;
					if(e.getNewValue() instanceof String){
						ID = 
					}
					docCon.addDocView((String)e.getNewValue()
							,(DocumentView)e.getOldValue());
					break;
						
		default:
			// Do nothing, never invoked
>>>>>>> de74f125d8ad0bec4e3258fe502fdc8ffbf3058a
			break;
		}

	}

	/**
	 * Quit. Documents should be saved
	 */
	public void quit() {

	}
}
