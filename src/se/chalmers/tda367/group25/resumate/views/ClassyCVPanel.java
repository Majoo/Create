package se.chalmers.tda367.group25.resumate.views;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

//Only a test panel for the Classy CV.
public class ClassyCVPanel extends JPanel {

	private JEditorPane personalInfoText;
	private JEditorPane workingExperienceText;
	private JLabel imageLabel;
	
	public ClassyCVPanel() {
	setLayout(new BorderLayout(0, 0));

	//Setting struts place the components
	Component horizontalStrut_2 = Box.createHorizontalStrut(20);
	add(horizontalStrut_2, BorderLayout.WEST);
	
	Component verticalStrut = Box.createVerticalStrut(20);
	add(verticalStrut, BorderLayout.NORTH);
	
	Component verticalStrut_1 = Box.createVerticalStrut(20);
	add(verticalStrut_1, BorderLayout.SOUTH);
	
	Component horizontalStrut = Box.createHorizontalStrut(20);
	add(horizontalStrut, BorderLayout.EAST);
	
	//Setting panel which contains the different sections
	JPanel templatePanel = new JPanel();
	add(templatePanel, BorderLayout.CENTER);
	SpringLayout sl_panel_1 = new SpringLayout();
	templatePanel.setLayout(sl_panel_1);
	
	//Setting the container for the text with personal information
	personalInfoText = new JEditorPane();
	sl_panel_1.putConstraint(SpringLayout.NORTH, personalInfoText, 21, SpringLayout.NORTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.WEST, personalInfoText, 0, SpringLayout.WEST, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.SOUTH, personalInfoText, 168, SpringLayout.NORTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.EAST, personalInfoText, 164, SpringLayout.WEST, templatePanel);
	templatePanel.add(personalInfoText);
	
	//Setting the container for the image
	imageLabel = new JLabel("IMAGE");
	sl_panel_1.putConstraint(SpringLayout.NORTH, imageLabel, 21, SpringLayout.NORTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.WEST, imageLabel, 322, SpringLayout.WEST, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.EAST, imageLabel, 410, SpringLayout.WEST, templatePanel);
	templatePanel.add(imageLabel);
	
	//Setting the container for the text with working experience
	workingExperienceText = new JEditorPane();
	sl_panel_1.putConstraint(SpringLayout.NORTH, workingExperienceText, 22, SpringLayout.SOUTH, personalInfoText);
	sl_panel_1.putConstraint(SpringLayout.WEST, workingExperienceText, 48, SpringLayout.WEST, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.SOUTH, workingExperienceText, -10, SpringLayout.SOUTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.EAST, workingExperienceText, -36, SpringLayout.EAST, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.SOUTH, imageLabel, -22, SpringLayout.NORTH, workingExperienceText);
	templatePanel.add(workingExperienceText);

	}

}
