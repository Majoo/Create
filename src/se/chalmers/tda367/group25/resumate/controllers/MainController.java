package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;
import se.chalmers.tda367.group25.resumate.utils.ViewHandler;

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
			System.out.println("MainController Text");
		}else if(e.getPropertyName().contains("DOC")){
			ioPropertyChange(e);
		}

		/* Other handling */
		switch (e.getPropertyName()) {

		case Labels.TEMPLATE_CHANGED:
			
			System.out.println("in tempchanged in maincontroller");
			TemplatePanel prevTemp = docCon.getView(docCon.getCurrent()).getTemplatePanel();
			TemplatePanel tempChange = Translator.templateToPanel(e.getNewValue());
			ViewHandler.changeTemplate(prevTemp, tempChange);
			
			docCon.getView(docCon.getCurrent()).setTemplate(tempChange);
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
	 *       the event to be handled
	 */
	private void initialPropertyChange(PropertyChangeEvent e) {
		switch(e.getPropertyName()){
		case Labels.SEND_INITIAL_DVIEW:
			DocumentView docView = (DocumentView)e.getOldValue();
			docCon.addDocView((String)e.getNewValue()
					,docView);
			docCon.getView(docCon.getCurrent()).addPropertyChangeListener(this);
			
			JTextPane curTextSection = docCon.getView(docCon.getCurrent()).getTemplatePanel()
					.getCurrentSection();
			RMText curRMText = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(curTextSection));
			
			mainView.getToolbarPanel().getTextFontCombo().setSelectedItem(curRMText.getFont());
			mainView.getToolbarPanel().getTextSizeCombo().setSelectedItem(curRMText.getSize());
			mainView.getToolbarPanel().getTextColorCombo().setSelectedItem(curRMText.getColor());
			
			break;
			
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
			if (docCon.getDoc(docCon.getCurrent()).getFilePath().isEmpty()) {
				ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
						docCon.getDoc(docCon.getCurrent()).getStrings(), null);
			} else {
				ioCon.chooseFunction(Labels.SAVE_DOC, null,
						docCon.getDoc(docCon.getCurrent()).getStrings(), docCon
								.getDoc(docCon.getCurrent()).getFilePath());
			}

		case Labels.SAVE_DOC_AS:
			System.out.println("SAVE_DOC_AS");
//			ioCon.chooseFunction(Labels.SAVE_DOC_AS, null,
//					docCon.getDoc(docCon.getCurrent()).getStrings(), null);

			break;

		case Labels.OPEN_DOC:
			//TODO !!
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
			ViewHandler.removeBorder(docCon.getView(docCon.getCurrent()).getTemplatePanel());
			ioCon.chooseFunction(Labels.EXPORT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null, null);
			ViewHandler.setBackBorder(docCon.getView(docCon.getCurrent()).getTemplatePanel());
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
			// No gui-elements in the controller pls!
			// JTabbedPane jtbExample = new JTabbedPane();
			// jtbExample.addTab(tabbedPanel);
			// jtbExample.setSelectedIndex(0);
			break;

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
		JTextPane curTextSection = docCon.getView(docCon.getCurrent()).getTemplatePanel()
				.getCurrentSection();
		RMText curRMText = docCon.getDoc(docCon.getCurrent()).getTexts()
				.get(Translator.containerToSectionType(curTextSection));
		
		switch(e.getPropertyName()){
		
		case Labels.TEXT_UNDO:
			TemplatePanel undoPAction = docCon.getView(docCon.getCurrent())
					.getTemplatePanel();
			ViewHandler.undoAction(undoPAction.getCurrentSection(),
					undoPAction.getManager());
			break;

		case Labels.TEXT_REDO:
			TemplatePanel redoPAction = docCon.getView(docCon.getCurrent())
					.getTemplatePanel();
			ViewHandler.redoAction(redoPAction.getCurrentSection(),
					redoPAction.getManager());
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
			curRMText.setText(text);
			break;

		case Labels.TEXTFONT_CHANGED:
			//Testa ta in en font ist för en string kanske
			String font = e.getNewValue().toString();
			curRMText.changeFont(curTextSection, font);
			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = Integer.parseInt(e.getNewValue().toString());
			curRMText.changeSize(curTextSection, size);

			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
			curRMText.changeStyle(curTextSection, style);

			break;

		case Labels.TEXTCOLOUR_CHANGED:
			String colour = e.getNewValue().toString();
			curRMText.changeColor(curTextSection,
					Translator.stringToColor(colour), colour);

			break;

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
			curRMText.replaceText(curTextSection, replace, replaceWith);

			break;

		case Labels.REPLACE_ALL_TEXT:
			String[] replaceTextsA = e.getNewValue().toString().split("/");
			String replaceA = replaceTextsA[0];
			String replaceWithA = replaceTextsA[1];
			JTextPane textAreaPersonal = docCon.getView(docCon.getCurrent())
					.getTemplatePanel().getPersonalInfoText();
			JTextPane textAreaHeader = docCon.getView(docCon.getCurrent())
					.getTemplatePanel().getHeaderTitle();
			JTextPane textAreaWork = docCon.getView(docCon.getCurrent())
					.getTemplatePanel().getWorkingExperienceText();

			RMText textPersonal = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaPersonal));
			RMText textHeader = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaHeader));
			RMText textWork = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaWork));

			textPersonal.replaceText(textAreaPersonal, replaceA, replaceWithA);
			textHeader.replaceText(textAreaHeader, replaceA, replaceWithA);
			textWork.replaceText(textAreaWork, replaceA, replaceWithA);

			break;

		case Labels.FIND_TEXT:
			String txt = e.getNewValue().toString();
			ViewHandler.findText(docCon.getView(docCon.getCurrent()).getTemplatePanel()
					.getPersonalInfoText(), txt);
			ViewHandler.findText(docCon.getView(docCon.getCurrent()).getTemplatePanel()
					.getHeaderTitle(), txt);
			ViewHandler.findText(docCon.getView(docCon.getCurrent()).getTemplatePanel()
					.getWorkingExperienceText(), txt);
			break;
			
		case Labels.TEXTAREA_CHANGED:
			System.out.println("In textarea changed in MainController");
			mainView.getToolbarPanel().getTextFontCombo().getModel().setSelectedItem(curRMText.getFont());
			System.out.println(curRMText.getFont());
			mainView.getToolbarPanel().getTextSizeCombo().getModel().setSelectedItem(curRMText.getSize());
			System.out.println(curRMText.getSize());
			mainView.getToolbarPanel().getTextColorCombo().getModel().setSelectedItem(curRMText.getColor());
			System.out.println(curRMText.getColor());
			
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
		DocumentView docView = docCon.getView(docCon.getCurrent());
		Document doc = docCon.separateDocument(docView);

		switch (e.getPropertyName()) {
		case Labels.INSERT_IMAGE:
			BufferedImage img = Translator.stringToImage((String) e
					.getOldValue());
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
			Rectangle rect = (Rectangle) e.getOldValue();
			doc.getImage().crop(rect);
			// Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
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
