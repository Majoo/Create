package se.chalmers.tda367.group25.resumate.experiment;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class DannyForm extends JFrame {


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
		
		DannyMenuBar dl = new DannyMenuBar();
	}
}