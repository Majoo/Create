package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.chalmers.tda367.group25.resumate.utils.Labels;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class MenuBar extends JMenuBar {

	//private JTextArea aboutmeTextArea;
	private String clipBoardData = "";
	private String currentFileDirectory = "";
	private JTextArea informationTextArea;

	private PropertyChangeSupport pcs;

	public MenuBar(){
		//The PropertyChangeSupport
		pcs = new PropertyChangeSupport(this);		
		
		//L&F
		setLookAndFeel();
		
		//the file
		JMenu mnFile = new JMenu("File");
		add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setMnemonic('n');
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
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
		mntmOpen.setMnemonic('o');
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic('s');
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.setMnemonic('a');
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic('e');
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
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
		mntmCut.setMnemonic('U');
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setMnemonic('o');
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setMnemonic('p');
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);

		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.setMnemonic('S');
		mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnEdit.add(mntmSelectAll);
		
		JSeparator separator = new JSeparator();
		mnEdit.add(separator);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mntmFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmFind.setMnemonic('F');
		mntmFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = JOptionPane.showInputDialog(null, null,
						"Find text", 2);
				pcs.firePropertyChange(Labels.FIND_TEXT, null, text);
			}
		});
		mnEdit.add(mntmFind);
		
		JMenuItem mntmReplace = new JMenuItem("Replace");
		mntmReplace.setMnemonic('R');
		mntmReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String replaceThis = null;
				String replaceWith = null;
				
				boolean replaceWithNeedsInput = true;
				boolean replaceNeedsInput = true;
				while(replaceNeedsInput){
					replaceThis = JOptionPane.showInputDialog(null, null,
							"Replace text", 2);
					if(replaceThis.isEmpty()){
						JOptionPane.showMessageDialog(null,"Please enter a word to replace");
					} else {
						replaceNeedsInput = false;
						while(replaceWithNeedsInput){
							replaceWith = JOptionPane.showInputDialog(null, null,
							"Replace " + replaceThis + " with:", 2);
							if (replaceWith.isEmpty()){
								JOptionPane.showMessageDialog(null,"Please enter a word to replace with");
							} else {
								replaceWithNeedsInput = false;
								pcs.firePropertyChange(Labels.TEXT_REPLACED, null, replaceThis + "/" + replaceWith);
							}
						}
					}
				}
			}
		});
		mnEdit.add(mntmReplace);


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
			    	String path = chooser.getSelectedFile().getPath();
			    	System.out.println("You chose to open this file: " +
			    			path);
			    	//send the path of the image to mainView
			    	pcs.firePropertyChange(Labels.INSERT_IMAGE, path, false);
			    }
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
	
	/*
	 * Set look and feel
	 */
	private void setLookAndFeel() {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			System.out.println("Couldn't set look and feel in MenuBar");
		}
	}

	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}


}
