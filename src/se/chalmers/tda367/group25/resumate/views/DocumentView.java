package se.chalmers.tda367.group25.resumate.views;

import javax.swing.JFrame;


public class DocumentView extends JFrame {

	public DocumentView () {
		DocumentPanel p = new DocumentPanel();
		add(p);
		setTitle("ResuMate - Untitled");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 580, 650);

	}
}
