package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.InputMethodEvent;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

public abstract class absTemplatePanel extends JPanel {

	private ResumateView View;
	
	public void textUpdate(InputMethodEvent arg0, String text){
		
		if(View.equals(null)){
			View = new ResumateView();
		}
		View.textAction(arg0, text);
		
	}
	
}
