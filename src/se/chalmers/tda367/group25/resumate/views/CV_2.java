package se.chalmers.tda367.group25.resumate.views;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CV_2 extends TemplatePanel {
	
	public CV_2() {
		super();
		
		//Place components
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getWorkingExperienceText(), GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(educationText(), GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
						.addComponent(getHeaderTitle(), GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(getImageLabel(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getPersonalInfoText(), GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(getPersonalInfoText(), Alignment.LEADING)
						.addComponent(getImageLabel(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getHeaderTitle(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(educationText(), GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(getWorkingExperienceText(), GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
}
