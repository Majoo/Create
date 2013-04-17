package se.chalmers.tda367.group25.resumate.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import se.chalmers.tda367.group25.resumate.views.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResumateView extends JFrame {
	private JPanel documentPane;

	//Create the frame.

	public ResumateView() {
		
		//Setting the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 650);
		documentPane = new JPanel();
		documentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(documentPane);
		
		
		//Creating components
		JButton btnDefaultCVButton = new JButton("CV");
		JButton btnDefaultPLButton = new JButton("Personligt Brev");
		JButton btnClassyCVButton = new JButton("Elegant CV");
		final DefaultPLPanel defaultPL = new DefaultPLPanel();
		final DefaultCVPanel defaultCV = new DefaultCVPanel();
		final ClassyCVPanel classyCV = new ClassyCVPanel();
		
		//Position the components on the panel
		SpringLayout pos = new SpringLayout();
		pos.putConstraint(SpringLayout.NORTH, btnDefaultCVButton, 10, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.NORTH, btnDefaultPLButton, 0, SpringLayout.NORTH, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.WEST, btnDefaultPLButton, 6, SpringLayout.EAST, btnClassyCVButton);
		pos.putConstraint(SpringLayout.EAST, btnDefaultCVButton, -233, SpringLayout.EAST, documentPane);
		pos.putConstraint(SpringLayout.NORTH, btnClassyCVButton, 0, SpringLayout.NORTH, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.WEST, btnClassyCVButton, 6, SpringLayout.EAST, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.NORTH, defaultCV, 64, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.WEST, defaultCV, 5, SpringLayout.WEST, documentPane);
		pos.putConstraint(SpringLayout.SOUTH, defaultCV, -5, SpringLayout.SOUTH, documentPane);
		pos.putConstraint(SpringLayout.EAST, defaultCV, 559, SpringLayout.WEST, documentPane);
		
		
		pos.putConstraint(SpringLayout.NORTH, defaultPL, 64, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.WEST, defaultPL, 5, SpringLayout.WEST, documentPane);
		pos.putConstraint(SpringLayout.SOUTH, defaultPL, -5, SpringLayout.SOUTH, documentPane);
		pos.putConstraint(SpringLayout.EAST, defaultPL, 559, SpringLayout.WEST, documentPane);
		
		
		pos.putConstraint(SpringLayout.NORTH, classyCV, 64, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.WEST, classyCV, 5, SpringLayout.WEST, documentPane);
		pos.putConstraint(SpringLayout.SOUTH, classyCV, -5, SpringLayout.SOUTH, documentPane);
		pos.putConstraint(SpringLayout.EAST, classyCV, 559, SpringLayout.WEST, documentPane);
		documentPane.setLayout(pos);
		
		
		//Adding the components to the documentPane
		documentPane.add(btnDefaultCVButton);
		documentPane.add(btnDefaultPLButton);
		documentPane.add(btnClassyCVButton);
		documentPane.add(defaultPL);
		documentPane.add(defaultCV);
		documentPane.add(classyCV);
		setTitle("ResuMate");
		
		
		//Giving the Default CV Button an ActionListener
		btnDefaultCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defaultCV.setVisible(true);
				defaultPL.setVisible(false);
				classyCV.setVisible(false);
				
				
				
			}
		});
		//Giving the Default PL Button an ActionListener		
		btnDefaultPLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//documentPane.add(defaultPL);
				defaultPL.setVisible(true);
				defaultCV.setVisible(false);
				classyCV.setVisible(false);
				
			}
		});
		//Giving the Classy CV Button an ActionListener		
		btnClassyCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//documentPane.add(classyCV);
				classyCV.setVisible(true);
				defaultCV.setVisible(false);
				defaultPL.setVisible(false);
			}
		});
		
		
		
		
		
		
		
		//the menu bar
		setTitle("ResuMate");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		
		//the menubar action events
		//create a new Document
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This will create a new Document");
				
				//TODO
				
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This will exit ResuMate");
				System.exit(1);
			}
		});
					
	}
}