package se.chalmers.tda367.group25.resumate.experiment;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import GUI.Form;

public class DannyForm extends JFrame {

	private JTextArea informationTextArea;
	//private JTextArea aboutmeTextArea;
	private String clipBoardData = "";
	private String currentFileDirectory = "";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DannyForm frame = new DannyForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DannyForm() {
		setTitle("Text Editor by Lam(m)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		
		//create menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//the file
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		//new code
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		//open code
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		//saving code
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		//save as code
		mnFile.add(mntmSaveAs);
		
		
		//the edit
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//copy
				clipBoardData = informationTextArea.getSelectedText();
				StringSelection stringSelection = new StringSelection(clipBoardData);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				//delete
				informationTextArea.replaceSelection("");
			}
		});
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clipBoardData = informationTextArea.getSelectedText();
				StringSelection stringSelection = new StringSelection(clipBoardData);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informationTextArea.append(clipBoardData);
			}
		});
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informationTextArea.selectAll();
			}
		});
		mnEdit.add(mntmSelectAll);
		
		
		
		//add content
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		informationTextArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, informationTextArea, 16, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, informationTextArea, 31, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, informationTextArea, 226, SpringLayout.WEST, contentPane);
		contentPane.add(informationTextArea);
		
		JTextArea aboutmeTextArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, informationTextArea, -134, SpringLayout.NORTH, aboutmeTextArea);
		sl_contentPane.putConstraint(SpringLayout.WEST, aboutmeTextArea, 17, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, aboutmeTextArea, -15, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, aboutmeTextArea, 243, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, aboutmeTextArea, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(aboutmeTextArea);
	}
}
