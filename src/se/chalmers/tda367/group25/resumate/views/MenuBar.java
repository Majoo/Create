package se.chalmers.tda367.group25.resumate.views;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.chalmers.tda367.group25.resumate.utils.Labels;
import javax.swing.JCheckBoxMenuItem;

/**
 * A Menu bar top of the document 
 * with clickable items (actions)
 * @author Danny
 */
public class MenuBar extends JMenuBar implements ActionListener {
	private PropertyChangeSupport pcs;
	private String curDirectoryPath;

	/**
	 * Create the menubar with clickable items.
	 */
	public MenuBar() {
		pcs = new PropertyChangeSupport(this);
		setLookAndFeel();

		// Adding menu items and setting properties located in the File Menu
		JMenu mnFile = new JMenu("File");
		add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setMnemonic('n');
		mntmNew.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNew.addActionListener(this);
		mntmNew.setActionCommand("New");
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setMnemonic('o');
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.addActionListener(this);
		mntmOpen.setActionCommand("Open");
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic('s');
		mntmSave.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.addActionListener(this);
		mntmSave.setActionCommand("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmSaveAs.setMnemonic('a');
		mntmSaveAs.addActionListener(this);
		mntmSaveAs.setActionCommand("SaveAs");
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExportAsPdf = new JMenuItem("Export As PDF");
		mntmExportAsPdf.setMnemonic('E');
		mntmExportAsPdf.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmExportAsPdf.addActionListener(this);
		mntmExportAsPdf.setActionCommand("Export");
		mnFile.add(mntmExportAsPdf);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic('e');
		mntmExit.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmExit.addActionListener(this);
		mntmExit.setActionCommand("Exit");
		mnFile.add(mntmExit);

		// Adding menu items and setting properties located in the Edit Menu
		JMenu mnEdit = new JMenu("Edit");
		add(mnEdit);

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setMnemonic('Z');
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmUndo.addActionListener(this);
		mntmUndo.setActionCommand("Undo");
		mnEdit.add(mntmUndo);

		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.setMnemonic('Y');
		mntmRedo.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mntmRedo.addActionListener(this);
		mntmRedo.setActionCommand("Redo");
		mnEdit.add(mntmRedo);

		JSeparator separator1 = new JSeparator();
		mnEdit.add(separator1);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setMnemonic('U');
		mntmCut.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mntmCut.addActionListener(this);
		mntmCut.setActionCommand("Cut");
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setMnemonic('o');
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmCopy.addActionListener(this);
		mntmCopy.setActionCommand("Copy");
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setMnemonic('p');
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmPaste.addActionListener(this);
		mntmPaste.setActionCommand("Paste");
		mnEdit.add(mntmPaste);

		JMenuItem mntmSA = new JMenuItem("SelectAll");
		mntmSA.setMnemonic('S');
		mntmSA.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmSA.addActionListener(this);
		mntmSA.setActionCommand("SelectAll");
		mnEdit.add(mntmSA);

		JSeparator separator = new JSeparator();
		mnEdit.add(separator);

		JMenuItem mntmFind = new JMenuItem("Find");
		mntmFind.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmFind.setMnemonic('F');
		mntmFind.addActionListener(this);
		mntmFind.setActionCommand("Find");
		mnEdit.add(mntmFind);

		JMenuItem mntmReplace = new JMenuItem("Replace");
		mntmReplace.setMnemonic('R');
		mntmReplace.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmReplace.addActionListener(this);
		mntmReplace.setActionCommand("Replace");
		mnEdit.add(mntmReplace);

		JMenuItem mntmReplaceAll = new JMenuItem("Replace All");
		mntmReplaceAll.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmReplaceAll.setMnemonic('A');
		mntmReplaceAll.addActionListener(this);
		mntmReplaceAll.setActionCommand("ReplaceAll");
		mnEdit.add(mntmReplaceAll);

		// Adding menu items and setting properties located in the Format Menu
		JMenu mnFormat = new JMenu("Format");
		add(mnFormat);

		JMenuItem mntmBold = new JMenuItem("Bold");
		mntmBold.setMnemonic('B');
		mntmBold.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmBold.addActionListener(this);
		mntmBold.setActionCommand("Bold");
		mnFormat.add(mntmBold);

		JMenuItem mntmItalic = new JMenuItem("Italic");
		mntmItalic.setMnemonic('I');
		mntmItalic.setAccelerator
		(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmItalic.addActionListener(this);
		mntmItalic.setActionCommand("Italic");
		mnFormat.add(mntmItalic);

		JMenuItem mntmUnderline = new JMenuItem("Underline");
		mntmUnderline.setMnemonic('U');
		mntmUnderline.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		mntmUnderline.setActionCommand("Underline");
		mntmUnderline.addActionListener(this);
		mnFormat.add(mntmUnderline);

		// Adding menu items and setting properties located in the Image Menu
		JMenu mnImage = new JMenu("Image");
		add(mnImage);

		JMenuItem uploadImage = new JMenuItem("Upload");
		uploadImage.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_I, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		uploadImage.addActionListener(this);
		uploadImage.setActionCommand("Upload");
		mnImage.add(uploadImage);

		JMenuItem grayscaleImage = new JMenuItem("Grayscale");
		grayscaleImage.setMnemonic('G');
		grayscaleImage.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		grayscaleImage.addActionListener(this);
		grayscaleImage.setActionCommand("Grayscale");
		mnImage.add(grayscaleImage);

		JMenuItem resetImage = new JMenuItem("Reset");
		resetImage.setMnemonic('R');
		resetImage.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_R, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		resetImage.addActionListener(this);

		resetImage.setActionCommand("Reset image");
		mnImage.add(resetImage);

		// Adding menu items and setting properties located in the Show Menu
		JMenu mnShow = new JMenu("Show");
		add(mnShow);

		// Adding menu items and setting properties located in the Help Menu
		JMenu mnHelp = new JMenu("Help");
		add(mnHelp);

		// Adding menu items and setting properties located in the About Menu
		JMenu mnAbout = new JMenu("About");
		add(mnAbout);
	}

	// Setters
	/*
	 * Set the directory in which to open the next JFileChooser.
	 */
	private void setCurrentDirectoryPath(String newCurDirectoryPath) {
		this.curDirectoryPath = newCurDirectoryPath;
		
	}
	
	/**
	 * Set look and feel
	 */
	private void setLookAndFeel() {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Couldn't set look and feel in MenuBar");
		}
	}

	// PROPERTY-CHANGE-METHODS
	/**
	 * Add a PropertyChangeListener given as a parameter.
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 * Remove the PropertyChangeListener given as a parameter.
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}

	/**
	 * Settles the actions to be performed depeding on which component which was
	 * the source.
	 */
	public void actionPerformed(ActionEvent arg0) {

		switch (arg0.getActionCommand()) {
		case "New":
			int selection = JOptionPane.showConfirmDialog(null,
					"Do you want to save the document first?", null,
					JOptionPane.YES_NO_OPTION);
			if (selection == JOptionPane.YES_OPTION) {
				pcs.firePropertyChange(Labels.SAVE_DOC, false, true); // Save
																		// Doc
				pcs.firePropertyChange(Labels.NEW_DOC, false, true); // New Doc
			} else if (selection == JOptionPane.CLOSED_OPTION) {
				// Do nothing
			} else {
				pcs.firePropertyChange(Labels.NEW_DOC, false, true);
				// tabbedpane.addTab("Tab 2", null, docView, "unsaved");
			}
			break;
			
		case "Save":
			pcs.firePropertyChange(Labels.SAVE_DOC, true, false);
			break;

		case "SaveAs":
			pcs.firePropertyChange(Labels.SAVE_DOC_AS, true, false);
			break;

		case "Open":
			pcs.firePropertyChange(Labels.OPEN_DOC, true, false);
			break;
			
		case "Exit":
			selection = JOptionPane.showConfirmDialog(null,
					"Do you want to save the document first?", null,
					JOptionPane.YES_NO_OPTION);
			if (selection == JOptionPane.YES_OPTION) {
				pcs.firePropertyChange(Labels.SAVE_DOC, false, true); 
																		
				System.exit(0);
			} else if (selection == JOptionPane.CLOSED_OPTION) {
				// Do nothing
			} else {
				System.exit(0);
			}
		case "Export":
			pcs.firePropertyChange(Labels.EXPORT_DOC, false, true);
			break;
			
		case "Undo":
			pcs.firePropertyChange(Labels.TEXT_UNDO, false, true);
			break;
			
		case "Redo":
			pcs.firePropertyChange(Labels.TEXT_REDO, false, true);
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
			
		case "SelectAll":
			pcs.firePropertyChange(Labels.TEXT_SELECTALL, false, true);
			break;

		case "Find":
			String text = JOptionPane.showInputDialog
			(null, null, "Find text", 2);
			pcs.firePropertyChange(Labels.FIND_TEXT, null, text);
			break;

		case "Replace":
			String replaceThis = null;
			String replaceWith = null;

			boolean replaceWithNeedsInput = true;
			boolean replaceNeedsInput = true;
			while (replaceNeedsInput) {
				replaceThis = JOptionPane.showInputDialog
						(null, null, "Replace text", 2);
				if (replaceThis.isEmpty()) {
					JOptionPane.showMessageDialog
					(null, "Please enter a word to replace");
				} else {
					replaceNeedsInput = false;
					while (replaceWithNeedsInput) {
						replaceWith = JOptionPane.showInputDialog
								(null, null, "Replace " + replaceThis + " with:", 2);
						if (replaceWith.isEmpty()) {
							JOptionPane.showMessageDialog
							(null, "Please enter a word to replace with");
						} else {
							replaceWithNeedsInput = false;
							pcs.firePropertyChange(Labels.TEXT_REPLACED, 
									null, replaceThis + "/" + replaceWith);
						}
					}
				}
			}
			break;

		case "ReplaceAll":
			String replaceThiis = null;
			String replaceWiith = null;

			boolean replaceWithNeedsInputA = true;
			boolean replaceNeedsInputA = true;
			while (replaceNeedsInputA) {
				replaceThiis = JOptionPane.showInputDialog
						(null, null, "Replace all text", 2);
				if (replaceThiis.isEmpty()) {
					JOptionPane.showMessageDialog
					(null, "Please enter a word to replace");
				} else {
					replaceNeedsInputA = false;
					while (replaceWithNeedsInputA) {
						replaceWiith = JOptionPane.showInputDialog(null, null,
								"Replace all " + replaceThiis + " with:", 2);
						if (replaceWiith.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Please enter a word to replace with");
						} else {
							replaceWithNeedsInputA = false;
							pcs.firePropertyChange(Labels.REPLACE_ALL_TEXT,
									null, replaceThiis + "/" + replaceWiith);
						}
					}
				}
			}
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

		/* Image related: */
		case "Upload":
			JFileChooser chooser;
			if(this.curDirectoryPath == null){
				chooser = new JFileChooser();
			}else{
				chooser = new JFileChooser(this.curDirectoryPath);
			}
			// Let the user choose an image
			FileNameExtensionFilter filter = new FileNameExtensionFilter
					("JPG, PNG & GIF Images", "jpg", "gif", "png", "jpeg");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String path = chooser.getSelectedFile().getPath();
				//Set the new lastOpenedDirectoryPath
				setCurrentDirectoryPath(path);
				//Fire PropertyChangEvent
				System.out.println("You chose to open this file: " + path);
				pcs.firePropertyChange(Labels.INSERT_IMAGE, path, false);
			}
			break;

		case "Grayscale":
			pcs.firePropertyChange(Labels.GRAYSCALE_IMAGE, true, false);
			break;

		case "Reset image":
			pcs.firePropertyChange(Labels.RESET_IMAGE, true, false);
			break;

		default: // Do nothing, never invoked
			break;
		}

	}

}
