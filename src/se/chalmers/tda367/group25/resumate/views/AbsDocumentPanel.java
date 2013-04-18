package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.InputMethodEvent;
import java.util.List;

import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.utils.Template;

public abstract class AbsDocumentPanel extends JPanel {

	protected DocumentView view;

	public void textUpdate(InputMethodEvent arg0, String text) {
		view.textAction(arg0, text);
	}

	public void setView(DocumentView view) {
		this.view = view;
	}

	public void changedTemplate(Template templateName) {
		view.changedTemplate(templateName);
	}

	public abstract void updateTextInView(List<String> text);

}
