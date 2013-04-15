package se.chalmers.tda367.group25.resumate;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JLabel;

//Only a test GUi
public class DefaultTempPanel extends JPanel {
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JTextArea textArea4;
	private JLabel imageLabel;
	
	public DefaultTempPanel() {
		setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea1 = new JTextArea();
		panel.add(textArea1, BorderLayout.NORTH);
		
		textArea2 = new JTextArea();
		panel.add(textArea2, BorderLayout.WEST);
		
		imageLabel = new JLabel("");
		panel.add(imageLabel, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textArea3 = new JTextArea();
		panel_1.add(textArea3, BorderLayout.NORTH);
		
		textArea4 = new JTextArea();
		panel_1.add(textArea4, BorderLayout.SOUTH);
	}
	

}
