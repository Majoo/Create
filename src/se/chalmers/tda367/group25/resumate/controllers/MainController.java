package se.chalmers.tda367.group25.resumate.controllers;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JEditorPane;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.DocumentView;
import se.chalmers.tda367.group25.resumate.views.MainView;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;
import se.chalmers.tda367.group25.resumate.views.ViewHandler;

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

		if(e.getPropertyName().contains("IMAGE")){
			imagePropertyChange(e);
		}else if(e.getPropertyName().contains("TEXT")){
			textPropertyChange(e);
		}else if(e.getPropertyName().contains("DOC")){
			ioPropertyChange(e);
		}else if(e.getPropertyName().contains("INITIAL")){
			initialPropertyChange(e);
		}

		/*Other handling*/
		switch (e.getPropertyName()) {

		case Labels.TEMPLATE_CHANGED:
			TemplatePanel tempPChange = Translator.templateToPanel(e.getNewValue());
			mainView.getCurDocView().setTemplate(tempPChange);
			break;

		default: 
			//Do nothing, never invoked
			break;
		}

	}

	/**
	 * Handles events that are fired during startup of the program.
	 * 
	 * @param e
	 * 			the event to be handled
	 */
	public void initialPropertyChange(PropertyChangeEvent e){
		switch (e.getPropertyName()){
		case Labels.SEND_INITIAL_DOCVIEW:
			DocumentView docView = (DocumentView)e.getOldValue();
			docCon.addDocView((String)e.getNewValue()
					,docView);
			break;

		default: 
			//Do nothing, never invoked
			break;
		}
	}

	/**
	 * Handles events that have to do with the image of the Document
	 * 
	 * @param e
	 * 			the event to be handled
	 */
	public void imagePropertyChange(PropertyChangeEvent e){
		System.out.println(mainView.getCurDocView());
		DocumentView v = mainView.getCurDocView();
		Document d = docCon.separateDocument(v);
		
		switch (e.getPropertyName()){
		
		case Labels.INSERT_IMAGE:			
			BufferedImage img = Translator.stringToImage((String)e.getOldValue());
			//Update the image of the Document associated with the DocumentView in focus.
			docCon.updateImage(d, img);
			//Scaling
			int width = v.getTemplatePanel().getImageLabel().getWidth();
			int height = v.getTemplatePanel().getImageLabel().getHeight();
			d.getImage().scaleImage(width, height);
			d.getImage().setImage(d.getImage().getCurImage());
			//Then update the view with the image of the Document.
			v.getTemplatePanel().showImage(d.getImage().getCurImage());
			break;

		case Labels.GRAYSCALE_IMAGE:
			d.getImage().makeGray();
			//Then update the view with the image of the Document.
			v.getTemplatePanel().showImage(d.getImage().getCurImage());
			break;

		case Labels.RESET_IMAGE:
			d.getImage().resetImage();
			//Then update the view with the image of the Document.
			v.getTemplatePanel().showImage(d.getImage().getCurImage());
			break;

		case Labels.CROP_IMAGE:
			Rectangle rect = (Rectangle) e.getOldValue();
			d.getImage().crop(rect);
			//Then update the view with the image of the Document.
			v.getTemplatePanel().showImage(d.getImage().getCurImage());
			break;
			
		default: 
			//Do nothing, never invoked
			break;
		}

	}

	/**
	 * Handles events that have to do with the text of the Document	 
	 *  
	 * @param e
	 * 			the event to be handled
	 */
	public void textPropertyChange(PropertyChangeEvent e){
		switch (e.getPropertyName()){
		/*
		 * Text handling: 
		 * e.getNewValue() contains the information neccesary for the specific task. By the usage of the
		 * translator we will know which kind of section type it is so that the
		 * RMText can be informed which one to be updated.
		 */
		case Labels.TEXT_ENTERED:
			String text = e.getNewValue().toString();
			JEditorPane textAreaEnter =  mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			SectionType sectionTypeEnter = Translator.containerToSectionType(textAreaEnter);
			RMText textEnter = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeEnter);

			textEnter.setText(text);

			break;

		case Labels.TEXTFONT_CHANGED:
			String font = e.getNewValue().toString();
			JEditorPane textAreaFont =  mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			RMText textFont = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaFont));
			textFont.changeFont(textAreaFont, font);

			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = Integer.parseInt(e.getNewValue().toString());
			JEditorPane textAreaSize =  mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			RMText textSize = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaSize));

			textSize.changeSize(textAreaSize,size);
			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
			JEditorPane textAreaStyle =  mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			RMText textStyle = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaStyle));

			textStyle.changeStyle(textAreaStyle,style);

			break;

		case Labels.TEXTCOLOUR_CHANGED:
			String colour = e.getNewValue().toString();
			JEditorPane textAreaCC =  mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			RMText textCC = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaCC));
			textCC.changeColour(textAreaCC,Translator.stringToColor(colour));
			break;

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
			JEditorPane textAreaR =  mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			RMText textReplace = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaR));

			textReplace.replaceText(textAreaR,
					replace, replaceWith);
			break;

		case Labels.REPLACE_ALL_TEXT:	
			String[] replaceTextsA = e.getNewValue().toString().split("/");
			String replaceA = replaceTextsA[0];
			String replaceWithA = replaceTextsA[1];
			JEditorPane textAreaPersonal =  mainView.getCurDocView().getTemplatePanel().getPersonalInfoText();
			JEditorPane textAreaHeader =  mainView.getCurDocView().getTemplatePanel().getHeaderTitle();
			JEditorPane textAreaWork =  mainView.getCurDocView().getTemplatePanel().getWorkingExperienceText();

			RMText textPersonal = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaPersonal));
			RMText textHeader = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaHeader));
			RMText textWork = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(textAreaWork));

			textPersonal.replaceText(textAreaPersonal , replaceA, replaceWithA);
			textHeader.replaceText(textAreaHeader , replaceA, replaceWithA);
			textWork.replaceText(textAreaWork , replaceA, replaceWithA);

			break;

		case Labels.FIND_TEXT:
			String txt = e.getNewValue().toString();
			ViewHandler.findText(mainView.getCurDocView().getTemplatePanel().getPersonalInfoText(), txt);
			ViewHandler.findText(mainView.getCurDocView().getTemplatePanel().getHeaderTitle(), txt);
			ViewHandler.findText(mainView.getCurDocView().getTemplatePanel().getWorkingExperienceText(), txt);
			break;

		case Labels.TEXT_COPY:
			JEditorPane textAreaCopy = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			ViewHandler.textCopy(textAreaCopy);
			break;

		case Labels.TEXT_CUT:
			JEditorPane textAreaCut = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			ViewHandler.textCut(textAreaCut); 
			//replaceCurrent("");
			break;	

		case Labels.TEXT_PASTE:
			JEditorPane textAreaPaste = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			ViewHandler.textPaste(textAreaPaste);
			break;

		case Labels.TEXT_SELECTALL:
			JEditorPane textAreaSA = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			ViewHandler.selectAll(textAreaSA);
			break;	
		case Labels.UNDO_TEXT:
			TemplatePanel undoPAction = mainView.getCurDocView().getTemplatePanel();
			ViewHandler.undoAction(undoPAction.getCurrentSection(), undoPAction.getManager());

			break;

		case Labels.REDO_TEXT:
			TemplatePanel redoPAction = mainView.getCurDocView().getTemplatePanel();
			ViewHandler.redoAction(redoPAction.getCurrentSection(), redoPAction.getManager());
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
	 * 			the event to be handled
	 */
	public void ioPropertyChange(PropertyChangeEvent e){
		switch (e.getPropertyName()){
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

		case Labels.SAVE_DOC:
			ioCon.chooseFunction(Labels.SAVE_DOC, null,
					docCon.getDoc(docCon.getCurrent()).getStrings());

			break;

		case Labels.RENAME_DOC:
			//Not yet implemented
			break;

		case Labels.NEW_DOC:
			//Not yet implemented
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
