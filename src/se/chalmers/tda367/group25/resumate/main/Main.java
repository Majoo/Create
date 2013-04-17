package se.chalmers.tda367.group25.resumate.main;

import se.chalmers.tda367.group25.resumate.views.ResumateView;

/*
 * The Main class is used to start the application.
 */
public class Main {
	
	public static void main(String[] args) {
		ResumateView panel = new ResumateView();
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
	}
}
