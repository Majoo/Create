package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Template;

public class DocumentPanel extends AbsDocumentPanel {

	private DefaultPLPanel defaultPL = new DefaultPLPanel();
	private DefaultCVPanel defaultCV = new DefaultCVPanel();
	private ClassyCVPanel classyCV = new ClassyCVPanel();
	private AbsDocumentPanel currentTemplate;

	public DocumentPanel() {

		// Creating components
		JButton btnDefaultCVButton = new JButton("CV");
		JButton btnDefaultPLButton = new JButton("Personligt Brev");
		JButton btnClassyCVButton = new JButton("Elegant CV");

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		 currentTemplate = defaultCV;

		// Position the components on the panel
		SpringLayout pos = new SpringLayout();
		pos.putConstraint(SpringLayout.NORTH, btnDefaultCVButton, 10,
				SpringLayout.NORTH, this);
		pos.putConstraint(SpringLayout.NORTH, btnDefaultPLButton, 0,
				SpringLayout.NORTH, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.WEST, btnDefaultPLButton, 6,
				SpringLayout.EAST, btnClassyCVButton);
		pos.putConstraint(SpringLayout.EAST, btnDefaultCVButton, -233,
				SpringLayout.EAST, this);
		pos.putConstraint(SpringLayout.NORTH, btnClassyCVButton, 0,
				SpringLayout.NORTH, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.WEST, btnClassyCVButton, 6,
				SpringLayout.EAST, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.NORTH, defaultCV, 64,
				SpringLayout.NORTH, this);
		pos.putConstraint(SpringLayout.WEST, defaultCV, 5, SpringLayout.WEST,
				this);
		pos.putConstraint(SpringLayout.SOUTH, defaultCV, -5,
				SpringLayout.SOUTH, this);
		pos.putConstraint(SpringLayout.EAST, defaultCV, 559, SpringLayout.WEST,
				this);

		pos.putConstraint(SpringLayout.NORTH, defaultPL, 64,
				SpringLayout.NORTH, this);
		pos.putConstraint(SpringLayout.WEST, defaultPL, 5, SpringLayout.WEST,
				this);
		pos.putConstraint(SpringLayout.SOUTH, defaultPL, -5,
				SpringLayout.SOUTH, this);
		pos.putConstraint(SpringLayout.EAST, defaultPL, 559, SpringLayout.WEST,
				this);

		pos.putConstraint(SpringLayout.NORTH, classyCV, 64, SpringLayout.NORTH,
				this);
		pos.putConstraint(SpringLayout.WEST, classyCV, 5, SpringLayout.WEST,
				this);
		pos.putConstraint(SpringLayout.SOUTH, classyCV, -5, SpringLayout.SOUTH,
				this);
		pos.putConstraint(SpringLayout.EAST, classyCV, 559, SpringLayout.WEST,
				this);
		setLayout(pos);

		// Adding the components to this
		// add(documentPane);
		add(btnDefaultCVButton);
		add(btnDefaultPLButton);
		add(btnClassyCVButton);
		add(defaultCV);
		add(classyCV);
		add(defaultPL);

		JButton btnSparaText = new JButton("Spara text");
		btnSparaText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentTemplate.equals("defaultCV")) {
					textUpdate(arg0, defaultCV.getWorkingExperience());
					textUpdate(arg0, defaultCV.getPersonalInfo());
					/*classyCV.textUpdate(arg0, defaultCV.getWorkingExperience());
					defaultPL.textUpdate(arg0, defaultCV.getWorkingExperience());*/
				} else if (currentTemplate.equals("classyCV")){
					textUpdate(arg0, classyCV.getWorkingExperience());
					textUpdate(arg0, classyCV.getPersonalInfo());
					/*defaultCV.textUpdate(arg0, defaultCV.getWorkingExperience());
					defaultPL.textUpdate(arg0, defaultCV.getWorkingExperience());*/
				} else if(currentTemplate.equals("defaultPL")){
					textUpdate(arg0, defaultPL.getPersonalInfo());
					/*defaultCV.textUpdate(arg0, defaultCV.getWorkingExperience());
					classyCV.textUpdate(arg0, defaultCV.getWorkingExperience());*/
				}

			}
		});
		pos.putConstraint(SpringLayout.NORTH, btnSparaText, 0,
				SpringLayout.NORTH, btnDefaultCVButton);
		pos.putConstraint(SpringLayout.EAST, btnSparaText, -6,
				SpringLayout.WEST, btnDefaultCVButton);
		add(btnSparaText);

		// Giving the Default CV Button an ActionListener
		btnDefaultCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defaultCV.setVisible(true);
				defaultPL.setVisible(false);
				classyCV.setVisible(false);
				changedTemplate(Template.DEF_CV);
				currentTemplate = defaultCV;
			}
		});
		// Giving the Default PL Button an ActionListener
		btnDefaultPLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPL.setVisible(true);
				defaultCV.setVisible(false);
				classyCV.setVisible(false);
				changedTemplate(Template.DEF_PL);
				currentTemplate = defaultPL;
			}
		});
		// Giving the Classy CV Button an ActionListener
		btnClassyCVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classyCV.setVisible(true);
				defaultCV.setVisible(false);
				defaultPL.setVisible(false);
				changedTemplate(Template.CLASSY_CV);
				currentTemplate = classyCV;
			}
		});

	}

	public AbsDocumentPanel getCurrentTemplate() {
		return currentTemplate;
	}

	@Override
	public void updateTextInView(Map<SectionType, RMText> text) {
		defaultPL.updateTextInView(text);
		defaultCV.updateTextInView(text);
		classyCV.updateTextInView(text);

	}
}
