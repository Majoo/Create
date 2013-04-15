package se.chalmers.tda367.group25.resumate;




public class Document {

	private IOHandler ioH;
	private Template templ;
	private History history;

	public Document(){
		templ = TemplateStorage.getTemplate("defaultCV"));
		history = new History();
		ioH = new IOHandler();
	}

	public Document(Template templ){
		this.templ = temp;
	}

	public void setImage(Image image){
		templ.getImageSection().setImage(image);
	}
}