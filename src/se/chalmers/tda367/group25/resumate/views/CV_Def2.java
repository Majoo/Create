package se.chalmers.tda367.group25.resumate.views;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

public class CV_Def2 extends TemplatePanel {
//	private JTextField nameField;
//	private JTextField cityzipcodeField;
//	private JTextField addressField;
//	private JTextField phoneField;
//	private JTextField emailField;
//	private JTextField nameText;
//	private JTextField phoneText;
//	private JTextField emailText;
//	private JTextField textAdress;
//	private JTextField cityZipCodeText;
//
//	private JTextField txtEmpty;
//	private JTextField txtEmpty2;
//	private JTextField workExpHeader;
//	private JTextField educationHeader;

	public CV_Def2() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setPreferredSize(new Dimension(599, 1000));
		this.setBackground(Color.WHITE);

//		JLabel imgLabel = new JLabel("");
//		imgLabel.setForeground(Color.WHITE);
//		imgLabel.setBackground(Color.WHITE);
//		imgLabel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

		JPanel pnlPersonalInfo = new JPanel();
		pnlPersonalInfo.setBackground(Color.WHITE);

//		workExpHeader = new JTextField();
//		workExpHeader.setColumns(10);
//		workExpHeader.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		educationHeader = new JTextField();
//		educationHeader.setColumns(10);
//		educationHeader.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

//		JTextPane workExperienceText = new JTextPane();
//		workExperienceText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		JTextPane educationText = new JTextPane();
//		educationText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(getWorkingExperienceText(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
												.addComponent(getWorkExpHeader(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(pnlPersonalInfo, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
														.addComponent(getImageLabel(), GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
														.addGap(32))
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(getEducationText(), Alignment.LEADING)
																		.addComponent(getEduHeader(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
																		.addContainerGap())))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlPersonalInfo, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(15)
										.addComponent(getImageLabel(), GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
										.addGap(9)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getWorkExpHeader(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getWorkingExperienceText(), GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(getEduHeader(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getEducationText(), GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
										.addGap(32))
				);

		
		//The Labels that tell the user what to write in the subsequent JTextField
		
//		nameField = new JTextField();
//		nameField.setText("Name:");
//		nameField.setColumns(10);
//		nameField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
//		cityzipcodeField = new JTextField();
//		cityzipcodeField.setText("City/Zipcode:");
//		cityzipcodeField.setColumns(10);
//		cityzipcodeField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

//		addressField = new JTextField();
//		addressField.setText("Address:");
//		addressField.setColumns(10);
//		addressField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

//		phoneField = new JTextField();
//		phoneField.setText("Phone:");
//		phoneField.setColumns(10);
//		phoneField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

//		emailField = new JTextField();
//		emailField.setText("E-mail:");
//		emailField.setColumns(10);
//		emailField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));


////		Editable
//		txtEmpty = new JTextField();
//		txtEmpty.setColumns(10);
//		txtEmpty.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//		
//		txtEmpty2 = new JTextField();
//		txtEmpty2.setColumns(10);
//		txtEmpty2.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		nameText = new JTextField();
//		nameText.setColumns(10);
//		nameText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		phoneText = new JTextField();
//		phoneText.setColumns(10);
//		phoneText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		emailText = new JTextField();
//		emailText.setColumns(10);
//		emailText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		textAdress = new JTextField();
//		textAdress.setColumns(10);
//		textAdress.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
//
//		cityZipCodeText = new JTextField();
//		cityZipCodeText.setColumns(10);
//		cityZipCodeText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		GroupLayout gl_pnlPersonalInfo = new GroupLayout(pnlPersonalInfo);
		gl_pnlPersonalInfo.setHorizontalGroup(
				gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
										.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(getPhoneTitle(), Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(getNameTitle(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
												.addComponent(getEmailTitle(), Alignment.LEADING, 0, 0, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
														.addComponent(getPhoneField(), GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
														.addComponent(getNameField())
														.addComponent(getEmailField(), GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
														.addComponent(getAddressField(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
														.addComponent(getEmptyField2(), GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
														.addComponent(getAddressTitle(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
																		.addComponent(getCityTitle(), GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(getCityField()))
																		.addComponent(getEmptyField1(), Alignment.LEADING, 309, 309, 309)))
																		.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_pnlPersonalInfo.setVerticalGroup(
				gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
										.addComponent(getNameTitle(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.BASELINE)
												.addComponent(getPhoneTitle(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(getPhoneField(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.BASELINE)
														.addComponent(getEmailTitle(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(getEmailField(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
														.addComponent(getNameField(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.BASELINE)
																.addComponent(getAddressTitle(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(getAddressField(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
																		.addComponent(getCityTitle(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addComponent(getCityField(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(getEmptyField1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(getEmptyField2(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(26, Short.MAX_VALUE))
				);
		pnlPersonalInfo.setLayout(gl_pnlPersonalInfo);
		setLayout(groupLayout);



	}
}