package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class DocumentPanel extends JPanel{

	public DocumentPanel(){
	
	//Creating components
	JButton btnDefaultCVButton = new JButton("CV");
	JButton btnDefaultPLButton = new JButton("Personligt Brev");
	JButton btnClassyCVButton = new JButton("Elegant CV");
	//JPanel documentPane = new JPanel();
	this.setBorder(new EmptyBorder(5, 5, 5, 5));
	final DefaultPLPanel defaultPL = new DefaultPLPanel();
	final DefaultCVPanel defaultCV = new DefaultCVPanel();
	final ClassyCVPanel classyCV = new ClassyCVPanel();
	
	//Position the components on the panel
	SpringLayout pos = new SpringLayout();
	pos.putConstraint(SpringLayout.NORTH, btnDefaultCVButton, 10, SpringLayout.NORTH, this);
	pos.putConstraint(SpringLayout.NORTH, btnDefaultPLButton, 0, SpringLayout.NORTH, btnDefaultCVButton);
	pos.putConstraint(SpringLayout.WEST, btnDefaultPLButton, 6, SpringLayout.EAST, btnClassyCVButton);
	pos.putConstraint(SpringLayout.EAST, btnDefaultCVButton, -233, SpringLayout.EAST, this);
	pos.putConstraint(SpringLayout.NORTH, btnClassyCVButton, 0, SpringLayout.NORTH, btnDefaultCVButton);
	pos.putConstraint(SpringLayout.WEST, btnClassyCVButton, 6, SpringLayout.EAST, btnDefaultCVButton);
	pos.putConstraint(SpringLayout.NORTH, defaultCV, 64, SpringLayout.NORTH, this);
	pos.putConstraint(SpringLayout.WEST, defaultCV, 5, SpringLayout.WEST, this);
	pos.putConstraint(SpringLayout.SOUTH, defaultCV, -5, SpringLayout.SOUTH, this);
	pos.putConstraint(SpringLayout.EAST, defaultCV, 559, SpringLayout.WEST, this);
	
	
	pos.putConstraint(SpringLayout.NORTH, defaultPL, 64, SpringLayout.NORTH, this);
	pos.putConstraint(SpringLayout.WEST, defaultPL, 5, SpringLayout.WEST, this);
	pos.putConstraint(SpringLayout.SOUTH, defaultPL, -5, SpringLayout.SOUTH, this);
	pos.putConstraint(SpringLayout.EAST, defaultPL, 559, SpringLayout.WEST, this);
	
	
	pos.putConstraint(SpringLayout.NORTH, classyCV, 64, SpringLayout.NORTH, this);
	pos.putConstraint(SpringLayout.WEST, classyCV, 5, SpringLayout.WEST, this);
	pos.putConstraint(SpringLayout.SOUTH, classyCV, -5, SpringLayout.SOUTH, this);
	pos.putConstraint(SpringLayout.EAST, classyCV, 559, SpringLayout.WEST, this);
	setLayout(pos);
	
	
	//Adding the components to this
	//add(documentPane);
	add(btnDefaultCVButton);
	add(btnDefaultPLButton);
	add(btnClassyCVButton);
	add(defaultPL);
	add(defaultCV);
	add(classyCV);

	
	
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
	
	}
	
}
