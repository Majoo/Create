package se.chalmers.tda367.group25.resumate.experiment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class DannyForm extends JFrame {

	
	private JPanel contentPane;
	private JTextArea informationTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DannyForm frame = new DannyForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DannyForm() {
		setTitle("Text Editor by Lam(m)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		
		
		
		
		//add content
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		
		
		
		DannyMenuBar dannyMenuBar = new DannyMenuBar();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dannyMenuBar, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, dannyMenuBar, 0, SpringLayout.WEST, contentPane);
		getContentPane().add(dannyMenuBar);
		
		informationTextArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, informationTextArea, 16, SpringLayout.SOUTH, dannyMenuBar);
		sl_contentPane.putConstraint(SpringLayout.WEST, informationTextArea, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, informationTextArea, 222, SpringLayout.WEST, contentPane);
		contentPane.add(informationTextArea);
		
		JTextArea aboutmeTextArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, informationTextArea, -56, SpringLayout.NORTH, aboutmeTextArea);
		sl_contentPane.putConstraint(SpringLayout.WEST, aboutmeTextArea, 17, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, aboutmeTextArea, -15, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, aboutmeTextArea, 243, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, aboutmeTextArea, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(aboutmeTextArea);
	}
}