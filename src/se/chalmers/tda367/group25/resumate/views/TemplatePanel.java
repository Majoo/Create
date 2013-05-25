package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.Paint;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;
import javax.swing.JComponent;

import se.chalmers.tda367.group25.resumate.utils.Labels;

/**
 * A class which represents the core of a Template. It holds the
 * methods for accesing the text in the different fields, for 
 * styling the text in the text areas and basic functions involving writing.
 */
public abstract class TemplatePanel extends JPanel implements FocusListener {
	//Personal Info Titles
	private JTextField nameTitle;
	private JTextField cityzipcodeTitle;
	private JTextField addressTitle;
	private JTextField phoneTitle;
	private JTextField emailTitle;
		
	//Personal Info TextFields
	private JTextField nameField;
	private JTextField cityzipcodeField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField empty1Field;
	private JTextField empty2Field;
	
	//Headers
	private JTextField workExpHeader;
	private JTextField educationHeader;	
	
	//Sections
	JLabel imgLabel;
	JTextPane workExperienceText;
	JTextPane educationText;
	
	//Important
	private JTextComponent currentSection;
	private PropertyChangeSupport pcs;
	private UndoManager manager = new UndoManager();
	
	//List of those who should have a border that can be removed easily.
	int nbrOfBorderedComponents = 17;
	private ArrayList<JComponent> borderedComponents = new ArrayList<JComponent>(nbrOfBorderedComponents);

