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
		pcs = new PropertyChangeSupport(this);
		setLayout(new BorderLayout(0, 0));
		templatePnl = new CV_Def();
		templatePnl.getHeaderTitle().setText(" [HEADLINE]");
		templatePnl.getWorkingExperienceText().setText(" [ABOUT YOURSELF]");
		templatePnl.getHeaderTitle().setFont(new Font("Tahoma", Font.PLAIN, 20));
		templatePnl.getWorkingExperienceText().setToolTipText("Protip! \nAdjust your way of writing depending on the job you are looking for!");
		templatePnl.getHeaderTitle().setToolTipText("Protip! \r\nUse a creative headline to attract the reader! But be careful to not be too informal.");
		templatePnl.getCurrentSection().setToolTipText("Protip! \r\nAlways use correct information! You must therefore fill in all the blanks!");
		templatePnl.getCurrentSection().setText("Name: \r\nAddress: \r\nCity/Zipcode: \r\nPhone:  \r\nEmail: ");
		add(templatePnl);
		
		JScrollPane scroller = new JScrollPane(templatePnl);
		 
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroller);
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
