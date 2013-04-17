package se.chalmers.tda367.group25.resumate.views;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.SpringLayout;

//Only a test panel for the Default CV.
public class DefaultCVPanel extends JPanel {
	private JEditorPane personalInfoText;
	private JEditorPane workingExperienceText;
	
	public DefaultCVPanel() {
		setLayout(new BorderLayout(0, 0));
		
		//Setting struts place the components
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.WEST);
		
		//Setting panel which contains the different sections
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		//Setting the container for the text with personal information
		personalInfoText = new JEditorPane();
		sl_panel.putConstraint(SpringLayout.WEST, personalInfoText, 47, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, personalInfoText, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, personalInfoText, -61, SpringLayout.EAST, panel);
		panel.add(personalInfoText);
		
		//Setting the container for the text with working experience
		workingExperienceText = new JEditorPane();
		sl_panel.putConstraint(SpringLayout.NORTH, personalInfoText, 6, SpringLayout.SOUTH, workingExperienceText);
		sl_panel.putConstraint(SpringLayout.NORTH, workingExperienceText, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, workingExperienceText, -4, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, workingExperienceText, 136, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, workingExperienceText, 160, SpringLayout.WEST, panel);
		panel.add(workingExperienceText);
	}
}
