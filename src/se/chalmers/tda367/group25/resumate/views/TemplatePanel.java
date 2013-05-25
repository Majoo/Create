package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.undo.UndoManager;

import se.chalmers.tda367.group25.resumate.utils.Labels;


/**
 * A class which represents the core of a Template. It holds the
 * methods for accesing the text in the different fields, for 
 * styling the text in the text areas and basic functions involving writing.
 */
public abstract class TemplatePanel extends JPanel implements FocusListener {

	private JTextPane personalInfoText;
	private JTextPane workingExperienceText;
	private JTextPane headerTF;
	private JTextPane educationText;
	private JLabel imageLbl;
	
	private JTextField txtName;
	private JTextField txtCityzipcode;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtEmpty;
	
	private JTextPane currentSection;
	private PropertyChangeSupport pcs;
	private UndoManager manager = new UndoManager();
	
 	/**
 	 * Create the panel. 
 	 * Is invoked in subclasses with the proper JTextPanes.
 	 */
	public TemplatePanel(){
		this.setBackground(Color.white);
		
		// Initialize components and adding settings 
		this.personalInfoText = new JTextPane();
		this.personalInfoText.setName("personalInfoText");
		this.personalInfoText.setText("Name: " +
				"\r\nAddress: \r\nCity/Zipcode: \r\nPhone:  \r\nEmail: ");
		this.personalInfoText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.personalInfoText.setToolTipText("Protip! " +
				"\r\nAlways use correct information! " +
				"You must therefore fill in all the blanks!");
		this.personalInfoText.addFocusListener(this);
		this.personalInfoText.getDocument().addUndoableEditListener(manager);
		Paint blackPaint = Color.black;
		personalInfoText.setBorder(BorderFactory.createDashedBorder(blackPaint));

		this.headerTF = new JTextPane();
		headerTF.setName("headerTitle");
		headerTF.setText("[HEADLINE]");
		headerTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		headerTF.setToolTipText("Protip! " +
				"\r\nUse a creative headline to attract the reader! " +
				"But be careful to not be too informal.");
		headerTF.setBorder(BorderFactory.createDashedBorder(blackPaint));
		headerTF.addFocusListener(this);
		headerTF.getDocument().addUndoableEditListener(manager);
		
		
		this.workingExperienceText = new JTextPane();
		this.workingExperienceText.setName("workingExperienceText");
		this.workingExperienceText.setText("[ABOUT YOURSELF]");
		this.workingExperienceText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.workingExperienceText.addFocusListener(this);
		this.workingExperienceText.getDocument().addUndoableEditListener(manager);
		this.workingExperienceText.setToolTipText("Protip! " +
				"\nAdjust your way of writing depending on the job you are looking for!");
		this.workingExperienceText.setBorder(BorderFactory.createDashedBorder(blackPaint));
		
		this.educationText = new JTextPane();
		this.educationText.setName("educationText");
		this.educationText.setText("[EDUCATION]");
		this.educationText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.educationText.addFocusListener(this);
		this.educationText.getDocument().addUndoableEditListener(manager);
		this.educationText.setBorder(BorderFactory.createDashedBorder(blackPaint));

		this.imageLbl = new JLabel();
		this.imageLbl.setBackground(Color.cyan);
		this.imageLbl.setVisible(true);
		setImageLabel(imageLbl);
		
		this.currentSection = personalInfoText;
		this.pcs = new PropertyChangeSupport(this);
		
		pcs.firePropertyChange(Labels.SEND_INITIAL_TSECTIONS, false, true);
	}

	//-----Getters-----
	/**
	 * Returns the personal information-textarea.
	 * 
	 * @return The JTextPane for personal information
	 */
	public JTextPane getPersonalInfoText() {
		return personalInfoText;
	}

	/**
	 * Returns the working experience-textarea.
	 * 
	 * @return The JTextPane for working experience
	 */
	public JTextPane getWorkingExperienceText() {
		return workingExperienceText;
	}

	/**
	 * Returns the (other) textarea.
	 * 
	 * @return JTextPane for other texts
	 */
	public JTextPane getHeaderTitle() {
		return headerTF;
	}
	
	/**
	 * Returns the label for the image
	 * 
	 * @return JLabel for the image
	 */
	public JLabel getImageLabel(){
		return imageLbl;
	}
	
	/**
	 * Returns the textarea for educational information.
	 * 
	 * @return
	 * 			The JTextPane for information about education
	 */
	public JTextPane getEducationText() {
		return this.educationText;
	}
	
	/**
	 * Returns the textarea for the current section
	 * 
	 * @return JTextPane for the section
	 */
	public JTextPane getCurrentSection(){
		return currentSection;
	}
	
	/**
	 * Returns the manager handling undo & redo
	 * 
	 * @return UndoManager for the sections
	 */
	public UndoManager getManager(){
		return manager;
	}
	//-----Setters for the image------
	
	/**
	 * Sets the image container
	 * 
	 * @return JTextPane for image
	 */
	public void setImageLabel(JLabel imageLabel) {
		this.imageLbl = imageLabel;
	}
	
	/**
	 * Shows in view the image given as parameter.
	 * The idea is to get the image from the model and 
	 * use this method to show it.
	 * @param image 
	 * 				BufferedImage to be shown in view
	 */
	public void showImage(BufferedImage image){
		imageLbl.setIcon(new ImageIcon(image));
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
	 * Removes a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be unregistered
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}
	
	
	//-----Focus-related methods------
	
	/**
	 * Sets the current section which is the one currently in focus.
	 * Informs the controller that the text area has changed so 
	 * that the view may be informed of these changes. 
	 * @param arg0 
	 * 			the focused container		
	 */
	
	@Override
	public void focusGained(FocusEvent arg0) {
		if(arg0.getComponent().getClass().equals(JTextPane.class)){
			currentSection = (JTextPane)arg0.getComponent();
			pcs.firePropertyChange(Labels.TEXTAREA_CHANGED, false, true);
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		//Do nothing, the JTextPane which is in focus 
		//will remain until another one is focused
		
	}
}
