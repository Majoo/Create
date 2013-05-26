package se.chalmers.tda367.group25.resumate.views;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * A class that represents the CV Classy template.
 */

public class CV_Classy extends TemplatePanel {

	public CV_Classy() {
		super();

		// Place components
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				getWorkingExperienceText(),
																				GroupLayout.PREFERRED_SIZE,
																				154,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				getEducationText(),
																				GroupLayout.DEFAULT_SIZE,
																				145,
																				Short.MAX_VALUE))
														.addComponent(
																getWorkExpHeader(),
																GroupLayout.DEFAULT_SIZE,
																305,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.TRAILING,
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				getImageLabel(),
																				GroupLayout.PREFERRED_SIZE,
																				77,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				getEducationText(),
																				GroupLayout.DEFAULT_SIZE,
																				210,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(
												Alignment.TRAILING, false)
										.addComponent(getEducationText(),
												Alignment.LEADING)
										.addComponent(getImageLabel(),
												Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE, 113,
												Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getWorkExpHeader(),
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(getEducationText(),
												GroupLayout.DEFAULT_SIZE, 133,
												Short.MAX_VALUE)
										.addComponent(
												getWorkingExperienceText(),
												GroupLayout.DEFAULT_SIZE, 133,
												Short.MAX_VALUE))
						.addContainerGap()));
		setLayout(groupLayout);

	}
}
