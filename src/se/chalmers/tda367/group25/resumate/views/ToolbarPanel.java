package se.chalmers.tda367.group25.resumate.views;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JToggleButton;

import se.chalmers.tda367.group25.resumate.utils.Labels;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class ToolbarPanel extends JPanel{
	private PropertyChangeSupport pcs;


	private String currentFileDirectory = "";
	private JButton temp1But, temp2But, temp3But;
	private JComboBox otherTemps;
	private JComboBox textSizeCB;
	private JPanel lowerToolsPan;

	/**
	 * Create the panel.
	 */
	public ToolbarPanel() {
		setBorder(new LineBorder(SystemColor.activeCaption));
		setBackground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		//Tools panel
		JPanel toolsPan = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, toolsPan, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, toolsPan, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, toolsPan, 69, SpringLayout.NORTH, this);

		toolsPan.setLayout(new GridLayout(2,1));
		//Upper part tools panel
		JPanel upperToolsPan = new JPanel();
		upperToolsPan.setBackground(Color.WHITE);
		upperToolsPan.setLayout(new GridLayout(1,10));
		toolsPan.add(upperToolsPan);

		JButton btnNewDoc = new JButton("New");
		upperToolsPan.add(btnNewDoc);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "this should open a doc");
			}
		});
		upperToolsPan.add(btnOpen);

		JButton btnSave = new JButton("Save");
		/*btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				}
			}
				
		});*/
		upperToolsPan.add(btnSave);

		JButton btnSend = new JButton("Send");
		upperToolsPan.add(btnSend);

		JButton btnPrint = new JButton("Print");
		upperToolsPan.add(btnPrint);

		JButton btnCut = new JButton("Cut");
		upperToolsPan.add(btnCut);

		JButton btnCopy = new JButton("Copy");
		upperToolsPan.add(btnCopy);

		JButton btnPaste = new JButton("Paste");
		upperToolsPan.add(btnPaste);

		JButton btnForward = new JButton("Forward");
		upperToolsPan.add(btnForward);

		JButton btnBackward = new JButton("Backward");
		upperToolsPan.add(btnBackward);
		//Lower part tools panel
		lowerToolsPan = new JPanel();
		lowerToolsPan.setBackground(Color.WHITE);

		JComboBox fontCB = new JComboBox();
		fontCB.setModel(new DefaultComboBoxModel(new String[] {"Fonts"}));

		textSizeCB = new JComboBox();
		textSizeCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pcs.firePropertyChange(Labels.TEXTSIZE_CHANGED, textSizeCB, textSizeCB.getSelectedItem().toString());
			}
		});
		textSizeCB.setModel(new DefaultComboBoxModel(new String[] {"7", "8", "9", "10"
				, "11", "12", "13", "14", "15", "16", "18", "20", "22", "24", "26", "28"
				, "30", "32", "36", "40", "44", "48", "52", "56", "60"}));

		JToggleButton tglbtnBold = new JToggleButton("B");
		tglbtnBold.setFont(new Font("Tahoma", Font.BOLD, 11));

		JToggleButton tglbtnItalic = new JToggleButton("I");
		tglbtnItalic.setFont(new Font("Tahoma", Font.ITALIC, 11));

		JToggleButton tglbtnUnderline = new JToggleButton("U");
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		map.put(TextAttribute.UNDERLINE,
				TextAttribute.UNDERLINE_ON);
		tglbtnUnderline.setFont(tglbtnUnderline.getFont().deriveFont(map));
		
		JComboBox textColorCB = new JComboBox();
		textColorCB.setModel(new DefaultComboBoxModel(new String[] {"color"}));
		textColorCB.setForeground(Color.RED);

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
		springLayout.putConstraint(SpringLayout.EAST, toolsPan, -6, SpringLayout.WEST, tempsPan);
		springLayout.putConstraint(SpringLayout.WEST, tempsPan, 826, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, tempsPan, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tempsPan, 69, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, tempsPan, -10, SpringLayout.EAST, this);

		tempsPan.setLayout(new GridLayout(1, 4));
		temp1But = new JButton("temp1");
		tempsPan.add(temp1But);
		temp2But = new JButton("temp2");
		tempsPan.add(temp2But);
		temp3But = new JButton("temp3");
		tempsPan.add(temp3But);
		otherTemps = new JComboBox();
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
}
