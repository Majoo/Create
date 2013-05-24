package se.chalmers.tda367.group25.resumate.views;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ScrollPaneConstants;
import java.awt.Font;

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
		this(new CV_Def());
	}
	
	public DocumentView(TemplatePanel templatePanel) {
		pcs = new PropertyChangeSupport(this);
		setLayout(new BorderLayout(0, 0));
		this.templatePnl = templatePanel;
		templatePnl.addPropertyChangeListener(this);
		add(templatePnl);
		
		JScrollPane scroller = new JScrollPane(templatePnl);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroller);
	}

	//GETTERS
	public TemplatePanel getTemplatePanel(){
		return templatePnl;
	}
	
	//SETTERS
	public void setTemplate(TemplatePanel tmplPnl){
		System.out.println("Setting template");
		this.templatePnl = tmplPnl;
		this.templatePnl.validate();
		this.templatePnl.updateUI();
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
		System.out.println("In DocView changed");
		try{
			pcs.firePropertyChange(evt.getPropertyName(),evt.getOldValue(),
					evt.getNewValue());
		} catch (NullPointerException e){
			
		}
		
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
