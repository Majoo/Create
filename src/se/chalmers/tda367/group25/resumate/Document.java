package se.chalmers.tda367.group25.resumate;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.utils.SectionName;
import se.chalmers.tda367.group25.resumate.utils.Template;


public class Document {
	//helpers
	private IOHandler ioH;
	private History history;
	//other instance variables
	private Template currentTempl;
	//sections
	private List<RMText> texts = new ArrayList<RMText>(2);
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
		ioH = new IOHandler();

		//create sections according to Template.
		createSections();
	}

	/*Create sections according to Template.*/
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
	}

}