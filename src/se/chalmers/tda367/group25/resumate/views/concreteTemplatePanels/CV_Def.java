package se.chalmers.tda367.group25.resumate.views.concreteTemplatePanels;

import se.chalmers.tda367.group25.resumate.views.TemplatePanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CV_Def extends TemplatePanel {
	private JEditorPane personalInfoText;
	private JEditorPane workingExperienceText;
	private JEditorPane otherText;
	private JEditorPane imageContainer;
	
	public CV_Def() {
		super();
		 
		//Initialize components
		this.personalInfoText = new JEditorPane();
		setPersonalInfo(personalInfoText);
		this.imageContainer = new JEditorPane();
		setImageContainer(imageContainer);
		this.otherText = new JEditorPane();
		setOther(otherText);
		this.workingExperienceText = new JEditorPane();
		setWorkingExperience(workingExperienceText);
		
		//Place components
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(workingExperienceText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(personalInfoText, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
								.addComponent(otherText, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(imageContainer, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addGap(57))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(personalInfoText, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(otherText))
						.addComponent(imageContainer, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(workingExperienceText, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
