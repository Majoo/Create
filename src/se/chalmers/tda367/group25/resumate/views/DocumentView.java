package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import se.chalmers.tda367.group25.resumate.views.concreteTemplatePanels.CV_Def;

/**
 * This class contains a TemplatePanel which shows the Document.
 * The TemplatePanel can be changed.
 */
public class DocumentView extends JPanel implements PropertyChangeListener{
	private PropertyChangeSupport pcs;
	
	private TemplatePanel templatePnl;
	
	/**
	 * A new DocumentView with the default template is created.
	 */
	public DocumentView() {
		pcs = new PropertyChangeSupport(this);
		templatePnl = new CV_Def();
		add(templatePnl);
			
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
