package se.chalmers.tda367.group25.resumate.views;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.chalmers.tda367.group25.resumate.utils.Labels;

public class MenuBar extends JMenuBar {

	//private JTextArea aboutmeTextArea;
	private String clipBoardData = "";
	private String currentFileDirectory = "";
	private JTextArea informationTextArea;

	private PropertyChangeSupport pcs;

	public MenuBar(){

	pcs = new PropertyChangeSupport(this);	
		
		//the file
		JMenu mnFile = new JMenu("File");
		add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selection = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to create a new document?", null,
						JOptionPane.YES_NO_OPTION);
				if (selection == JOptionPane.YES_OPTION) {
					//DannyForm textEditor = new DannyForm();
					//textEditor.setLocationRelativeTo(null);
					//textEditor.setVisible(true);
					//currentFileDirectory = "";			//a new file gets renamed to nothing
					JOptionPane.showMessageDialog(null, "implement something that creates a new doc");
				}
			}
		});
		mnFile.add(mntmNew);

		//open document
		JMenuItem mntmOpen = new JMenuItem("Open");
		
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = JOptionPane.showConfirmDialog(null,
						"Do you want to save the document first?", null,
						JOptionPane.YES_NO_OPTION);
				if (selection == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Open an explorer to save an .rsmt-file HERE"); //implementera Save här
					System.exit(1);
				}else if(selection == JOptionPane.CLOSED_OPTION){
					;
				}else{
					System.exit(1);
				}
			}
		});
		mnFile.add(mntmExit);


		//the edit
		JMenu mnEdit = new JMenu("Edit");
		add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");

		mnEdit.add(mntmPaste);

		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mnEdit.add(mntmSelectAll);


		//the format
		JMenu mnFormat = new JMenu("Format");
		add(mnFormat);

		JMenuItem mntmSomething1 = new JMenuItem("Something");
		mnFormat.add(mntmSomething1);

		//the insert
		JMenu mnInsert = new JMenu("Insert");
		add(mnInsert);
		
		JMenuItem uploadImage = new JMenuItem("Image");
		uploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Let the user choose an image to upload
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			    }
				pcs.firePropertyChange(Labels.INSERT_IMAGE, chooser.getSelectedFile().getName(), false);
			}
		});
		mnInsert.add(uploadImage);

		//the show
		JMenu mnShow = new JMenu("Show");
		add(mnShow);

		//the help
		JMenu mnHelp = new JMenu("Help");
		add(mnHelp);

		//the about
		JMenu mnAbout = new JMenu("About");
		add(mnAbout);

	}
	
	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}


}
