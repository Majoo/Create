package se.chalmers.tda367.group25.resumate.main;

import se.chalmers.tda367.group25.resumate.views.DocumentView;

/*
 * The Main class is used to start the application.
 */
public class Main {
	
	public static void main(String[] args) {
		DocumentView panel = new DocumentView();
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
	}
}
