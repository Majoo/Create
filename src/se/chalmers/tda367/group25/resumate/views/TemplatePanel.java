package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;

import se.chalmers.tda367.group25.resumate.utils.Labels;

/**
 * A class which represents the core of a Template. 
 * It holds the methods for accesing the text in the different fields, 
 * for styling the text in the text areas and basic functions involving writing.
 */
public abstract class TemplatePanel extends JPanel implements FocusListener {
	// Textfields with personal info titles
	private JTextField nameTitle;
	private JTextField cityzipcodeTitle;
	private JTextField addressTitle;
	private JTextField phoneTitle;
	private JTextField emailTitle;
		
	// Empty textfields with personal info
	private JTextField nameField;
	private JTextField cityzipcodeField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField empty1Field;
	private JTextField empty2Field;
	
	// Headers
	private JTextField workExpHeader;
	private JTextField educationHeader;	
	
	// Sections
	private JLabel imgLabel;
	private JTextPane workExpText;
	private JTextPane educationText;
	
	// Important variables
	private JTextComponent currentSection;
	private PropertyChangeSupport pcs;
	private UndoManager manager = new UndoManager();
	
	// List of those who should have a border that can be removed easily.
	int nbrOfAllComponents = 17;

	private List<JComponent> allComponents = 
			new ArrayList<JComponent>(nbrOfAllComponents);

	private List<JTextComponent> allTextComponents = new ArrayList<JTextComponent>(nbrOfAllComponents-1);

