package se.chalmers.tda367.group25.resumate.views;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class CV_Def2 extends JPanel {
	private JTextField txtName;
	private JTextField txtCityzipcode;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtEmpty;
	private JTextField workExpHeaderTF;
	private JTextField txtEmpty2;
	private JTextField educationHeaderTF;
	
	public CV_Def2() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		this.setPreferredSize(new Dimension(599, 1000));
		this.setBackground(Color.WHITE);
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setForeground(Color.WHITE);
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		JPanel pnlPersonalInfo = new JPanel();
		pnlPersonalInfo.setBackground(Color.WHITE);
		pnlPersonalInfo.setForeground(Color.WHITE);
		pnlPersonalInfo.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		workExpHeaderTF = new JTextField();
		workExpHeaderTF.setColumns(10);
		workExpHeaderTF.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		JTextPane workExperienceText = new JTextPane();
		workExperienceText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		JTextPane educationText = new JTextPane();
		educationText.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		educationHeaderTF = new JTextField();
		educationHeaderTF.setColumns(10);
		educationHeaderTF.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(workExperienceText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
								.addComponent(workExpHeaderTF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pnlPersonalInfo, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
									.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(educationText, Alignment.LEADING)
								.addComponent(educationHeaderTF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
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
							.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(9)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(workExpHeaderTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(workExperienceText, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(educationHeaderTF, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(educationText, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		
		txtName = new JTextField();
		txtName.setText("Name:");
		txtName.setColumns(10);
		txtName.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		txtCityzipcode = new JTextField();
		txtCityzipcode.setText("City/Zipcode:");
		txtCityzipcode.setColumns(10);
		txtCityzipcode.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		txtAddress = new JTextField();
		txtAddress.setText("Address:");
		txtAddress.setColumns(10);
		txtAddress.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		txtPhone = new JTextField();
		txtPhone.setText("Phone:");
		txtPhone.setColumns(10);
		txtPhone.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail:");
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		txtEmpty = new JTextField();
		txtEmpty.setColumns(10);
		txtEmpty.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		txtEmpty2 = new JTextField();
		txtEmpty2.setColumns(10);
		txtEmpty2.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		GroupLayout gl_pnlPersonalInfo = new GroupLayout(pnlPersonalInfo);
		gl_pnlPersonalInfo.setHorizontalGroup(
			gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPersonalInfo.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtEmpty, Alignment.LEADING)
							.addComponent(txtEmail, Alignment.LEADING)
							.addComponent(txtPhone, Alignment.LEADING)
							.addComponent(txtAddress, Alignment.LEADING)
							.addComponent(txtCityzipcode, Alignment.LEADING)
							.addComponent(txtName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addComponent(txtEmpty2, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_pnlPersonalInfo.setVerticalGroup(
			gl_pnlPersonalInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPersonalInfo.createSequentialGroup()
					.addGap(19)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCityzipcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmpty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmpty2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		pnlPersonalInfo.setLayout(gl_pnlPersonalInfo);
		setLayout(groupLayout);
		
		
		
	}
}
