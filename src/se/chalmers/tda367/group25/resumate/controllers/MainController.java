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

		if(e.getPropertyName().contains("INITIAL")){
			initialPropertyChange(e);
		}else if(e.getPropertyName().contains("IMAGE")){
			imagePropertyChange(e);
		}else if(e.getPropertyName().contains("TEXT")){
			textPropertyChange(e);
		}else if(e.getPropertyName().contains("DOC")){
			ioPropertyChange(e);
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
	 * Handles events that have to do with IO
	 * 
	 * @param e
	 *       the event to be handled
	 */
	private void ioPropertyChange(PropertyChangeEvent e) {
		switch(e.getPropertyName()){
		case Labels.RENAME_DOC:
			//Not yet implemented
			break;
			
		case Labels.SAVE_DOC_AS:
			//Not yet implemented
			break;
			
		case Labels.NEW_DOC:
			//Not yet implemented
			break;
		case Labels.SAVE_DOC:
			ioCon.chooseFunction(Labels.SAVE_DOC, null,
					docCon.getDoc(docCon.getCurrent()).getStrings());

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
		default: 
			//Do nothing, never invoked
			break;
		}

	}

	/**
	 * Handles events that have to do with the text of the Document
	 * 
	 * @param e
	 *       the event to be handled
	 */
	private void textPropertyChange(PropertyChangeEvent e) {
		/*
		 * Text handling: 
		 * e.getNewValue() contains the information neccesary for the specific task. By the usage of the
		 * translator we will know which kind of section type it is so that the
		 * RMText can be informed which one to be updated.
		 */
		JEditorPane curTextSection = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
		
		switch(e.getPropertyName()){
		case Labels.UNDO_TEXT:
			TemplatePanel undoPAction = mainView.getCurDocView().getTemplatePanel();
			ViewHandler.undoAction(undoPAction.getCurrentSection(), undoPAction.getManager());

			break;

		case Labels.REDO_TEXT:
			TemplatePanel redoPAction = mainView.getCurDocView().getTemplatePanel();
			ViewHandler.redoAction(redoPAction.getCurrentSection(), redoPAction.getManager());
			break;

		case Labels.TEXT_COPY:
			ViewHandler.textCopy(curTextSection);
			break;

		case Labels.TEXT_CUT:
			ViewHandler.textCut(curTextSection); 
			//replaceCurrent("");
			break;	

		case Labels.TEXT_PASTE:
			ViewHandler.textPaste(curTextSection);
			break;

		case Labels.TEXT_SELECTALL:
			ViewHandler.selectAll(curTextSection);
			break;
		case Labels.TEXT_ENTERED:
			String text = e.getNewValue().toString();
			SectionType sectionTypeEnter = Translator.containerToSectionType(curTextSection);
			RMText textEnter = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(sectionTypeEnter);

			textEnter.setText(text);

			break;

		case Labels.TEXTFONT_CHANGED:
			String font = e.getNewValue().toString();
			RMText textFont = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(curTextSection));
			textFont.changeFont(curTextSection, font);

			break;

		case Labels.TEXTSIZE_CHANGED:
			int size = Integer.parseInt(e.getNewValue().toString());
			RMText textSize = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(curTextSection));

			textSize.changeSize(curTextSection,size);
			break;

		case Labels.TEXTSTYLE_CHANGED:
			String style = e.getNewValue().toString();
			RMText textStyle = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(curTextSection));

			textStyle.changeStyle(curTextSection,style);

			break;

		case Labels.TEXTCOLOUR_CHANGED:
			String colour = e.getNewValue().toString();
			RMText textCC = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(curTextSection));
			textCC.changeColour(curTextSection,Translator.stringToColor(colour));
			break;

		case Labels.TEXT_REPLACED:
			String[] replaceTexts = e.getNewValue().toString().split("/");
			String replace = replaceTexts[0];
			String replaceWith = replaceTexts[1];
			RMText textReplace = docCon.getDoc(docCon.getCurrent()).getTexts()
					.get(Translator.containerToSectionType(curTextSection));

			textReplace.replaceText(curTextSection,
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
<<<<<<< HEAD

		case Labels.RENAME_DOC:

			break;

		case Labels.NEW_DOC:
			
=======
		default: 
			//Do nothing, never invoked
>>>>>>> 0997a2c5de8dd6c1a4b7d387d8f8bd748949bcc1
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
	 *       the event to be handled
	 */
	private void imagePropertyChange(PropertyChangeEvent e) {
		DocumentView docView = 	mainView.getCurDocView();
		Document doc = docCon.separateDocument(docView);
		
<<<<<<< HEAD
		case Labels.TEXT_PASTE:
			JEditorPane textAreaPaste = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			ViewHandler.textPaste(textAreaPaste);
			break;
			
		case Labels.TEXT_SELECTALL:
			JEditorPane textAreaSA = mainView.getCurDocView().getTemplatePanel().getCurrentSection();
			ViewHandler.selectAll(textAreaSA);
			break;	
			
			
		case Labels.SAVE_DOC:
			ioCon.chooseFunction(Labels.SAVE_DOC, null,
					docCon.getDoc(docCon.getCurrent()).getStrings());
			
			/* String currentFileDirectory = "";
			if("".equals(currentFileDirectory)){					//if the current file is a new one (untitled)
				JFileChooser sdChooser = new JFileChooser();		//file chooser
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Resumate File", "rsmt");
				sdChooser.setFileFilter(filter);
				int returnVal = sdChooser.showSaveDialog(null);
				
				try{
					if(returnVal == JFileChooser.APPROVE_OPTION){
						File directory = sdChooser.getCurrentDirectory();
						String path = directory.getAbsolutePath();					//the absolute path of the directory, named "path"
						String fileName = sdChooser.getSelectedFile().getName();	//get the file name
						if(!fileName.contains("rsmt")){								//if the file name doesn't contain rsmt,
							fileName = fileName + ".rsmt";							//name it a new name with .rsmt at the end
						}
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "\\" + fileName), "UTF-8"));
						currentFileDirectory = path + "\\" + fileName;				//the current file directory is now "theabsolutepath\\filename.rsmt"
						//bw.write(THE_NAME_OF_THE_EDITORPANE_THAT_SHOULD_BE_OVERWRITTEN.getText());					//get the document text and write it over
						bw.close();
					}
					
				}catch(IOException err){
					JOptionPane.showMessageDialog(null,  "ERROR!");
				}
			
			}else{
				
				try{
					//if it is not empty, we'll save it into the current directory
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentFileDirectory), "UTF-8"));
					//bw.write(THE_NAME_OF_THE_EDITORPANE_THAT_SHOULD_BE_OVERWRITTEN.getText());
					bw.close();
					
				}catch(IOException err){
					JOptionPane.showMessageDialog(null,  "ERROR!");
				}	
			}*/
			
			
			
			break;

		case Labels.SAVE_DOC_AS:

			break;

		case Labels.PRINT_DOC:
			ioCon.chooseFunction(Labels.PRINT_DOC,
					docCon.getView(docCon.getCurrent()).getTemplatePanel(),
					null);
=======
		switch(e.getPropertyName()){
		case Labels.INSERT_IMAGE:			
			BufferedImage img = Translator.stringToImage((String)e.getOldValue());
			//Update the image of the Document associated with the DocumentView in focus.
			docCon.updateImage(doc, img);
			//Scaling
			int width = docView.getTemplatePanel().getImageLabel().getWidth();
			int height = docView.getTemplatePanel().getImageLabel().getHeight();
			doc.getImage().scaleImage(width, height);
			doc.getImage().setImage(doc.getImage().getCurImage());
			//Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
>>>>>>> 0997a2c5de8dd6c1a4b7d387d8f8bd748949bcc1
			break;

		case Labels.GRAYSCALE_IMAGE:
			doc.getImage().makeGray();
			//Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
			break;

		case Labels.RESET_IMAGE:
			doc.getImage().resetImage();
			//Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
			break;

		case Labels.CROP_IMAGE:
			Rectangle rect = (Rectangle) e.getOldValue();
			doc.getImage().crop(rect);
			//Then update the view with the image of the Document.
			docView.getTemplatePanel().showImage(doc.getImage().getCurImage());
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
