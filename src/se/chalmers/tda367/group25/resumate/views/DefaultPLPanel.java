package se.chalmers.tda367.group25.resumate.views;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Only a test GUI
public class DefaultPLPanel extends JPanel{

	private JTextArea personalInfoText;
	private JTextArea workingExperienceText;
	private JTextArea emptyText;
	private JLabel imageLabel;
	
	public DefaultPLPanel() {
		setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		personalInfoText = new JTextArea();
		panel.add(personalInfoText, BorderLayout.SOUTH);
		
		workingExperienceText = new JTextArea();
		//panel.add(workingExperienceText, BorderLayout.WEST);
		
		imageLabel = new JLabel("");
		panel.add(imageLabel, BorderLayout.EAST);
		
		emptyText = new JTextArea();
		//panel.add(emptyText, BorderLayout.SOUTH);

	}
	
}
