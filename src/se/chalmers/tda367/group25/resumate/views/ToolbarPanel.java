package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.Template;

public class ToolbarPanel extends JPanel implements ActionListener{
	private PropertyChangeSupport pcs;
	private JComboBox textSizeCB;
	private JComboBox textFontCB;
	private JComboBox textColorCB;
	
	/**
	 * Create the panel with buttons.
	 */
	public ToolbarPanel() {
		setBorder(new LineBorder(SystemColor.activeCaption));
		setBackground(Color.WHITE);
		SpringLayout spLayout = new SpringLayout();
		setLayout(spLayout);

		//Setting Tools panel
		JPanel toolsPan = new JPanel();
		spLayout.putConstraint
		(SpringLayout.NORTH, toolsPan, 0, SpringLayout.NORTH, this);
		spLayout.putConstraint
		(SpringLayout.WEST, toolsPan, 0, SpringLayout.WEST, this);
		spLayout.putConstraint
		(SpringLayout.SOUTH, toolsPan, 69, SpringLayout.NORTH, this);
		toolsPan.setLayout(new GridLayout(2,1));
		
		//Setting upper part tools panel
		JPanel upperToolsPan = new JPanel();
		upperToolsPan.setBackground(Color.WHITE);
		upperToolsPan.setLayout(new GridLayout(1,10));
		toolsPan.add(upperToolsPan);

		//Setting all the buttons and giving them actions
		JButton btnNewDoc = new JButton("New");
		btnNewDoc.setToolTipText("New document.");
		btnNewDoc.addActionListener(this);
		btnNewDoc.setActionCommand("New");
		upperToolsPan.add(btnNewDoc);

		JButton btnOpen = new JButton("Open");
		btnOpen.setToolTipText("Open document.");
		btnOpen.addActionListener(this);
		btnOpen.setActionCommand("Open");
		upperToolsPan.add(btnOpen);

		JButton btnSave = new JButton("Save");
		btnSave.setToolTipText("Save the document.");
		btnSave.addActionListener(this);
		btnSave.setActionCommand("Save");
		upperToolsPan.add(btnSave);

		JButton btnExport = new JButton("Export");
		btnExport.setToolTipText("Export the document as PDF.");
		btnExport.addActionListener(this);
		btnExport.setActionCommand("Export");
		upperToolsPan.add(btnExport);

		JButton btnPrint = new JButton("Print");
		btnPrint.setToolTipText("Print the document.");
		btnPrint.addActionListener(this);
		btnPrint.setActionCommand("Print");
		upperToolsPan.add(btnPrint);

		JButton btnCut = new JButton("Cut");
		btnCut.setToolTipText("Cut the selected text.");
		btnCut.addActionListener(this);
		btnCut.setActionCommand("Cut");
		upperToolsPan.add(btnCut);

		JButton btnCopy = new JButton("Copy");
		btnCopy.setToolTipText("Copy the selected text.");
		btnCopy.addActionListener(this);
		btnCopy.setActionCommand("Copy");
		upperToolsPan.add(btnCopy);

		JButton btnPaste = new JButton("Paste");
		btnPaste.setToolTipText("Paste the copied text.");
		btnPaste.addActionListener(this);
		btnPaste.setActionCommand("Paste");
		upperToolsPan.add(btnPaste);

		JButton btnRedo = new JButton("Redo");
		btnRedo.setToolTipText("Redo an action.");
		btnRedo.addActionListener(this);
		btnRedo.setActionCommand("Redo");
		upperToolsPan.add(btnRedo);

		JButton btnUndo = new JButton("Undo");
		btnUndo.setToolTipText("Undo an action.");
		btnUndo.addActionListener(this);
		btnUndo.setActionCommand("Undo");
		upperToolsPan.add(btnUndo);
		
		// Lower part tools panel
		JPanel lowerToolsPan = new JPanel();
		lowerToolsPan.setBackground(Color.WHITE);

		// Setting properties for the combobox in which the fonts are listed
		textFontCB = new JComboBox();
		textFontCB.setToolTipText("Protip! " +
				"Don't have too many different fonts! " +
				"It will look unprofessional.");
		textFontCB.addActionListener(this);
		textFontCB.setActionCommand("Font");
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String [] fontes = e.getAvailableFontFamilyNames();
		textFontCB.setModel(new DefaultComboBoxModel(fontes));

		/* Setting properties for the combobox 
		* in which the sizes for the text are listed
		*/
		textSizeCB = new JComboBox();
		textSizeCB.setToolTipText("Protip! " +
				"Size 20 is perfect for headlines. " +
				"Otherwise, use size 11 as default.");
		textSizeCB.addActionListener(this);
		textSizeCB.setActionCommand("Size");
		
		textSizeCB.setModel(new DefaultComboBoxModel(new String[] 
				{"9", "10", "11", "12", "13", "14", "15", "16", 
				"18", "20", "22", "24", "26", "28", "30", "32"}));
		
		// Setting properties for the button which makes the text bold
		JToggleButton btnBold = new JToggleButton("B");
		btnBold.setToolTipText("Protip! " +
				"You can make the headline bolded and all the subheadlines!");
		btnBold.addActionListener(this);
		btnBold.setActionCommand("Bold");
		btnBold.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Setting properties for the button which make the text italic
		JToggleButton btnItalic = new JToggleButton("I");
		btnItalic.setToolTipText("Protip! " +
				"Use this for names of schools, programs etc.");
		btnItalic.addActionListener(this);
		btnItalic.setActionCommand("Italic");	
		btnItalic.setFont(new Font("Tahoma", Font.ITALIC, 11));

		// Setting properties for the button which make the text underlined
		JToggleButton btnUnderline = new JToggleButton("U");
		btnUnderline.setToolTipText("Protip! " +
				"Use this to emphasize.");
		btnUnderline.addActionListener(this);
		btnUnderline.setActionCommand("Underline");	
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		map.put(TextAttribute.UNDERLINE,
				TextAttribute.UNDERLINE_ON);
		btnUnderline.setFont(btnUnderline.getFont().deriveFont(map));
		
		// Setting properties for the button which make the text coloured
		textColorCB = new JComboBox();
		textColorCB.setToolTipText("Protip! Do not use too many different colors!");
		textColorCB.setModel(new DefaultComboBoxModel(new String[] 
				{"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green",
				"Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"}));
		textColorCB.addActionListener(this);
		textColorCB.setActionCommand("Color");

		//Setting placement of the GUI
		GroupLayout layoutToolsPan = new GroupLayout(lowerToolsPan);
		layoutToolsPan.setHorizontalGroup(
			layoutToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutToolsPan.createSequentialGroup()
					.addContainerGap()
					.addComponent(textFontCB, GroupLayout.PREFERRED_SIZE, 
							136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, 
							GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnBold)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnItalic)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUnderline)
					.addGap(46)
					.addComponent(textColorCB, 
							GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(363, Short.MAX_VALUE))
		);
		layoutToolsPan.setVerticalGroup(
			layoutToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutToolsPan.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layoutToolsPan.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFontCB, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textColorCB, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBold)
						.addComponent(btnItalic)
						.addComponent(btnUnderline)
						.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		lowerToolsPan.setLayout(layoutToolsPan);
		toolsPan.add(lowerToolsPan);
		add(toolsPan);

		// Template chooser panel
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(Color.WHITE);
		spLayout.putConstraint
		(SpringLayout.EAST, toolsPan, -6, SpringLayout.WEST, tempPanel);
		spLayout.putConstraint
		(SpringLayout.WEST, tempPanel, 826, SpringLayout.WEST, this);
		spLayout.putConstraint
		(SpringLayout.NORTH, tempPanel, 0, SpringLayout.NORTH, this);
		spLayout.putConstraint
		(SpringLayout.SOUTH, tempPanel, 69, SpringLayout.NORTH, this);
		spLayout.putConstraint
		(SpringLayout.EAST, tempPanel, -10, SpringLayout.EAST, this);
		tempPanel.setLayout(new GridLayout(1, 4));
		
		// Setting template buttons
		JButton btnTemp1 = new JButton("Default PL");
		btnTemp1.setToolTipText("Protip! " +
				"This template works in almost all jobs you are searching for.");
		btnTemp1.addActionListener(this);
		btnTemp1.setActionCommand("DefPL");
		tempPanel.add(btnTemp1);
		
		JButton btnTemp2 = new JButton("Default CV");
		btnTemp2.setToolTipText("Protip! " +
				"This template is the default one to write a CV. " +
				"Use this if you are searching for a regular job.");
		btnTemp2.addActionListener(this);
		btnTemp2.setActionCommand("DefCV");
		tempPanel.add(btnTemp2);
		
		JButton btnTemp3 = new JButton("Classy CV");
		btnTemp3.setToolTipText("Protip! " +
				"The Classy CV template is a way to show off " +
				"your experiences for your boss!");
		btnTemp3.addActionListener(this);
		btnTemp3.setActionCommand("ClassyCV");
		tempPanel.add(btnTemp3);
		
		// A list with different templates.
		// Not yet implemented actions
		String[] templateChange = {
				"Advanced PL", 
				"Advanced CV",
		         "Classic PL",
		         "Classic CV",
		         "Modern PL",
		         "Modern CV",
		         "Left Aligned PL",
		         "Left Aligned CV",
		         "Right Aligned PL",
		         "Right Aligned CV",
		         "Quick PL",
		         "Quick CV",
		          };
		
		JComboBox otherTemps = new JComboBox(templateChange);
		otherTemps.setAlignmentX(Component.LEFT_ALIGNMENT);
		otherTemps.setToolTipText("Protip! " +
				"A list of different templates. " +
				"Choose something that fits your future job.");
		otherTemps.setMaximumRowCount(4);
		tempPanel.add(otherTemps);
		add(tempPanel);

		pcs = new PropertyChangeSupport(this);
	}

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
	
	/**
	 * Settles the actions to be performed depeding on 
	 * which component which was the source.
	 * 
	 * @param arg0
	 * 			the source of the events
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		switch(arg0.getActionCommand()){
		case "New":
			int selection = JOptionPane.showConfirmDialog(null,
					"Do you want to save the document first?", null,
					JOptionPane.YES_NO_OPTION);
			if (selection == JOptionPane.YES_OPTION) {
				// Saves the document
				pcs.firePropertyChange(Labels.SAVE_DOC, false, true);
				// Create a new document
				pcs.firePropertyChange(Labels.NEW_DOC, false, true);
			}else if(selection == JOptionPane.CLOSED_OPTION){
				// Cancel
			}else{
				// Create a new document
				pcs.firePropertyChange(Labels.NEW_DOC, false, true); 
			}
		break;
		case "Save":
			pcs.firePropertyChange(Labels.SAVE_DOC, false, true);
			break;
		case "Open":
			pcs.firePropertyChange(Labels.OPEN_DOC, false, true);
			break;
		case "Save As":
			pcs.firePropertyChange(Labels.SAVE_DOC_AS, false, true);
			break;
		case "Export":
			pcs.firePropertyChange(Labels.EXPORT_DOC, false, true);
			break;	
		case "Undo":
			pcs.firePropertyChange(Labels.TEXT_UNDO, false, true);
			break;
		case "Redo":	
			pcs.firePropertyChange(Labels.TEXT_REDO, false, true);
			break;
		case "Select All":
			pcs.firePropertyChange(Labels.TEXT_SELECTALL, false, true);
			break;	
		case "Copy":
			pcs.firePropertyChange(Labels.TEXT_COPY, false, true);
			break;
		case "Paste":
			pcs.firePropertyChange(Labels.TEXT_PASTE, false, true);
			break;
		case "Cut":
			pcs.firePropertyChange(Labels.TEXT_CUT, false, true);
			break;
		case "Font":
			pcs.firePropertyChange(Labels.TEXTFONT_CHANGED, null, 
					textFontCB.getSelectedItem().toString());
			break;
		case "Size":	
			pcs.firePropertyChange(Labels.TEXTSIZE_CHANGED, null, 
					textSizeCB.getSelectedItem().toString());
			break;
		case "Bold":
			pcs.firePropertyChange(Labels.TEXTSTYLE_CHANGED, null, "B");
			break;
		case "Italic":	
			pcs.firePropertyChange(Labels.TEXTSTYLE_CHANGED, null, "I");
			break;
		case "Underline":
			pcs.firePropertyChange(Labels.TEXTSTYLE_CHANGED, null, "U");
			break;
		case "Color":
			pcs.firePropertyChange(Labels.TEXTCOLOUR_CHANGED, null, 
					textColorCB.getSelectedItem().toString());
			break;
		case "DefPL":
			pcs.firePropertyChange(Labels.TEMPLATE_CHANGED, null, Template.DEF_PL);
			break;
		case "DefCV":
			pcs.firePropertyChange(Labels.TEMPLATE_CHANGED, null, Template.DEF_CV);
			break;
		case "ClassyCV":			
			System.out.println("sends event with CLASSY_CV");
			pcs.firePropertyChange(Labels.TEMPLATE_CHANGED, null, Template.CLASSY_CV);
			break;		
			
		default: // Do nothing, never invoked.	
		}
	}
	
	//-----Getters------
	
	public JComboBox getTextSizeCombo(){
		return textSizeCB;
	}	
	public JComboBox getTextFontCombo(){
		return textFontCB;
	}
	public JComboBox getTextColorCombo(){
		return textColorCB;
	}
}