 	/**
 	 * Create the template panel. 
 	 * Is invoked in subclasses with the proper JTextPanes.
 	 * Setting all textfields.
 	 */
	public TemplatePanel(){		
		// Titles with personal info
		nameTitle = new JTextField();
		nameTitle.setName("nameTitle");
		nameTitle.setText("Name:");
		nameTitle.setColumns(10);
		nameTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(nameTitle);
		allTextComponents.add(nameTitle);
		nameTitle.addFocusListener(this);
		nameTitle.getDocument().addUndoableEditListener(manager);
		
		cityzipcodeTitle = new JTextField();
		cityzipcodeTitle.setName("cityzipcodeTitle");
		cityzipcodeTitle.setText("City/Zipcode:");
		cityzipcodeTitle.setColumns(10);
		cityzipcodeTitle.setBorder
		(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(cityzipcodeTitle);
		allTextComponents.add(cityzipcodeTitle);
		cityzipcodeTitle.addFocusListener(this);
		cityzipcodeTitle.getDocument().addUndoableEditListener(manager);
		
		addressTitle = new JTextField();
		addressTitle.setName("addressTitle");
		addressTitle.setText("Address:");
		addressTitle.setColumns(10);
		addressTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(addressTitle);
		allTextComponents.add(addressTitle);
		addressTitle.addFocusListener(this);
		addressTitle.getDocument().addUndoableEditListener(manager);
		
		phoneTitle = new JTextField();
		phoneTitle.setName("phoneTitle");
		phoneTitle.setText("Phone:");
		phoneTitle.setColumns(10);
		phoneTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(phoneTitle);
		allTextComponents.add(phoneTitle);
		phoneTitle.addFocusListener(this);
		phoneTitle.getDocument().addUndoableEditListener(manager);
		
		emailTitle = new JTextField();
		emailTitle.setName("emailTitle");
		emailTitle.setText("E-mail:");
		emailTitle.setColumns(10);
		emailTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(emailTitle);
		allTextComponents.add(emailTitle);
		emailTitle.addFocusListener(this);
		emailTitle.getDocument().addUndoableEditListener(manager);
		
		// Empty textfields with personal info
		nameField = new JTextField();
		nameField.setName("nameField");
		nameField.setColumns(10);
		nameField.setName("nameField");
		nameField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(nameField);
		allTextComponents.add(nameField);
		nameField.addFocusListener(this);
		nameField.getDocument().addUndoableEditListener(manager);
		
		addressField = new JTextField();
		addressField.setName("addressField");
		addressField.setColumns(10);
		addressField.setName("addressField");
		addressField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(addressField);
		allTextComponents.add(addressField);
		addressField.addFocusListener(this);
		addressField.getDocument().addUndoableEditListener(manager);
		
		cityzipcodeField = new JTextField();
		cityzipcodeField.setName("cityzipcodeField");
		cityzipcodeField.setColumns(10);
		cityzipcodeField.setBorder
		(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(cityzipcodeField);
		allTextComponents.add(cityzipcodeField);
		cityzipcodeField.addFocusListener(this);
		cityzipcodeField.getDocument().addUndoableEditListener(manager);
		
		phoneField = new JTextField();
		phoneField.setName("phoneField");
		phoneField.setColumns(10);
		phoneField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(phoneField);
		allTextComponents.add(phoneField);
		phoneField.addFocusListener(this);
		phoneField.getDocument().addUndoableEditListener(manager);
		
		emailField = new JTextField();
		emailField.setName("emailField");
		emailField.setColumns(10);
		emailField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(emailField);
		allTextComponents.add(emailField);
		emailField.addFocusListener(this);
		emailField.getDocument().addUndoableEditListener(manager);
		
		empty1Field = new JTextField();
		empty1Field.setName("empty1Field");
		empty1Field.setColumns(10);
		empty1Field.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(empty1Field);
		allTextComponents.add(empty1Field);
		empty1Field.addFocusListener(this);
		empty1Field.getDocument().addUndoableEditListener(manager);
		
		empty2Field = new JTextField();
		empty2Field.setName("empty2Field");
		empty2Field.setColumns(10);
		empty2Field.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(empty2Field);
		allTextComponents.add(empty2Field);
		empty2Field.addFocusListener(this);
		empty2Field.getDocument().addUndoableEditListener(manager);
		
		// Headers
		workExpHeader = new JTextField();
		workExpHeader.setName("workExpHeader");
		workExpHeader.setColumns(10);
		workExpHeader.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(workExpHeader);
		allTextComponents.add(workExpHeader);
		workExpHeader.addFocusListener(this);
		workExpHeader.getDocument().addUndoableEditListener(manager);
		
		educationHeader = new JTextField();
		educationHeader.setName("educationHeader");
		educationHeader.setColumns(10);
		educationHeader.setBorder
		(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(educationHeader);
		allTextComponents.add(educationHeader);
		educationHeader.addFocusListener(this);
		educationHeader.getDocument().addUndoableEditListener(manager);
		
		// Sections
		imgLabel = new JLabel("");
		imgLabel.setName("imgLabel");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(imgLabel);
		
		workExpText = new JTextPane();
		workExpText.setName("workExpText");
		workExpText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(workExpText);
		allTextComponents.add(workExpText);
		workExpText.addFocusListener(this);
		workExpText.getDocument().addUndoableEditListener(manager);
		
		educationText = new JTextPane();
		educationText.setName("educationText");
		educationText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		allComponents.add(educationText);
		allTextComponents.add(educationText);
		educationText.addFocusListener(this);
		educationText.getDocument().addUndoableEditListener(manager);
		
		// Important variables
		this.currentSection = nameField;
		this.pcs = new PropertyChangeSupport(this);
	}

	// -----Getters-----
	// Textfields with personal info titles
	
	/**
	 * Get the JTextField that indicates the user to write their name.
	 * @return
	 * 			the JTextField that indicates the user to write their name.
	 */
	public JTextField getNameTitle(){
		return this.nameTitle;
	}
	
	/**
	 * Get the JTextField that indicates the user to write their address.
	 * @return
	 * 			the JTextField that indicates the user to write their address.
	 */
	public JTextField getAddressTitle(){
		return this.addressTitle;
	}
	
	/**
	 * Get the JTextField that indicates the user to write their City/Zipcode.
	 * @return
	 * 			the JTextField that indicates the user 
	 * 			to write their City/Zipcode.
	 */
	public JTextField getCityTitle(){
		return this.cityzipcodeTitle;
	} 
	
	/**
	 * Get the JTextField that indicates the user to write their phone number.
	 * @return
	 * 			the JTextField that indicates the user 
	 * 			to write their phone number.
	 */
	public JTextField getPhoneTitle(){
		return this.phoneTitle;
	}
	
	/**
	 * Get the JTextField that indicates the user to write their email-address.
	 * @return
	 * 			the JTextField that indicates the user 
	 * 			to write their email-address.
	 */
	public JTextField getEmailTitle(){
		return this.emailTitle;
	}
	
	// Empty textfields with personal info
	/**
	 * Get the JTextField where the user usually writes their name.
	 * @return
	 * 			the JTextField where the user usually writes their name.
	 */
	public JTextField getNameField(){
		return this.nameField;
	}
	
	/**
	 * Get the JTextField where the user usually writes their address.
	 * @return
	 * 			the JTextField where the user usually writes their address.
	 */
	public JTextField getAddressField(){
		return this.addressField;
	}
	
	/**
	 * Get the JTextField where the user usually writes their city.
	 * @return
	 * 			the JTextField where the user usually writes their city.
	 */
	public JTextField getCityField(){
		return this.cityzipcodeField;
	} 
	
	/**
	 * Get the JTextField where the user usually writes their phone number.
	 * @return
	 * 			the JTextField where the user usually writes their phone number.
	 */
	public JTextField getPhoneField(){
		return this.phoneField;
	}
	
	/**
	 * Get the JTextField where the user usually writes their mail address.
	 * @return
	 * 			the JTextField where the user usually writes their mail address.
	 */
	public JTextField getEmailField(){
		return this.emailField;
	}
	
	/**
	 * Get the JTextField where the user can manually writes whatever they like.
	 * @return
	 * 			the JTextField where the user can write whatever they like.
	 */
	public JTextField getEmptyField1(){
		return this.empty1Field;
	}
	
	/**
	 * Get the JTextField where the user can manually writes whatever they like.
	 * @return
	 * 			the JTextField where the user can write whatever they like.
	 */
	public JTextField getEmptyField2(){
		return this.empty2Field;
	}
	
	// Headers
	/**
	 * Get the header (headline) for writing "Education".
	 * @return
	 * 			the header (headline) for writing "Education".
	 */
	public JTextField getEduHeader(){
		return this.educationHeader;
	}
	
	/**
	 * Get the header (headline) for writing "Work Experience".
	 * @return
	 * 			the header (headline) for writing "Work Experience".
	 */
	public JTextField getWorkExpHeader(){
		return this.workExpHeader;
	}
	

	// Sections
	/**
	 * Get the "Image Label"
	 * @return
	 * 			the Image Label
	 */
	public JLabel getImageLabel(){
		return this.imgLabel;
	}
	
	/**
	 * Get the "Working Experience Text"
	 * @return
	 * 			the Working Experience Text
	 */
	public JTextPane getWorkingExperienceText(){
		return this.workExpText;
	}
	
	/**
	 * Get the "Education Text"
	 * @return
	 * 			the Education text
	 */
	public JTextPane getEducationText(){
		return this.educationText;
	}
	
	// Important variables
	/**
	 * Returns the textarea for the current section.
	 * 
	 * @return 
	 * 			JTextPane for the section.
	 */
	public JTextComponent getCurrentSection(){
		return currentSection;
	}

	/**
	 * Returns the manager handling undo and redo
	 * @return 
	 * 			UndoManager for the sections.
	 */
	public UndoManager getManager() {
		return manager;
	}
	
	// List of bordered components
	public List<JComponent> getAllComponents(){
		return this.allComponents;
	}
	
	public List<JTextComponent> getTextComponents(){
		return this.allTextComponents;
	}
	
	
	// -----Setters for the image-----

	/**
	 * Shows in view the image given as parameter. 
	 * The idea is to get the image from the model 
	 * and use this method to show it.
	 * 
	 * @param image
	 *            BufferedImage to be shown in view
	 */
	public void showImage(BufferedImage image){
		imgLabel.setIcon(new ImageIcon(image));
	}

	// -----PropertyChanged-Methods------
	/**
	 * Adds a propertychange listener to this class.
	 * @param pcl
	 * 			the listener to be registered 
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl){
			pcs.addPropertyChangeListener(pcl);
	}

	
	/**
	 * Removes a propertychange listener to this class.
	 * @param pcl 
	 * 			the listener to be unregistered
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}	
	
	// -----Focus-related methods------
	/**
	 * Sets the current section which is the one currently in focus.
	 * Informs the controller that the text area has changed 
	 * so that the view may be informed of these changes.  
	 * @param arg0 
	 * 			the focused container		
	 */

	@Override
	public void focusGained(FocusEvent arg0) {
		if(arg0.getComponent() instanceof JTextComponent){
			currentSection = (JTextComponent)arg0.getComponent();
			System.out.println("focus");
			pcs.firePropertyChange(Labels.TEXTAREA_CHANGED, false, true);
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// Do nothing, the JTextPane which is in focus 
		// will remain until another one is focused

	}
}
