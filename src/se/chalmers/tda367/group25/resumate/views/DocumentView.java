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
import java.awt.BorderLayout;

/**
 * This class contains a TemplatePanel which shows the Document.
 * The TemplatePanel can be changed.
 */
public class DocumentView extends JPanel implements PropertyChangeListener{
	private PropertyChangeSupport pcs;
	
	private TemplatePanel templatePnl;
	//This string is only for debugging:
	private String id;
	
	/**
	 * A new DocumentView with the default template is created.
	 */
	public DocumentView() {
		pcs = new PropertyChangeSupport(this);
		setLayout(new BorderLayout(0, 0));
		templatePnl = new CV_Def();
		add(templatePnl);
	}
	
	public DocumentView(TemplatePanel templatePanel) {
		pcs = new PropertyChangeSupport(this);	
		this.templatePnl = templatePanel;
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
	
	//METHODS USED TO DEBUG
	/*
	 * Get String-ID
	 */
	public String getID(){
		return this.id;
	}
	/*
	 * Set String-ID
	 */
	public void setID(String newID){
		this.id = newID;
	}

}
