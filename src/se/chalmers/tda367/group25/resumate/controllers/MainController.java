package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;

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
		System.out.println("Inne i PropertyChangeEvent i MainController");

		switch (e.getPropertyName()) {
		// Image handling:
		case Labels.INSERT_IMAGE:
			// e.getOldValue() is the filename chosen, convert this to an image.
			BufferedImage img = Translator.stringToImage((String) e
					.getOldValue());
			// Update the image of the Document associated with the DocumentView
			// e.getNewValue().
			docCon.updateImage(
					docCon.separateDocument((DocumentView) e.getNewValue()),
					img);
			break;

		/*
		 * Text handling: (Need to get the right section first) e.getOldValue()
		 * will contain the current JEditorPane. e.getNewValue() will contain
		 * information necessary for the specific task. By the usage of the
		 * translator we will know which kind of section type it is so that the
		 * RMText can be informed which one to be updated.
		 */
		case Labels.TEXT_ENTERED:
			String text = e.getNewValue().toString();
			RMText tEnter = docCon.getDoc(docCon.getCurrent()).getTextsMap()
					.get(Translator.containerToSectionType(e.getOldValue()));
			tEnter.setText(text);
			break;

		case Labels.TEXTFONT_CHANGED:
			String font = e.getNewValue().toString();
			RMText tFont = docCon.getDoc(docCon.getCurrent()).getTextsMap()
					.get(Translator.containerToSectionType(e.getOldValue()));
			tFont.changeFont(Translator.getCurrentSection(e.getOldValue()),
					font);
			System.out.println("Switch in MainC, TextFont");
			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = (int) e.getNewValue();
			RMText tSize = docCon.getDoc(docCon.getCurrent()).getTextsMap()
					.get(Translator.containerToSectionType(e.getOldValue()));
			tSize.changeSize(Translator.getCurrentSection(e.getOldValue()),
					size);
			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
			RMText tStyle = docCon.getDoc(docCon.getCurrent()).getTextsMap()
					.get(Translator.containerToSectionType(e.getOldValue()));
			tStyle.changeStyle(Translator.getCurrentSection(e.getOldValue()),
					style);

			break;

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
			RMText tReplace = docCon.getDoc(docCon.getCurrent()).getTextsMap()
					.get(Translator.containerToSectionType(e.getOldValue()));
			tReplace.replaceText(Translator.getCurrentSection(e.getOldValue()),
					replace, replaceWith);

			break;

		case Labels.FIND_TEXT:
			String txt = e.getNewValue().toString();
			mainView.getCurDocView()
					.getTemplatePanel()
					.findText(Translator.getCurrentSection(e.getOldValue()),
							txt);
			break;

		case Labels.RENAME_DOC:

			break;

		case Labels.NEW_DOC:

			break;

		case Labels.TEMPLATE_CHANGED:
			TemplatePanel t = Translator.templateToPanel(e.getNewValue());
			mainView.getCurDocView().setTemplate(t);
			break;

		// Undo/redo handling:
		case Labels.UNDO_ACTION:

			break;

		case Labels.REDO_ACTION:

			break;

		// IO handling:
		case Labels.SAVE_DOC:
			if (docCon.getDoc(docCon.getCurrent()).getFilePath().equals(null)) {
				ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
						docCon.getDoc(docCon.getCurrent()), null);
			} else {
				ioCon.chooseFunction(Labels.SAVE_DOC, null,
						docCon.getDoc(docCon.getCurrent()),
						docCon.getDoc(docCon.getCurrent()).getFilePath());
			}
			break;

		case Labels.SAVE_DOC_AS:
			ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
					docCon.getDoc(docCon.getCurrent()), null);
			break;

		case Labels.PRINT_DOC:
			ioCon.chooseFunction(Labels.PRINT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null, null);
			break;

		case Labels.EXPORT_DOC:
			ioCon.chooseFunction(Labels.EXPORT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null, null);
			break;

		case Labels.OPEN_DOC:
			ioCon.chooseFunction(Labels.OPEN_DOC, null, null, null);
			break;

		case Labels.SEND_DOC:
			ioCon.chooseFunction(Labels.SEND_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null, null);
			break;

		// Other handling:
		case Labels.SEND_INITIAL_DOCVIEW:
			DocumentView v = (DocumentView) e.getOldValue();
			System.out.println(v.getID() + " In MainController");
			docCon.addDocView((String) e.getNewValue(), v);
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
