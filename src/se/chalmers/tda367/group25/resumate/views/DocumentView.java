package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * This class contains a TemplatePanel which shows the Document. 
 * The TemplatePanel can be changed.
 */
public class DocumentView extends JPanel implements PropertyChangeListener {
	private PropertyChangeSupport pcs;

	private TemplatePanel templatePnl;
	
	/**
	 * A new DocumentView with the default template is created.
	 */
	public DocumentView() {
		this(new CV_Def2());
	}

	/**
	 * A new DocumentView with a specified template is created.
	 * @param templatePanel
	 * 				the TemplatePanel specified for the new DocumentView.
	 *
	 */
	public DocumentView(TemplatePanel templatePanel) {
		pcs = new PropertyChangeSupport(this);
		
		setPreferredSize(new Dimension(599, 1000));
		this.templatePnl = templatePanel;
		templatePnl.getEducationText().setToolTipText("Enter your education experiences.");
		templatePnl.getEduHeader().setToolTipText("<html>Headline for your education experiences. <br><b>Protip!</b><br> Instead of <i>Education</i> you could use something more creative. <br> But be careful to not be too informal.</html>");
		templatePnl.getEduHeader().setText("[EDUCATION HEADLINE]");
		templatePnl.getWorkingExperienceText().setToolTipText("<html>Enter the work experiences you've got. " +
				"<br>Do not forget to add a reference to your earlier employers. <br>" +
				"<b>Protip!</b> Make a list of your working experiences like a timeline.</html>");
		templatePnl.getCityField().setToolTipText("Enter the current city and zipcode you're living in.");
		templatePnl.getAddressField().setToolTipText("Enter your home address.");
		templatePnl.getEmailField().setToolTipText("<html>Enter the email account that you are <br>most active at so the employer can contact you.</html>");
		templatePnl.getPhoneField().setToolTipText("<html>Enter a phone number where <br>your employer can  reach you anytime.</html>");
		templatePnl.getCurrentSection().setToolTipText("Enter your full name (first, mid and last name)");
		templatePnl.getWorkExpHeader().setText("[HEADLINE]");
		templatePnl.getWorkExpHeader().setToolTipText("<html><b>Protip!</b> Use a creative headline to attract your employer!</html>");
		templatePnl.getImageLabel().setToolTipText("<html>This is where your picture will be located. <br><b>Protip!</b> Use a face frontal picture with good quality.</html>");
		templatePnl.getEmptyField2().setToolTipText("<html>Write down whatever you want. <br>" +
				"<b>Protip!</b> Your twitter account?</html>");
		templatePnl.getEmptyField1().setToolTipText("<html>Write down whatever you want. <br>" +
				"<b>Protip!</b> Your personal code number?</html>");
		templatePnl.setToolTipText("<html><b>Protip!</b> <br> " +
				"Attract your employer by making your <br><i>Curriculum Vitae</i> or <i>Personal Letter</i> interesting.</html>");
		templatePnl.getCityTitle().setToolTipText("Fill in the name of your city and the zipcode.");
		templatePnl.getAddressTitle().setToolTipText("Fill in your home address.");
		templatePnl.getEmailTitle().setToolTipText("Fill in your mail address.");
		templatePnl.getPhoneTitle().setToolTipText("Fill in your phone number.");
		templatePnl.getNameTitle().setToolTipText("Fill in your first and last name.");
		templatePnl.getWorkingExperienceText().setFont
		(new Font("Tahoma", Font.PLAIN, 14));
		templatePnl.getCurrentSection().setFont
		(new Font("Tahoma", Font.PLAIN, 14));
		templatePnl.getWorkExpHeader().setFont
		(new Font("Tahoma", Font.PLAIN, 12));
		templatePnl.addPropertyChangeListener(this);
		add(templatePnl);
		
		// A Scrollpane to the template panel
		JScrollPane scroller = new JScrollPane(templatePnl);
		scroller.setVerticalScrollBarPolicy
		(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy
		(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroller);
	}


	// -----Getters------

	 /** Get the TemplatePanel of the DocumentView.
	 * @return
	 * 			the TemplatePanel of this DocumentView.
	 */
	public TemplatePanel getTemplatePanel(){
		return templatePnl;
	}
	// -----Setters------
	/**
	 * Set the TemplatePanel of this DocumentView.
	 * @param tmplPnl
	 * 			the template panel to be set.
	 */
	public void setTemplate(TemplatePanel tmplPnl){
		System.out.println("Setting template in DocumentViews");
		this.templatePnl = tmplPnl;
		this.templatePnl.validate();
		this.templatePnl.updateUI();
	}
	

	// ----- PROPERTY-CHANGE-METHODS ------
	/**
	 * Adds a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be registered
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl){
			pcs.addPropertyChangeListener(pcl);
	}

	/**
	 *Removes a propertychange listener to this class.
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
		pcs.firePropertyChange(evt.getPropertyName(),evt.getOldValue(),
				evt.getNewValue());
		
		try{
			pcs.firePropertyChange(evt.getPropertyName(),evt.getOldValue(),
					evt.getNewValue());
		} catch (NullPointerException e){
			System.out.println("Caught NullPointerException " +
					"in DocumentViews propertyChange");
		}
		
	}
}
