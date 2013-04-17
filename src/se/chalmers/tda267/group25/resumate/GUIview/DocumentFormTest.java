package se.chalmers.tda267.group25.resumate.GUIview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import se.chalmers.tda367.group25.resumate.views.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocumentFormTest extends JFrame {
	private JPanel documentPane;

	//Create the frame.

	public DocumentFormTest() {
		
		//Setting the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 1000);
		documentPane = new JPanel();
		documentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(documentPane);
		
		
		//Creating components
		JButton btnDefaultCVButton = new JButton("CV");
		JButton btnDefaultPLButton = new JButton("Peronligt Brev");
		JButton btnClassyCVButton = new JButton("Klassiskt");
		DefaultPLPanel defaultPL = new DefaultPLPanel();
		DefaultCVPanel defaultCV = new DefaultCVPanel();
		ClassyCVPanel classyCV = new ClassyCVPanel();
		
		//Position the components on the panel
		SpringLayout pos = new SpringLayout();
		pos.putConstraint(SpringLayout.NORTH, defaultPL, 64, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.WEST, defaultPL, 5, SpringLayout.WEST, documentPane);
		pos.putConstraint(SpringLayout.SOUTH, defaultPL, -5, SpringLayout.SOUTH, documentPane);
		pos.putConstraint(SpringLayout.EAST, defaultPL, 559, SpringLayout.WEST, documentPane);
		//position the buttons
		pos.putConstraint(SpringLayout.NORTH, btnClassyCVButton, 10, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.NORTH, btnDefaultPLButton, 10, SpringLayout.NORTH, documentPane);
		pos.putConstraint(SpringLayout.NORTH, btnDefaultCVButton, 0, SpringLayout.NORTH, btnDefaultPLButton);
		pos.putConstraint(SpringLayout.EAST, btnDefaultCVButton, -6, SpringLayout.WEST, btnDefaultPLButton);
		pos.putConstraint(SpringLayout.EAST, btnDefaultPLButton, -6, SpringLayout.WEST, btnClassyCVButton);
		pos.putConstraint(SpringLayout.EAST, btnClassyCVButton, -25, SpringLayout.EAST, documentPane);
		documentPane.setLayout(pos);
		
		
		//Adding the components to the documentPane
		documentPane.add(btnDefaultCVButton);
		documentPane.add(btnDefaultPLButton);
		documentPane.add(btnClassyCVButton);
		documentPane.add(defaultPL);
		setTitle("ResuMate");
		
		
		//Giving the Default CV Button an ActionListener
		btnDefaultCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//TODO
			}
		});
		//Giving the Default PL Button an ActionListener		
		btnDefaultPLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//TODO
			}
		});
		//Giving the Classy CV Button an ActionListener		
		btnClassyCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//TODO
			}
		});
					
	}
}