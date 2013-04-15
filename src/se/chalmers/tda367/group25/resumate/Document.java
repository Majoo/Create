package se.chalmers.tda367.group25.resumate;
import java.awt.Image;



import se.chalmers.tda367.group25.resumate.utils.TemplateStorage;

public class Document {
	private IOHandler ioH;
	private Template CurrentTempl;
	private History history;

	public Document(){
		this(TemplateStorage.getTemplate("defaultCV"));
	}


	public Document(Template templ) {
		this.CurrentTempl = templ;
		history = new History();
		ioH = new IOHandler();

	}


	/**
	 * At the moment, we're lacking assignments of templ and history in the
	 * second constructor. Should we solve this by doing the following:
	 * 
	 * public Document() {
	 * 		this(TemplateStorage.getTemplate("defaultCV"));
	 * }
	 * 
	 * public Document(Template templ){
	 * 		this.templ = templ;
	 * 		history = new History();
	 * 		ioH = new IOHandler();
	 * }
	 */


	public void setImage(Image image){
		CurrentTempl.getImageSection().setImage(image);

	}

	public RMImage getImage(Image image){
		return CurrentTempl.getImageSection();
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