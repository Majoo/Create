package se.chalmers.tda367.group25.resumate.main;

import se.chalmers.tda367.group25.resumate.model.ResuMate;
import se.chalmers.tda367.group25.resumate.papperskorgen.DocumentView;

/*
 * The Main class is used to start the application.
 */
public class Main {

	public static void main(String[] args) {
		ResuMate rm = new ResuMate();
		DocumentView panel = new DocumentView(rm.getDoc(0));
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
	}
}
