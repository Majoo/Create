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

//Only a test GUI
public class DefaultPLPanel extends AbsDocumentPanel{

	private JEditorPane personalInfoText;
	private JLabel imageLabel;
	
	public DefaultPLPanel() {
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
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		//Setting the container for the text with personal information
		personalInfoText = new JEditorPane();
		sl_panel.putConstraint(SpringLayout.NORTH, personalInfoText, 147, SpringLayout.NORTH, panel);
		personalInfoText.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
				textUpdate(arg0, getPersonalInfo());
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				textUpdate(arg0, getPersonalInfo());
			}
		});
		personalInfoText.setToolTipText("Ber\u00E4tta om dig sj\u00E4lv!");
		sl_panel.putConstraint(SpringLayout.WEST, personalInfoText, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, personalInfoText, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, personalInfoText, -119, SpringLayout.EAST, panel);
		panel.add(personalInfoText);
		
		//Setting the container for the image
		imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(DefaultPLPanel.class.getResource("/se/chalmers/tda367/group25/resumate/other/picture.png")));
		sl_panel.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, imageLabel, -91, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, imageLabel, 143, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, imageLabel, -10, SpringLayout.EAST, panel);
		panel.add(imageLabel);

	}
	
	public String getPersonalInfo(){
		return personalInfoText.getText();
	}
	
	@Override
	public void updateTextInView(Map <SectionType, RMText> text) {
		personalInfoText.setText(text.get(SectionType.PERSONAL_INFO).getText());
		
	}
}
