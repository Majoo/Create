package se.chalmers.tda367.group25.resumate.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * This class contains a TemplatePanel which shows the Document. The
 * TemplatePanel can be changed.
 */
public class DocumentView extends JPanel implements PropertyChangeListener {
	private PropertyChangeSupport pcs;

	private TemplatePanel templatePnl;
	
	/**
	 * A new DocumentView with the default template is created.
	 */
	public DocumentView() {
		this(new CV_Def());
	}

	/**
	 * A new DocumentView with a specified template is created.
	 * @param templatePanel
	 * 						the TemplatePanel specified for the new DocumentView
	 *
	 */
	public DocumentView(TemplatePanel templatePanel) {
		pcs = new PropertyChangeSupport(this);
		setLayout(new BorderLayout(0, 0));
		this.templatePnl = templatePanel;
		templatePnl.getWorkingExperienceText().setFont(new Font("Tahoma", Font.PLAIN, 14));
		templatePnl.getCurrentSection().setFont(new Font("Tahoma", Font.PLAIN, 14));
		templatePnl.getHeaderTitle().setFont(new Font("Tahoma", Font.PLAIN, 27));
		templatePnl.addPropertyChangeListener(this);
		add(templatePnl);
		
		// A Scrollpane to the template panel
		JScrollPane scroller = new JScrollPane(templatePnl);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroller);
	}


	//-----Getters------

	 /* Get the TemplatePanel of the DocumentView.
	 * @return
	 * 			the TemplatePanel of this DocumentView
	 */
	public TemplatePanel getTemplatePanel(){
		return templatePnl;
	}
	//-----Setters------

	/**
	 * Set the TemplatePanel of this DocumentView.
	 * @param tmplPnl
	 */
	public void setTemplate(TemplatePanel tmplPnl){
		System.out.println("Setting template in DocumentViews");
		this.templatePnl = tmplPnl;
		this.templatePnl.validate();
		this.templatePnl.updateUI();
	}
	

	//-----PropertyChanged-Methods------
	/**
	 * Adds a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be registered
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 *Removes a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be unregistered
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}
	
	/**
	 * Fires the propertychange event further to the main controller
	 * where the events are to be handled.
	 * 
	 * @param arg0
	 * 		the source of the event
	 * 		
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		try{
			pcs.firePropertyChange(evt.getPropertyName(),evt.getOldValue(),
					evt.getNewValue());
		} catch (NullPointerException e){
			
		}
		
	}
}
