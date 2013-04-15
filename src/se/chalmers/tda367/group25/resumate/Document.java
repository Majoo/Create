package se.chalmers.tda367.group25.resumate;

import java.awt.Image;

import se.chalmers.tda367.group25.resumate.utils.TemplateStorage;

public class Document {

	private IOHandler ioH;
	private Template templ;
	private History history;

	public Document() {
		templ = TemplateStorage.getTemplate("defaultCV");
		history = new History();
		ioH = new IOHandler();
	}

	public Document(Template templ) {
		this.templ = templ;
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
}