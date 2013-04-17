package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.InputMethodEvent;
import java.util.List;

import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.utils.Template;

public abstract class absTemplatePanel extends JPanel {

	private ResumateView View;
	
	public void textUpdate(InputMethodEvent arg0, String text){
		
		if(View.equals(null)){
			View = new ResumateView();
		}
		View.textAction(arg0, text);
		
	}
	
	public void changedTemplate(Template templateName){
		View.changedTemplate(templateName);
		//TODO: detta ger nullpointer, checka why today!
	}
	
	public abstract void updateTextInView(List <String> text);
	
}
