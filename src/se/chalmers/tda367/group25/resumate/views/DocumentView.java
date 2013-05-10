package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.SpringLayout;

/**
 * This class contains a TemplatePanel which shows the Document.
 * The TemplatePanel can be changed.
 */
public class DocumentView extends JPanel{
	private PropertyChangeSupport pcs;
	
	private TemplatePanel templatePnl;
	
	public DocumentView() {
		pcs = new PropertyChangeSupport(this);
			
	}
	
	//GETTERS
	public TemplatePanel getTemplatePanel(){
		return templatePnl;
	}
	
	//SETTERS
	public void setTemplate(TemplatePanel tmplPnl){
		this.templatePnl = tmplPnl;
	}
	
	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}

}