 	/**
 	 * Create the panel. 
 	 * Is invoked in subclasses with the proper JTextPanes.
 	 */
	public TemplatePanel(){		
		//Personal Info Titles
		nameTitle = new JTextField();
		nameTitle.setText("Name:");
		nameTitle.setColumns(10);
		nameTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(nameTitle);
		
		cityzipcodeTitle = new JTextField();
		cityzipcodeTitle.setText("City/Zipcode:");
		cityzipcodeTitle.setColumns(10);
		cityzipcodeTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(cityzipcodeTitle);
		
		addressTitle = new JTextField();
		addressTitle.setText("Address:");
		addressTitle.setColumns(10);
		addressTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(addressTitle);
		
		phoneTitle = new JTextField();
		phoneTitle.setText("Phone:");
		phoneTitle.setColumns(10);
		phoneTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(phoneTitle);
		
		emailTitle = new JTextField();
		emailTitle.setText("E-mail:");
		emailTitle.setColumns(10);
		emailTitle.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(emailTitle);
		
		//Personal Info TextFields
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(nameField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(addressField);
		
		cityzipcodeField = new JTextField();
		cityzipcodeField.setColumns(10);
		cityzipcodeField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(cityzipcodeField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(phoneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(emailField);
		
		empty1Field = new JTextField();
		empty1Field.setColumns(10);
		empty1Field.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(empty1Field);
		
		empty2Field = new JTextField();
		empty2Field.setColumns(10);
		empty2Field.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(empty2Field);
		
		//Headers
		workExpHeader = new JTextField();
		workExpHeader.setColumns(10);
		workExpHeader.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(workExpHeader);
		
		educationHeader = new JTextField();
		educationHeader.setColumns(10);
		educationHeader.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(educationHeader);
		
		//Sections
		imgLabel = new JLabel("");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(imgLabel);
		
		workExperienceText = new JTextPane();
		workExperienceText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(workExperienceText);
		
		educationText = new JTextPane();
		educationText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		borderedComponents.add(educationText);
		
		//Important
		this.currentSection = workExperienceText;
		this.pcs = new PropertyChangeSupport(this);
		pcs.firePropertyChange(Labels.SEND_INITIAL_TSECTIONS, false, true);
	}

	//-----Getters-----
	//Personal Info Titles
	
	/**
	 * Get the JTextField that tells the user to write their name.
	 * @return
	 * 			the JTextField that tells the user to write their name.
	 */
	public JTextField getNameTitle(){
		return this.nameTitle;
	}
	
	/**
	 * Get the JTextField that tells the user to write their address.
	 * @return
	 * 			the JTextField that tells the user to write their address.
	 */
	public JTextField getAddressTitle(){
		return this.addressTitle;
	}
	
	/**
	 * Get the JTextField that tells the user to write their City/Zipcode.
	 * @return
	 * 			the JTextField that tells the user to write their City/Zipcode.
	 */
	public JTextField getCityTitle(){
		return this.cityzipcodeTitle;
	} 
	
	/**
	 * Get the JTextField that tells the user to write their phone number.
	 * @return
	 * 			the JTextField that tells the user to write their phone number.
	 */
	public JTextField getPhoneTitle(){
		return this.phoneTitle;
	}
	
	/**
	 * Get the JTextField that tells the user to write their email-address.
	 * @return
	 * 			the JTextField that tells the user to write their email-address.
	 */
	public JTextField getEmailTitle(){
		return this.emailTitle;
	}
	
	//Personal Info TextFields
	/**
	 * Get the JTextField were´the user usually writes their name.
	 * @return
	 * 			the JTextField were´the user usually writes their name.
	 */
	public JTextField getNameField(){
		return this.nameField;
	}
	
	/**
	 * Get the JTextField were´the user usually writes their address.
	 * @return
	 * 			the JTextField were´the user usually writes their address.
	 */
	public JTextField getAddressField(){
		return this.addressField;
	}
	
	/**
	 * Get the JTextField were´the user usually writes their City/Zipcode.
	 * @return
	 * 			the JTextField were´the user usually writes their City/Zipcode.
	 */
	public JTextField getCityField(){
		return this.cityzipcodeField;
	} 
	
	/**
	 * Get the JTextField were´the user usually writes their phone number.
	 * @return
	 * 			the JTextField were´the user usually writes their phone number.
	 */
	public JTextField getPhoneField(){
		return this.phoneField;
	}
	
	/**
	 * Get the JTextField were´the user usually writes their email-address.
	 * @return
	 * 			the JTextField were´the user usually writes their email-address.
	 */
	public JTextField getEmailField(){
		return this.emailField;
	}
	
	/**
	 * Get the first JTextField were the user can write whatever personal info they like.
	 * @return
	 * 			the first JTextField were the user can write whatever personal info they like.
	 */
	public JTextField getEmptyField1(){
		return this.empty1Field;
	}
	
	/**
	 * Get the second JTextField were the user can write whatever personal info they like.
	 * @return
	 * 			the second JTextField were the user can write whatever personal info they like.
	 */
	public JTextField getEmptyField2(){
		return this.empty2Field;
	}
	
	//Headers
	/**
	 * Get the header for writing "Education".
	 * @return
	 * 			the header for writing "Education".
	 */
	public JTextField getEduHeader(){
		return this.educationHeader;
	}
	
	/**
	 * Get the header for writing "Work Experience".
	 * @return
	 * 			the header for writing "Work Experience".
	 */
	public JTextField getWorkExpHeader(){
		return this.workExpHeader;
	}
	

	//Sections
	/**
	 * Get the Image Label
	 * @return
	 * 			the Image Label
	 */
	public JLabel getImageLabel(){
		return this.imgLabel;
	}
	
	/**
	 * Get the Working Experience Text
	 * @return
	 * 			the Working Experience Text
	 */
	public JTextPane getWorkingExperienceText(){
		return this.workExperienceText;
	}
	
	/**
	 * Get the Education Text
	 * @return
	 * 			the Education text
	 */
	public JTextPane getEducationText(){
		return this.educationText;
	}
	
	//Important
	/**
	 * Returns the textarea for the current section
	 * 
	 * @return JTextPane for the section
	 */
	public JTextComponent getCurrentSection(){
		return currentSection;
	}

	/**
	 * Returns the manager handling undo & redo
	 * 
	 * @return UndoManager for the sections
	 */
	public UndoManager getManager() {
		return manager;
	}
	
	//List
	public ArrayList<JComponent> getBorderedComponents(){
		return this.borderedComponents;
	}
	
	//-----Setters for the image-----

	/**
	 * Shows in view the image given as parameter. The idea is to get the image
	 * from the model and use this method to show it.
	 * 
	 * @param image
	 *            BufferedImage to be shown in view
	 */
	public void showImage(BufferedImage image){
		imgLabel.setIcon(new ImageIcon(image));
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
