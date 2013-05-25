package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.ITextSection;
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
		}else if(e.getPropertyName().contains("DOC")){
			ioPropertyChange(e);
		}

		/* Other handling */
		switch (e.getPropertyName()) {

		case Labels.TEMPLATE_CHANGED:

			System.out.println("in tempchanged in maincontroller");
			TemplatePanel prevTemp = docCon.getView(docCon.getCurrentID()).getTemplatePanel();
			TemplatePanel tempChange = Translator.templateToPanel(e.getNewValue());
//			ViewHandler.changeTemplate(prevTemp, tempChange);
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
			if(e.getOldValue() instanceof DocumentView 
					&& e.getNewValue() instanceof Integer){
			DocumentView docView = (DocumentView)e.getOldValue();
			docCon.addDocView((int)e.getNewValue()
					,docView);
			docCon.getView(docCon.getCurrentID()).addPropertyChangeListener(this);
			}
			break;
			
		case Labels.UPDATE_INITIAL_TOOLBAR:
			JTextComponent curTextSection = docCon.getView(docCon.getCurrentID()).getTemplatePanel()
			.getCurrentSection();
			ITextSection curRMText = docCon.getDoc(docCon.getCurrentID()).getTexts()
			.get(Translator.containerToSectionType(curTextSection));
			mainView.getToolbarPanel().getTextFontCombo().setSelectedItem(curRMText.getFont());
			mainView.getToolbarPanel().getTextSizeCombo().setSelectedItem(curRMText.getSize());
			mainView.getToolbarPanel().getTextColorCombo().setSelectedItem(curRMText.getColor());
			
		default: 
			//Do nothing, never invoked
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
			if (docCon.getDoc(docCon.getCurrentID()).getFilePath().isEmpty()) {
				ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
						docCon.getDoc(docCon.getCurrentID()), null);
			} else if (!(docCon.getDoc(docCon.getCurrentID()).getFilePath().isEmpty())) {
				ioCon.chooseFunction(Labels.SAVE_DOC, null,
						docCon.getDoc(docCon.getCurrentID()),
						docCon.getDoc(docCon.getCurrentID()).getFilePath());
			}
			
			break;
		
		case Labels.SAVE_DOC_AS:
			ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
					docCon.getDoc(docCon.getCurrentID()), null);

			break;

		case Labels.OPEN_DOC:
			ioCon.chooseFunction(Labels.OPEN_DOC, null, null, null);
			break;

		case Labels.PRINT_DOC:
			/*
			 * ioCon.chooseFunction(Labels.PRINT_DOC,
			 * docCon.getView(docCon.getCurrent()).getTemplatePanel(), null,
			 * null);
			 */
			// To be implemented
			break;

		case Labels.EXPORT_DOC:
//			ViewHandler.removeBorder(docCon.getView(docCon.getCurrentID()).getTemplatePanel());
			ioCon.chooseFunction(Labels.EXPORT_DOC,
					docCon.getView(docCon.getCurrentID()).getTemplatePanel(),
					null, null);
//			ViewHandler.setBackBorder(docCon.getView(docCon.getCurrentID()).getTemplatePanel());
			break;

		case Labels.SEND_DOC:
			/*
			 * ioCon.chooseFunction(Labels.SEND_DOC,
			 * docCon.getView(docCon.getCurrent()).getTemplatePanel(), null,
			 * null);
			 */
			// To be implemented
			break;

		case Labels.NEW_DOC:
			// To be implemented
			break;

//		case Labels.DOC_LOAD:
//			docCon.getDoc(docCon.getCurrent()).setAllTexts(
//					ioCon.getStringsMap());
//			break;

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
		JTextComponent curTextSection = docCon.getView(docCon.getCurrentID()).getTemplatePanel()
				.getCurrentSection();
		ITextSection curRMText = docCon.getDoc(docCon.getCurrentID()).getTexts()
				.get(Translator.containerToSectionType(curTextSection));

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
			// replaceCurrent("");
			break;

		case Labels.TEXT_PASTE:
			ViewHandler.textPaste(curTextSection);
			break;

		case Labels.TEXT_SELECTALL:
			ViewHandler.selectAll(curTextSection);
			break;
		case Labels.TEXT_ENTERED:
			String text = e.getNewValue().toString();
//			curRMText.setText(text);
			//TODO
			break;

		case Labels.TEXTFONT_CHANGED:
			String font = e.getNewValue().toString();
//			curRMText.changeFont(curTextSection, font);
			// TODO
			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = Integer.parseInt(e.getNewValue().toString());
//			curRMText.changeSize(curTextSection, size);
			// TODO
			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
//			curRMText.changeStyle(curTextSection, style);
			// TODO
			break;

		case Labels.TEXTCOLOUR_CHANGED:
			String colour = e.getNewValue().toString();
//			curRMText.changeColor(curTextSection,
//					Translator.stringToColor(colour), colour);
			// TODO
			break;

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
//			curRMText.replaceText(curTextSection, replace, replaceWith);
			//TODO
			break;

		case Labels.REPLACE_ALL_TEXT:
			String[] replaceTextsA = e.getNewValue().toString().split("/");
			String replaceA = replaceTextsA[0];
			String replaceWithA = replaceTextsA[1];
			/*
//			JTextPane textAreaPersonal = docCon.getView(docCon.getCurrentID())
//					.getTemplatePanel().getPersonalInfoText();
//			JTextPane textAreaHeader = docCon.getView(docCon.getCurrentID())
//					.getTemplatePanel().getHeaderTitle();
			JTextPane textAreaWork = docCon.getView(docCon.getCurrentID())
					.getTemplatePanel().getWorkingExperienceText();
			ITextSection textPersonal = docCon.getDoc(docCon.getCurrentID()).getTexts()
					.get(Translator.containerToSectionType(textAreaPersonal));
			ITextSection textHeader = docCon.getDoc(docCon.getCurrentID()).getTexts()
					.get(Translator.containerToSectionType(textAreaHeader));
			ITextSection textWork = docCon.getDoc(docCon.getCurrentID()).getTexts()
					.get(Translator.containerToSectionType(textAreaWork));
//			textPersonal.replaceText(textAreaPersonal, replaceA, replaceWithA);
//			textHeader.replaceText(textAreaHeader, replaceA, replaceWithA);
//			textWork.replaceText(textAreaWork, replaceA, replaceWithA);*/
			// TODO
			break;

		case Labels.FIND_TEXT:
			String txt = e.getNewValue().toString();
//			ViewHandler.findText(docCon.getView(docCon.getCurrentID()).getTemplatePanel()
//					.getPersonalInfoText(), txt);
//			ViewHandler.findText(docCon.getView(docCon.getCurrentID()).getTemplatePanel()
//					.getHeaderTitle(), txt);
//			ViewHandler.findText(docCon.getView(docCon.getCurrentID()).getTemplatePanel()
//					.getWorkingExperienceText(), txt);
			// TODO
			break;

		case Labels.TEXTAREA_CHANGED:
			mainView.getToolbarPanel().getTextFontCombo().getModel().setSelectedItem(curRMText.getFont());
			mainView.getToolbarPanel().getTextSizeCombo().getModel().setSelectedItem(curRMText.getSize());
			mainView.getToolbarPanel().getTextColorCombo().getModel().setSelectedItem(curRMText.getColor());
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
			BufferedImage img = Translator.stringToImage(e
					.getOldValue().toString());
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
			if(e.getOldValue() instanceof Rectangle){
				Rectangle rect = (Rectangle) e.getOldValue();
				doc.getImage().crop(rect);
				// Then update the view with the image of the Document.
				docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
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
