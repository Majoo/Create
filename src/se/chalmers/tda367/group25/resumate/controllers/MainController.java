package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.ITextSection;
import se.chalmers.tda367.group25.resumate.model.MultiRowSection;
import se.chalmers.tda367.group25.resumate.model.SingleRowSection;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.utils.ViewHandler;
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
		docCon.addPropertyChangeListener(this);
		ioCon = new IOController();
		ioCon.addPropertyChangeListener(this);
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

		if (e.getPropertyName().contains("INITIAL")) {
			initialPropertyChange(e);
		} else if (e.getPropertyName().contains("IMAGE")) {
			imagePropertyChange(e);
		} else if (e.getPropertyName().contains("TEXT")) {
			textPropertyChange(e);
		} else if (e.getPropertyName().contains("DOC")) {
			ioPropertyChange(e);
		}

		/* Other handling */
		switch (e.getPropertyName()) {

		case Labels.TEMPLATE_CHANGED:
			System.out.println("in tempchanged in maincontroller");
			TemplatePanel tempChange = Translator.templateToPanel(e
					.getNewValue());
			docCon.saveTexts();
			docCon.getView(docCon.getCurrentID()).setTemplate(tempChange);
			mainView.validate();
			mainView.setVisible(true);
			break;

		default:
			// Do nothing, never invoked
			break;
		}

	}

	/**
	 * Handles events that are fired during startup of the program.
	 * 
	 * @param e
	 *            the event to be handled
	 */
	private void initialPropertyChange(PropertyChangeEvent e) {
		switch (e.getPropertyName()) {
		case Labels.SEND_INITIAL_DVIEW:
			if (e.getOldValue() instanceof DocumentView
					&& e.getNewValue() instanceof Integer) {
				DocumentView docView = (DocumentView) e.getOldValue();
				docCon.addDocView((int) e.getNewValue(), docView);
				docCon.getView(docCon.getCurrentID())
						.addPropertyChangeListener(this);
			}
			break;

		case Labels.UPDATE_INITIAL_TOOLBAR:
		JTextComponent curTextSection = docCon
					.getView(docCon.getCurrentID()).getTemplatePanel()
					.getCurrentSection();
			ITextSection curText = docCon.getDoc(docCon.getCurrentID())
					.getSectionTexts().get(Translator.containerToSection(curTextSection));
			mainView.getToolbarPanel().getTextFontCombo()
					.setSelectedItem(curText.getFont());
			System.out.println(curText.getFont());
			mainView.getToolbarPanel().getTextSizeCombo()
					.setSelectedItem(curText.getSize());
			mainView.getToolbarPanel().getTextColorCombo()
					.setSelectedItem(curText.getColor());

		default:
			// Do nothing, never invoked
			break;
		}
	}

	/**
	 * Handles events that have to do with IO
	 * 
	 * @param e
	 *            the event to be handled
	 */
	private void ioPropertyChange(PropertyChangeEvent e) {
		switch (e.getPropertyName()) {
		
		case Labels.RENAME_DOC:
			// Not yet implemented
			break;

		case Labels.SAVE_DOC:
			System.out.println("Save");
			docCon.saveTexts();
			if (!(docCon.getDoc(docCon.getCurrentID()).hasFilePath())) {
				ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
						docCon.getDoc(docCon.getCurrentID()), null);
			} else if (docCon.getDoc(docCon.getCurrentID()).hasFilePath()) {
				ioCon.chooseFunction(Labels.SAVE_DOC, null,
						docCon.getDoc(docCon.getCurrentID()),
						docCon.getDoc(docCon.getCurrentID()).getFilePath());
			}

			break;

		case Labels.SAVE_DOC_AS:
			System.out.println("Save As");
			docCon.saveTexts();
			ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
					docCon.getDoc(docCon.getCurrentID()), null);

			break;

		case Labels.OPEN_DOC:
			ioCon.chooseFunction(Labels.OPEN_DOC, null, null, null);
			break;

		case Labels.PRINT_DOC:
			ioCon.chooseFunction(Labels.PRINT_DOC,
					docCon.getView(docCon.getCurrentID()).getTemplatePanel(),
					null, null);
			break;

		case Labels.EXPORT_DOC:
			ViewHandler.removeBorder(docCon.getView(docCon.getCurrentID())
					.getTemplatePanel());
			ioCon.chooseFunction(Labels.EXPORT_DOC,
					docCon.getView(docCon.getCurrentID()).getTemplatePanel(),
					null, null);
			ViewHandler.setBackBorder(docCon.getView(docCon.getCurrentID())
					.getTemplatePanel());
			break;

		case Labels.SEND_DOC:
			ioCon.chooseFunction(Labels.SEND_DOC,
					docCon.getView(docCon.getCurrentID()).getTemplatePanel(),
					null, null);
			break;

		case Labels.NEW_DOC:
			mainView.newTab((String) e.getNewValue());
			break;

		// case Labels.LOAD_DOC:
		// docCon.getDoc(docCon.getCurrent()).setAllTexts(
		// ioCon.getStringsMap());
		// break;

		default:
			// Do nothing, never invoked
			break;
		}

	}

	/**
	 * Handles events that have to do with the text of the Document
	 * 
	 * @param e
	 *            the event to be handled
	 */
	private void textPropertyChange(PropertyChangeEvent e) {
		/*
		 * Text handling: e.getNewValue() contains the information neccesary for
		 * the specific task. By the usage of the master translator we will know
		 * which kind of section type it is so that the RMText can be informed
		 * which one to be updated.
		 */
		JTextComponent curTextSection = docCon.getView(docCon.getCurrentID())
				.getTemplatePanel().getCurrentSection();
		ITextSection curText = docCon.getDoc(docCon.getCurrentID()).getSectionTexts().get(Translator.containerToSection(curTextSection));
		
		switch (e.getPropertyName()) {

		case Labels.TEXT_UNDO:
			TemplatePanel undoPAction = docCon.getView(docCon.getCurrentID())
					.getTemplatePanel();
			ViewHandler.undoAction(undoPAction.getManager());
			break;

		case Labels.TEXT_REDO:
			TemplatePanel redoPAction = docCon.getView(docCon.getCurrentID())
					.getTemplatePanel();
			ViewHandler.redoAction(redoPAction.getManager());
			break;

		case Labels.TEXT_COPY:
			ViewHandler.textCopy(curTextSection);
			break;

		case Labels.TEXT_CUT:
			ViewHandler.textCut(curTextSection);
			break;

		case Labels.TEXT_PASTE:
			ViewHandler.textPaste(curTextSection);
			break;

		case Labels.TEXT_SELECTALL:
			ViewHandler.selectAll(curTextSection);
			break;

		case Labels.SAVE_TEXT:
			docCon.saveTexts();
			break;

		case Labels.TEXTFONT_CHANGED:
			String font = e.getNewValue().toString();
			curText.changeFont(curTextSection, font);
			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = Integer.parseInt(e.getNewValue().toString());
			curText.changeSize(curTextSection, size);
			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
			
			if(curTextSection instanceof JTextPane){
				JTextPane textSec = (JTextPane)curTextSection;
				MultiRowSection mulRowSec= (MultiRowSection)curText;
				mulRowSec.changeStyle(textSec, style);
			} else {
				SingleRowSection singRowSec= (SingleRowSection)curText;
				singRowSec.changeStyle(curTextSection, style);
			}			
			break;

		case Labels.TEXTCOLOUR_CHANGED:
			
			String colour = e.getNewValue().toString();
			curText.changeColor(curTextSection,
					Translator.stringToColor(colour), colour);
			break;

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
			curText.replaceText(curTextSection, replace, replaceWith);
			break;

		case Labels.REPLACE_ALL_TEXT:
			String[] replaceTextsA = e.getNewValue().toString().split("/");
			String replaceA = replaceTextsA[0];
			String replaceWithA = replaceTextsA[1];
			for (JTextComponent comps: docCon.getView(docCon.getCurrentID()).getTemplatePanel().getTextComponents())
				docCon.getDoc(docCon.getCurrentID()).getSectionTexts()
					.get(Translator.containerToSection(comps)).replaceText(comps, replaceA, replaceWithA);
			break;

		case Labels.FIND_TEXT:
			String txt = e.getNewValue().toString();
			int numberOfTextComp = docCon.getView(docCon.getCurrentID()).getTemplatePanel().getTextComponents().size();
			for (JTextComponent comp: docCon.getView(docCon.getCurrentID()).getTemplatePanel().getTextComponents())
			ViewHandler.findText(comp, txt);
			ViewHandler.showNoMatchesPopUp(txt,numberOfTextComp);
			break;

		case Labels.TEXTAREA_CHANGED:
			mainView.getToolbarPanel().getTextFontCombo().getModel().setSelectedItem(curText.getFont());
			mainView.getToolbarPanel().getTextSizeCombo().getModel().setSelectedItem(curText.getSize());
			mainView.getToolbarPanel().getTextColorCombo().getModel().setSelectedItem(curText.getColor());
			mainView.getToolbarPanel().updateUI();
			mainView.getToolbarPanel().validate();
			break;

		case Labels.RENAME_DOC:

			break;

		case Labels.NEW_DOC:

		default:
			// Do nothing, never invoked
			break;
		}

	}

	/**
	 * Handles events that have to do with the image of the Document
	 * 
	 * @param e
	 *            the event to be handled
	 */
	private void imagePropertyChange(PropertyChangeEvent e) {
		DocumentView docView = docCon.getView(docCon.getCurrentID());
		Document doc = docCon.separateDocument(docView);

		switch (e.getPropertyName()) {
		case Labels.INSERT_IMAGE:
			BufferedImage img = Translator.stringToImage(e.getOldValue()
					.toString());
			// Update the image of the Document associated with the DocumentView
			// in focus.
			docCon.updateImage(doc, img);
			// Scaling
			int width = docView.getTemplatePanel().getImageLabel().getWidth();
			int height = docView.getTemplatePanel().getImageLabel().getHeight();
			doc.getImage().scaleImage(width, height);
			doc.getImage().setImage(doc.getImage().getCurImage());
			// Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
			break;

		case Labels.GRAYSCALE_IMAGE:
			doc.getImage().makeGray();
			// Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
			break;

		case Labels.RESET_IMAGE:
			doc.getImage().resetImage();
			// Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
			break;

		case Labels.CROP_IMAGE:
			if (e.getOldValue() instanceof Rectangle) {
				Rectangle rect = (Rectangle) e.getOldValue();
				doc.getImage().crop(rect);
				// Then update the view with the image of the Document.
				docView.getTemplatePanel().showImage(
						doc.getImage().getCurImage());
			}
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
