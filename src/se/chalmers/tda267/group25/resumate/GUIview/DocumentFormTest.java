package se.chalmers.tda267.group25.resumate.GUIview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocumentFormTest extends JFrame {
	private JPanel documentPane;

	//Create the frame.

	public DocumentFormTest() {
		
		//Setting the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		documentPane = new JPanel();
		documentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(documentPane);
		
		
		//Creating a new button
		JButton btnDefaultCVButton = new JButton("CV");
		JButton btnDefaultPLButton = new JButton("Peronligt Brev");
		JButton btnClassyCVButton = new JButton("Klassiskt");
		
		//Position the buttons with SpringLayout
		SpringLayout pos = new SpringLayout();
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