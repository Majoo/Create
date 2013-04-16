package se.chalmers.tda267.group25.resumate.GUIview;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DocumentFormTest extends JFrame {
	private JPanel documentPane;

	//Create the frame.

	public DocumentFormTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		documentPane = new JPanel();
		documentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		documentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(documentPane);
		setTitle("ResuMate");
	}
}