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

public class ToolbarPanel extends JPanel implements ActionListener{
	private PropertyChangeSupport pcs;
	private JComboBox textSizeCB;
	private JComboBox fontCB;

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
		btnNewDoc.addActionListener(this);
		btnNewDoc.setActionCommand("New");
		upperToolsPan.add(btnNewDoc);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(this);
		btnOpen.setActionCommand("Open");
		upperToolsPan.add(btnOpen);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		btnSave.setActionCommand("Save");
		upperToolsPan.add(btnSave);

		JButton btnSend = new JButton("Send");
		btnSend.setActionCommand("Send");
		upperToolsPan.add(btnSend);

		JButton btnPrint = new JButton("Print");
		btnPrint.setActionCommand("Print");
		upperToolsPan.add(btnPrint);

		JButton btnCut = new JButton("Cut");
		btnPrint.setActionCommand("Cut");
		upperToolsPan.add(btnCut);

		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(this);
		btnCopy.setActionCommand("Copy");
		upperToolsPan.add(btnCopy);

		JButton btnPaste = new JButton("Paste");
		btnPaste.addActionListener(this);
		btnPaste.setActionCommand("Paste");
		upperToolsPan.add(btnPaste);

		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(this);
		btnRedo.setActionCommand("Redo");
		upperToolsPan.add(btnRedo);

		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(this);
		btnUndo.setActionCommand("Undo");
		upperToolsPan.add(btnUndo);
		
		//Lower part tools panel
		JPanel lowerToolsPan = new JPanel();
		lowerToolsPan.setBackground(Color.WHITE);

		// Setting properties for the combobox in which the fonts are listed
		fontCB = new JComboBox();
		fontCB.addActionListener(this);
		fontCB.setActionCommand("Font");
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String [] fontes = e.getAvailableFontFamilyNames();
		fontCB.setModel(new DefaultComboBoxModel(fontes));

		// Setting properties for the combobox in which the sizes for the text are listed
		textSizeCB = new JComboBox();
		textSizeCB.addActionListener(this);
		textSizeCB.setActionCommand("Size");
		
		textSizeCB.setModel(new DefaultComboBoxModel(new String[] {"7", "8", "9", "10"
				, "11", "12", "13", "14", "15", "16", "18", "20", "22", "24", "26", "28"
				, "30", "32", "36", "40", "44", "48", "52", "56", "60"}));

		// Setting properties for the button which makes the text bold
		JToggleButton tglbtnBold = new JToggleButton("B");
		tglbtnBold.addActionListener(this);
		tglbtnBold.setActionCommand("Bold");
		tglbtnBold.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Setting properties for the button which make the text italic
		JToggleButton tglbtnItalic = new JToggleButton("I");
		tglbtnItalic.addActionListener(this);
		tglbtnItalic.setActionCommand("Italic");	
		tglbtnItalic.setFont(new Font("Tahoma", Font.ITALIC, 11));

		// Setting properties for the button which make the text underlined
		JToggleButton tglbtnUnderline = new JToggleButton("U");
		tglbtnUnderline.addActionListener(this);
		tglbtnUnderline.setActionCommand("Underline");	
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		map.put(TextAttribute.UNDERLINE,
				TextAttribute.UNDERLINE_ON);
		tglbtnUnderline.setFont(tglbtnUnderline.getFont().deriveFont(map));
		
		// Setting properties for the button which make the text coloured
		JComboBox textColorCB = new JComboBox();
		textColorCB.setModel(new DefaultComboBoxModel(new String[] {"color"}));
		textColorCB.setForeground(Color.RED);

		//Setting placement of the GUI
		GroupLayout gl_lowerToolsPan = new GroupLayout(lowerToolsPan);
		gl_lowerToolsPan.setHorizontalGroup(
			gl_lowerToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lowerToolsPan.createSequentialGroup()
					.addContainerGap()
					.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(tglbtnBold)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnItalic)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnUnderline)
					.addGap(46)
					.addComponent(textColorCB, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_lowerToolsPan.setVerticalGroup(
			gl_lowerToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lowerToolsPan.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_lowerToolsPan.createParallelGroup(Alignment.BASELINE)
						.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textColorCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnBold)
						.addComponent(tglbtnItalic)
						.addComponent(tglbtnUnderline)
						.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		lowerToolsPan.setLayout(gl_lowerToolsPan);
		toolsPan.add(lowerToolsPan);
		add(toolsPan);

		//Template chooser panel
		JPanel tempsPan = new JPanel();
		tempsPan.setBackground(Color.WHITE);
		spLayout.putConstraint(SpringLayout.EAST, toolsPan, -6, SpringLayout.WEST, tempsPan);
		spLayout.putConstraint(SpringLayout.WEST, tempsPan, 826, SpringLayout.WEST, this);
		spLayout.putConstraint(SpringLayout.NORTH, tempsPan, 0, SpringLayout.NORTH, this);
		spLayout.putConstraint(SpringLayout.SOUTH, tempsPan, 69, SpringLayout.NORTH, this);
		spLayout.putConstraint(SpringLayout.EAST, tempsPan, -10, SpringLayout.EAST, this);

		//Setting template buttons
		tempsPan.setLayout(new GridLayout(1, 4));
		JButton temp1But = new JButton("Default PL");
		temp1But.addActionListener(this);
		temp1But.setActionCommand("DefPL");
		tempsPan.add(temp1But);
		
		JButton temp2But = new JButton("temp2");
		tempsPan.add(temp2But);
		JButton temp3But = new JButton("temp3");
		tempsPan.add(temp3But);
		JComboBox otherTemps = new JComboBox();
		tempsPan.add(otherTemps);
		add(tempsPan);

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
		case "Copy":
			pcs.firePropertyChange(Labels.TEXT_COPY, false, true);
			break;
		case "Paste":
			pcs.firePropertyChange(Labels.TEXT_PASTE, false, true);
			break;
		case "Undo":
			pcs.firePropertyChange(Labels.UNDO_ACTION, false, true);
			break;
		case "Redo":	
			pcs.firePropertyChange(Labels.REDO_ACTION, false, true);
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
		case "Open":
			JOptionPane.showMessageDialog(null, "this should open a doc");
			break;
		case "New":
		/*	int selection = JOptionPane.showConfirmDialog(null,
					"Do you want to save the document first?", null,
					JOptionPane.YES_NO_OPTION);
			if (selection == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Open an explorer to save an .rsmt-file HERE"); //implementera Save här
				//Toolkit.getDefaultToolkit().beep();
				//tabbedpane.addTab("Tab 2", null, docView, "unsaved");
			}else if(selection == JOptionPane.CLOSED_OPTION){
				//Do nothing
			}else{
				//tabbedpane.addTab("Tab 2", null, docView, "unsaved");
			}*/
		break;
		case "Save":
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
		case "DefPL":
			//pcs.firePropertyChange(Labels.TEMPLATE_CHANGED, null, Template.DEF_PL);
			break;
		default: //do nothing, never invoked.	
		}
	}
}
