package se.chalmers.tda367.group25.resumate.views;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class ToolbarPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ToolbarPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel upperPanel = new JPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		JPanel lowerPanel = new JPanel();
		add(lowerPanel, BorderLayout.SOUTH);

	}

}
