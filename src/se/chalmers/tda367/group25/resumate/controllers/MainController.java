package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JEditorPane;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.model.SectionType;
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
		mainView.sendInitialDocView();
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
			//e.getOldValue() is the path chosen, convert this to an image.
			BufferedImage img = Translator.stringToImage((String)e.getOldValue());
			//Update the image of the Document associated with the DocumentView e.getNewValue().
			DocumentView v = (DocumentView)e.getNewValue();
			System.out.println(v.getID());
			docCon.updateImage(docCon.separateDocument(v), img);
			System.out.println("har kört updateImage(separateDoc(docview), img) i MainController");
			break;

		/*
		 * Text handling: (Need to get the right section first) e.getOldValue()
		 * will contain the current JEditorPane. e.getNewValue() will contain
		 * information neccesary for the specific task. By the usage of the
		 * translator we will know which kind of section type it is so that the
		 * RMText can be informed which one to be updated.
		 */
		case Labels.TEXT_ENTERED:
			String text = e.getNewValue().toString();
			JEditorPane textAreaE = Translator.objectToJEditorPane(e.getOldValue());
			SectionType sectionTypeE = Translator.containerToSectionType(textAreaE);
			RMText textE = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeE);
	
			textE.setText(text);
			
			break;

		case Labels.TEXTFONT_CHANGED:
			String font = e.getNewValue().toString();
			JEditorPane textAreaF = Translator.objectToJEditorPane(e.getOldValue());
			SectionType sectionTypeF = Translator.containerToSectionType(textAreaF);
			RMText textF = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeF);
			textF.changeFont(textAreaF, font);

			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = Integer.parseInt(e.getNewValue().toString());
			JEditorPane textAreaSi = Translator.objectToJEditorPane(e.getOldValue());
			SectionType sectionTypeSi = Translator.containerToSectionType(textAreaSi);
			RMText textSi = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeSi);

			textSi.changeSize(Translator.objectToJEditorPane(e.getOldValue()),
					size);
			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
			JEditorPane textAreaSt = Translator.objectToJEditorPane(e.getOldValue());
			SectionType sectionTypeSt = Translator.containerToSectionType(textAreaSt);
			RMText textSt = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeSt);
			
			textSt.changeStyle(textAreaSt,style);
	
			break;
			
//		case Labels.TEXT_SELECTALL:
//			String select = e.getNewValue().toString();
//			JEditorPane textAreaS = Translator.objectToJEditorPane(e.getOldValue());
//			SectionType sectionTypeS = Translator.containerToSectionType(textAreaS);
//			RMText textS = docCon.getDoc(docCon.getCurrent()).getTexts()
//					.get(sectionTypeS);
//	
//			textS.setText(select);
//			
//			break;
			
			

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
			JEditorPane textAreaR = Translator.objectToJEditorPane(e.getOldValue());
			SectionType sectionTypeR = Translator.containerToSectionType(textAreaR);
			RMText textR = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeR);
	
			textR.replaceText(Translator.objectToJEditorPane(e.getOldValue()),
					replace, replaceWith);

			break;

		case Labels.FIND_TEXT:
			String txt = e.getNewValue().toString();
			JEditorPane textAreaFi = Translator.objectToJEditorPane(e.getOldValue());
			SectionType sectionTypeFi = Translator.containerToSectionType(textAreaFi);
			mainView.getCurDocView().getTemplatePanel().findText(Translator.objectToJEditorPane(sectionTypeFi),txt);

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
			ioCon.chooseFunction(Labels.SAVE_DOC, null,
					docCon.getDoc(docCon.getCurrent()));
			break;

		case Labels.SAVE_DOC_AS:

			break;

		case Labels.PRINT_DOC:
			ioCon.chooseFunction(Labels.PRINT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null);
			break;

		case Labels.EXPORT_DOC:
			ioCon.chooseFunction(Labels.EXPORT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null);
			break;

		case Labels.OPEN_DOC:
			ioCon.chooseFunction(Labels.OPEN_DOC, null, null);
			break;

		case Labels.SEND_DOC:
			ioCon.chooseFunction(Labels.SEND_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null);
			break;
			
			
		case Labels.TEXT_COPY:
			JEditorPane textAreaC = Translator.objectToJEditorPane(e.getOldValue());
			

		// Other handling:
		case Labels.SEND_INITIAL_DOCVIEW:
			DocumentView dv = (DocumentView)e.getOldValue();
			System.out.println(dv.getID()+" In MainController" +
					", trying to add it in "+"\""+(String)e.getNewValue()+"\"");
			docCon.addDocView((String)e.getNewValue()
					,dv);
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
