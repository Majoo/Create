package se.chalmers.tda367.group25.resumate.papperskorgen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.model.SectionType;

//Only a test panel for the Classy CV.
/*public class ClassyCVPanel extends AbsDocumentPanel {

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
	personalInfoText.addInputMethodListener(new InputMethodListener() {
		public void caretPositionChanged(InputMethodEvent arg0) {
			textUpdate(arg0, getPersonalInfo());
		}
		public void inputMethodTextChanged(InputMethodEvent arg0) {
			textUpdate(arg0, getPersonalInfo());
		}
	});
	sl_panel_1.putConstraint(SpringLayout.SOUTH, personalInfoText, 104, SpringLayout.NORTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.EAST, personalInfoText, 156, SpringLayout.WEST, templatePanel);
	personalInfoText.setText("Namn:\r\nAdress:\r\nPost.nr:\r\nTelefon.nr:\r\nE-mail:");
	personalInfoText.setToolTipText("H\u00E4r ska det st\u00E5 personligt information! ");
	sl_panel_1.putConstraint(SpringLayout.NORTH, personalInfoText, 21, SpringLayout.NORTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.WEST, personalInfoText, 0, SpringLayout.WEST, templatePanel);
	templatePanel.add(personalInfoText);
	
	//Setting the container for the image
	imageLabel = new JLabel("");
	sl_panel_1.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, personalInfoText);
	sl_panel_1.putConstraint(SpringLayout.WEST, imageLabel, 360, SpringLayout.WEST, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.SOUTH, imageLabel, 17, SpringLayout.SOUTH, personalInfoText);
	imageLabel.setIcon(new ImageIcon(ClassyCVPanel.class.getResource("/se/chalmers/tda367/group25/resumate/other/picture.png")));
	templatePanel.add(imageLabel);
	
	//Setting the container for the text with working experience
	workingExperienceText = new JEditorPane();
	sl_panel_1.putConstraint(SpringLayout.EAST, imageLabel, 0, SpringLayout.EAST, workingExperienceText);
	workingExperienceText.addInputMethodListener(new InputMethodListener() {
		public void caretPositionChanged(InputMethodEvent arg0) {
			textUpdate(arg0, getWorkingExperience());
		}
		public void inputMethodTextChanged(InputMethodEvent arg0) {
			textUpdate(arg0, getWorkingExperience());
		}
	});
	workingExperienceText.setToolTipText("Dina referenser, betyg och erfarenhet.");
	sl_panel_1.putConstraint(SpringLayout.NORTH, workingExperienceText, 190, SpringLayout.NORTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.WEST, workingExperienceText, 0, SpringLayout.WEST, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.SOUTH, workingExperienceText, -10, SpringLayout.SOUTH, templatePanel);
	sl_panel_1.putConstraint(SpringLayout.EAST, workingExperienceText, 0, SpringLayout.EAST, templatePanel);
	templatePanel.add(workingExperienceText);

	}

	public String getPersonalInfo(){
		return personalInfoText.getText();
	}
	
	public String getWorkingExperience(){
		return workingExperienceText.getText();
	}

	@Override
	public void updateTextInView(Map <SectionType, RMText> text) {
		personalInfoText.setText(text.get(SectionType.PERSONAL_INFO).getText());
		workingExperienceText.setText(text.get(SectionType.WORK_EXPERIENCE).getText());
		
	}
}*/
