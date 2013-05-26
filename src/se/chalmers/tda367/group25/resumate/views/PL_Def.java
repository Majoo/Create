package se.chalmers.tda367.group25.resumate.views;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * A class that represents the Personal Letter template
 */
public class PL_Def extends TemplatePanel {

	public PL_Def() {
		super();

		// Place components
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.CENTER)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.CENTER)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				getEducationText(),
																				GroupLayout.PREFERRED_SIZE,
																				500,
																				Short.MAX_VALUE))
														.addComponent(
																getWorkExpHeader(),
																GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.CENTER,
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				getImageLabel(),
																				GroupLayout.PREFERRED_SIZE,
																				77,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(10)
																		.addContainerGap()
																		.addContainerGap()
																		.addContainerGap()

																		.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.BASELINE).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout.createParallelGroup(
										Alignment.TRAILING, false)

								.addComponent(getImageLabel(),
										Alignment.CENTER,
										GroupLayout.PREFERRED_SIZE, 10,
										Short.MAX_VALUE))
						.addContainerGap()
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getWorkExpHeader(),
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE)

						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								groupLayout.createParallelGroup(
										Alignment.CENTER).addComponent(
										getEducationText(),
										GroupLayout.PREFERRED_SIZE, 500,
										Short.MAX_VALUE)).addContainerGap()));
		setLayout(groupLayout);

	}
}