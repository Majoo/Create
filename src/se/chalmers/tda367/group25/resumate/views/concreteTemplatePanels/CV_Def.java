package se.chalmers.tda367.group25.resumate.views.concreteTemplatePanels;

import se.chalmers.tda367.group25.resumate.views.TemplatePanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CV_Def extends TemplatePanel {
	
	public CV_Def() {
		super();
<<<<<<< HEAD
=======
		 
		//Initialize components
		this.personalInfoText = new JEditorPane();
		personalInfoText.setText("[PERSONAL_INFO] \nNamn:  \nAdress: \nPostnummer: \nIgnoreraDetta:");
		setPersonalInfo(personalInfoText);
		this.imageLbl = new JLabel();
		setImageLabel(imageLbl);
		this.otherText = new JEditorPane();
		otherText.setText("[HEADLINE]");
		setOther(otherText);
		this.workingExperienceText = new JEditorPane();
		workingExperienceText.setText("[INFORMATION]");
		setWorkingExperience(workingExperienceText);
>>>>>>> 103b5c472c7c4f746c86463a59d79d3c518cc440
		
		//Place components
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
<<<<<<< HEAD
<<<<<<< HEAD
							.addComponent(getWorkingExperienceText(), GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(getPersonalInfoText(), GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(getImageLabel(), GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(57))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getOtherText(), GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
=======
							.addComponent(workingExperienceText, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(personalInfoText, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(57))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(otherText, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
>>>>>>> 103b5c472c7c4f746c86463a59d79d3c518cc440
=======
							.addComponent(workingExperienceText, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(personalInfoText, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(57))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(otherText, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
>>>>>>> 103b5c472c7c4f746c86463a59d79d3c518cc440
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
<<<<<<< HEAD
<<<<<<< HEAD
						.addComponent(getImageLabel(), GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPersonalInfoText(), GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getOtherText(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getWorkingExperienceText(), GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
=======
=======
>>>>>>> 103b5c472c7c4f746c86463a59d79d3c518cc440
						.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(personalInfoText, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(otherText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(workingExperienceText, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
>>>>>>> 103b5c472c7c4f746c86463a59d79d3c518cc440
=======
>>>>>>> 103b5c472c7c4f746c86463a59d79d3c518cc440
					.addContainerGap(97, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
