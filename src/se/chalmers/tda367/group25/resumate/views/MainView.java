package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.experiment.DannyMenuBar;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class MainView extends JFrame{

	private JMenuBar menuBar;
	private JPanel docView;
	private JPanel toolbarPanel;
	
	private PropertyChangeSupport pcs;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */
	
	public MainView() {
		menuBar = new DannyMenuBar();
		setJMenuBar(menuBar);
		
		setLayout(new BorderLayout());
		
		toolbarPanel = new ToolbarPanel();
		getContentPane().add(toolbarPanel);
		
		docView = new DocumentView(); 
		getContentPane().add(docView);
		
		//PropertyChangeSupport and other important stuff
		pcs = new PropertyChangeSupport(this);
		
		
	}
}
