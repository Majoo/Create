package se.chalmers.tda367.group25.resumate;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.utils.SectionName;
import se.chalmers.tda367.group25.resumate.utils.Template;


public class Document {

	private IOHandler ioH;
	private Template currentTempl;
	private History history;

	private List<RMText> texts = new ArrayList<RMText>(2);
	private RMImage rmI;

	public Document(){
		new Document(Template.DEF_CV);
	}


	public Document(Template templ) {
		//Set variables
		this.currentTempl = templ;
		history = new History();
		ioH = new IOHandler();

		//create sections according to Template.
		createSections();
	}

	/*
	 * Create sections according to Template.
	 */
	public void createSections(){
		switch(currentTempl){
		
		case DEF_CV:
			texts.add(new RMText(SectionName.PERSONAL_INFO));
			texts.add(new RMText(SectionName.WORK_EXPERIENCE));
			texts.add(new RMText(SectionName.EMPTY));
			
		case DEF_PL:
			rmI = new RMImage();
			texts.add(new RMText(SectionName.PERSONAL_INFO));
			texts.add(new RMText(SectionName.EMPTY));
			
		case CLASSY_CV:
			rmI = new RMImage();
			texts.add(new RMText(SectionName.PERSONAL_INFO));
			texts.add(new RMText(SectionName.WORK_EXPERIENCE));
		}
	}

	 /* Get the image*/
	public RMImage getImage(){
		return rmI;
	}
	
	/*Change the image.*/
	public void setImage(Image image){
		this.rmI.setImage(image);
	}

	public void openTemplate(String name){
		CurrentTempl = TemplateStorage.getTemplate(name);
	}

	public void changeTemplate(String name){
		Template previousTempl = CurrentTempl;
		openTemplate(name);
		previousTempl.getTexts();

		for(int i = 0; i < CurrentTempl.getTexts().size(); i ++){
			String text = previousTempl.getRMText(i).getText();
			CurrentTempl.getRMText(i).setText(text);
		}
	}

}