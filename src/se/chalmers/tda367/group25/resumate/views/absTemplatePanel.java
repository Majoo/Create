package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.InputMethodEvent;
import java.util.List;

import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.utils.Template;

public abstract class AbsTemplatePanel extends JPanel {

	private DocumentView view;
	
	public void textUpdate(InputMethodEvent arg0, String text){
		
		if(view.equals(null)){
			view = new DocumentView();
		}
		view.textAction(arg0, text);
		
	}
	
	public void changedTemplate(Template templateName){
		view.changedTemplate(templateName);
		//TODO: detta ger nullpointer, checka why today!
	}
	
	public abstract void updateTextInView(List <String> text);
	
}
