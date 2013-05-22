package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.chalmers.tda367.group25.resumate.utils.Labels;
import java.awt.Component;

public class ToolbarPanel extends JPanel implements ActionListener{
	private PropertyChangeSupport pcs;
	private JComboBox textSizeCB;
	private JComboBox fontCB;
	private JComboBox textColorCB;
	
	/**
	 * Create the panel.
	 */
	public ToolbarPanel() {
		setBorder(new LineBorder(SystemColor.activeCaption));
		setBackground(Color.WHITE);
		SpringLayout spLayout = new SpringLayout();
		setLayout(spLayout);

		//Setting Tools panel
		JPanel toolsPan = new JPanel();
		spLayout.putConstraint(SpringLayout.NORTH, toolsPan, 0, SpringLayout.NORTH, this);
		spLayout.putConstraint(SpringLayout.WEST, toolsPan, 0, SpringLayout.WEST, this);
		spLayout.putConstraint(SpringLayout.SOUTH, toolsPan, 69, SpringLayout.NORTH, this);
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

		JButton btnSend = new JButton("Send");
		btnSend.setToolTipText("Send the document.");
		btnSend.addActionListener(this);
		btnSend.setActionCommand("Send");
		upperToolsPan.add(btnSend);

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
		
		//Lower part tools panel
		JPanel lowerToolsPan = new JPanel();
		lowerToolsPan.setBackground(Color.WHITE);

		// Setting properties for the combobox in which the fonts are listed
		fontCB = new JComboBox();
		fontCB.setToolTipText("Change font.");
		fontCB.addActionListener(this);
		fontCB.setActionCommand("Font");
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String [] fontes = e.getAvailableFontFamilyNames();
		fontCB.setModel(new DefaultComboBoxModel(fontes));

		// Setting properties for the combobox in which the sizes for the text are listed
		textSizeCB = new JComboBox();
		textSizeCB.setToolTipText("Change text size.");
		textSizeCB.addActionListener(this);
		textSizeCB.setActionCommand("Size");
		
		textSizeCB.setModel(new DefaultComboBoxModel(new String[] {"7", "8", "9", "10"
				, "11", "12", "13", "14", "15", "16", "18", "20", "22", "24", "26", "28"
				, "30", "32", "36", "40", "44", "48"}));

		// Setting properties for the button which makes the text bold
		JToggleButton btnBold = new JToggleButton("B");
		btnBold.setToolTipText("Make the selected text bold.");
		btnBold.addActionListener(this);
		btnBold.setActionCommand("Bold");
		btnBold.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Setting properties for the button which make the text italic
		JToggleButton btnItalic = new JToggleButton("I");
		btnItalic.setToolTipText("Make the selected text italics.");
		btnItalic.addActionListener(this);
		btnItalic.setActionCommand("Italic");	
		btnItalic.setFont(new Font("Tahoma", Font.ITALIC, 11));

		// Setting properties for the button which make the text underlined
		JToggleButton btnUnderline = new JToggleButton("U");
		btnUnderline.setToolTipText("Make the selected text underlined.");
		btnUnderline.addActionListener(this);
		btnUnderline.setActionCommand("Underline");	
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		map.put(TextAttribute.UNDERLINE,
				TextAttribute.UNDERLINE_ON);
		btnUnderline.setFont(btnUnderline.getFont().deriveFont(map));
		
		// Setting properties for the button which make the text coloured
		textColorCB = new JComboBox();
		textColorCB.setToolTipText("Select colour.");
		textColorCB.setModel(new DefaultComboBoxModel(new String[] {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green",
				"Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"}));
		textColorCB.addActionListener(this);
		textColorCB.setActionCommand("Color");

		//Setting placement of the GUI
		GroupLayout layoutToolsPan = new GroupLayout(lowerToolsPan);
		layoutToolsPan.setHorizontalGroup(
			layoutToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutToolsPan.createSequentialGroup()
					.addContainerGap()
					.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnBold)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnItalic)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUnderline)
					.addGap(46)
					.addComponent(textColorCB, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(363, Short.MAX_VALUE))
		);
		layoutToolsPan.setVerticalGroup(
			layoutToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutToolsPan.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layoutToolsPan.createParallelGroup(Alignment.BASELINE)
						.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textColorCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBold)
						.addComponent(btnItalic)
						.addComponent(btnUnderline)
						.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		lowerToolsPan.setLayout(layoutToolsPan);
		toolsPan.add(lowerToolsPan);
		add(toolsPan);

		//Template chooser panel
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(Color.WHITE);
		spLayout.putConstraint(SpringLayout.EAST, toolsPan, -6, SpringLayout.WEST, tempPanel);
		spLayout.putConstraint(SpringLayout.WEST, tempPanel, 826, SpringLayout.WEST, this);
		spLayout.putConstraint(SpringLayout.NORTH, tempPanel, 0, SpringLayout.NORTH, this);
		spLayout.putConstraint(SpringLayout.SOUTH, tempPanel, 69, SpringLayout.NORTH, this);
		spLayout.putConstraint(SpringLayout.EAST, tempPanel, -10, SpringLayout.EAST, this);

		//Setting template buttons
		tempPanel.setLayout(new GridLayout(1, 4));
		JButton temp1But = new JButton("Default PL");
		temp1But.setToolTipText("View in a default Personal Letter format.");
		temp1But.addActionListener(this);
		temp1But.setActionCommand("DefPL");
		tempPanel.add(temp1But);
		
		JButton temp2But = new JButton("Default CV");
		temp2But.setToolTipText("View in a default CV format.");
		temp2But.addActionListener(this);
		temp2But.setActionCommand("DefPL");
		tempPanel.add(temp2But);
		JButton temp3But = new JButton("Classy CV");
		temp3But.setToolTipText("View in a classy CV format.");
		temp3But.addActionListener(this);
		temp3But.setActionCommand("DefPL");
		tempPanel.add(temp3But);
		
		//A list with different templates.
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
		otherTemps.setToolTipText("Select other templates.");
		otherTemps.setMaximumRowCount(4);
		tempPanel.add(otherTemps);
		add(tempPanel);

		//PropertyChangeSupport, Listeners and other important stuff.
		pcs = new PropertyChangeSupport(this);
	}

	/**
	 * Add a PropertyChangeListener given as a parameter.
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 * Remove the PropertyChangeListener given as a parameter.
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}
	
	/**
	 * Settles the actions to be performed depeding on 
	 * which component which was the source.
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		switch(arg0.getActionCommand()){
		case "New":
			int selection = JOptionPane.showConfirmDialog(null,
					"Do you want to save the document first?", null,
					JOptionPane.YES_NO_OPTION);
			if (selection == JOptionPane.YES_OPTION) {
				pcs.firePropertyChange(Labels.SAVE_DOC, false, true);	//Save Doc
				pcs.firePropertyChange(Labels.NEW_DOC, false, true);	//New Doc
			}else if(selection == JOptionPane.CLOSED_OPTION){
				//Do nothing
			}else{
				pcs.firePropertyChange(Labels.NEW_DOC, false, true); 
				//tabbedpane.addTab("Tab 2", null, docView, "unsaved");
			}
		break;
		case "Save":
			
			pcs.firePropertyChange(Labels.SAVE_DOC, false, true);
			
			/* String currentFileDirectory = "";
			if("".equals(currentFileDirectory)){					//if the current file is a new one (untitled)
				JFileChooser sdChooser = new JFileChooser();		//file chooser
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Resumate File", "rsmt");
				sdChooser.setFileFilter(filter);
				int returnVal = sdChooser.showSaveDialog(null);
				
				try{
					if(returnVal == JFileChooser.APPROVE_OPTION){
						File directory = sdChooser.getCurrentDirectory();
						String path = directory.getAbsolutePath();					//the absolute path of the directory, named "path"
						String fileName = sdChooser.getSelectedFile().getName();	//get the file name
						if(!fileName.contains("rsmt")){								//if the file name doesn't contain rsmt,
							fileName = fileName + ".rsmt";							//name it a new name with .rsmt at the end
						}
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "\\" + fileName), "UTF-8"));
						currentFileDirectory = path + "\\" + fileName;				//the current file directory is now "theabsolutepath\\filename.rsmt"
						//bw.write(THE_NAME_OF_THE_EDITORPANE_THAT_SHOULD_BE_OVERWRITTEN.getText());					//get the document text and write it over
						bw.close();
					}
					
				}catch(IOException err){
					JOptionPane.showMessageDialog(null,  "ERROR!");
				}
			
			}else{
				
				try{
					//if it is not empty, we'll save it into the current directory
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentFileDirectory), "UTF-8"));
					//bw.write(THE_NAME_OF_THE_EDITORPANE_THAT_SHOULD_BE_OVERWRITTEN.getText());
					bw.close();
					
				}catch(IOException err){
					JOptionPane.showMessageDialog(null,  "ERROR!");
				}	
			}*/
			break;
		case "Open":
			pcs.firePropertyChange(Labels.OPEN_DOC, false, true);
			break;
		case "Save As":
			pcs.firePropertyChange(Labels.SAVE_DOC_AS, false, true);
			break;
		case "Send":
			pcs.firePropertyChange(Labels.SEND_DOC, false, true);
			break;	
		case "Undo":
			pcs.firePropertyChange(Labels.UNDO_TEXT, false, true);
			break;
		case "Redo":	
			pcs.firePropertyChange(Labels.REDO_TEXT, false, true);
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
			pcs.firePropertyChange(Labels.TEXTFONT_CHANGED, null, fontCB.getSelectedItem().toString());
			break;
		case "Size":	
			pcs.firePropertyChange(Labels.TEXTSIZE_CHANGED, null, textSizeCB.getSelectedItem().toString());
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
			pcs.firePropertyChange(Labels.TEXTCOLOUR_CHANGED, null, textColorCB.getSelectedItem().toString());
			break;
		case "DefPL":
			//pcs.firePropertyChange(Labels.TEMPLATE_CHANGED, null, Template.DEF_PL);
			break;
		default: //do nothing, never invoked.	
		}
	}
}
