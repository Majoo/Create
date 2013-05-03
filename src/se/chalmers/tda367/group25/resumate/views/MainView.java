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
	private JPanel docView;
	private JPanel toolbarPanel;
	
	private PropertyChangeSupport pcs;
	private DannyMenuBar dannyMenuBar;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */
	
	public MainView() {
		
		getContentPane().setLayout(new BorderLayout());
		
		toolbarPanel = new ToolbarPanel();
		SpringLayout springLayout = (SpringLayout) toolbarPanel.getLayout();
		getContentPane().add(toolbarPanel);
		
		docView = new DocumentView();
		springLayout.putConstraint(SpringLayout.NORTH, docView, 79, SpringLayout.NORTH, toolbarPanel);
		springLayout.putConstraint(SpringLayout.WEST, docView, 0, SpringLayout.WEST, toolbarPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, docView, 0, SpringLayout.SOUTH, toolbarPanel);
		springLayout.putConstraint(SpringLayout.EAST, docView, 720, SpringLayout.WEST, toolbarPanel);
		toolbarPanel.add(docView);
		
		dannyMenuBar = new DannyMenuBar();
		getContentPane().add(dannyMenuBar, BorderLayout.NORTH);
		
		//PropertyChangeSupport and other important stuff
		pcs = new PropertyChangeSupport(this);
		
		
	}
}
