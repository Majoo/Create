package se.chalmers.tda367.group25.resumate.model;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.controllers.IOController;


public class Document {
	//helpers
	private IOController ioH;
	private History history;
	//other instance variables
	private Template currentTempl;
	//sections
	private Map <SectionType, RMText> texts = new HashMap<SectionType, RMText>(3);
	private RMImage rmI;

	/* Create a new Document using the default template. */
	public Document(){
		new Document(Template.DEF_CV);
	}

	/* Create a new Document using the specified template. */
	public Document(Template templ) {
		//Set variables
		this.currentTempl = templ;
		history = new History();
		ioH = new IOController();
		rmI = new RMImage(null);
		//create sections according to Template.
		createSections();
	}

	/*Create sections according to Template.*/
	public void createSections(){
		switch(currentTempl){
		
		case DEF_CV:
		
			if(!texts.containsKey(SectionType.PERSONAL_INFO)){
				texts.put(SectionType.PERSONAL_INFO, new RMText(SectionType.PERSONAL_INFO));
			}
			if(!texts.containsKey(SectionType.WORK_EXPERIENCE)){
				texts.put(SectionType.WORK_EXPERIENCE, new RMText(SectionType.WORK_EXPERIENCE));
			}
			//texts.add(new RMText(SectionType.EMPTY));
			
		case DEF_PL:
			if(!texts.containsKey(SectionType.PERSONAL_INFO)){
				texts.put(SectionType.PERSONAL_INFO, new RMText(SectionType.PERSONAL_INFO));
			}
			//texts.add(new RMText(SectionType.EMPTY));
			
		case CLASSY_CV:
			if(!texts.containsKey(SectionType.PERSONAL_INFO)){
				texts.put(SectionType.PERSONAL_INFO, new RMText(SectionType.PERSONAL_INFO));
			}
			if(!texts.containsKey(SectionType.WORK_EXPERIENCE)){
				texts.put(SectionType.WORK_EXPERIENCE, new RMText(SectionType.WORK_EXPERIENCE));
			}
		}
	}

	//---Getters---//
	
	 /* Get the image*/
	public RMImage getImage(){
		return rmI;
	}
	
	//---Setters---//
	
	/*Change the image.*/
	public void setImage(Image image){
		this.rmI.setImage(image);
	}

	/*Change the Template*/
	public void setTemplate(Template tmpl){
		this.currentTempl = tmpl;
		createSections();
	}
	
	public Map<SectionType, RMText> getTexts() {
		return texts;
	}
	
	public void changeText (SectionType st, String text){
	if (!texts.containsKey(SectionType.WORK_EXPERIENCE) || 
			!texts.containsKey(SectionType.PERSONAL_INFO) ){
				createSections();
		}

	texts.get(st).setText(text);
	}

	public void changeTemplate(Template temp){
	/*List <SectionType> secs = TemplateToSections.translate(temp);
	List <String> text = new ArrayList <String>(3);
		for(int i = 0; i < secs.size(); i++) {
			text.add(texts.get(secs.get(i)).getText());
		}*/
	setTemplate(temp);
	}
		
}