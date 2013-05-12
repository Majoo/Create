package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.itextpdf.awt.geom.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame implements MainViewInterface{
	private MenuBar dannyMenuBar;
	private JPanel toolbarPanel;
	private JPanel docView;

	private PropertyChangeSupport pcs;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */

	public MainView() {
		//frame
		setVisible(true);
		setTitle("ResuMate" + "- [the name of the file]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
//		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //fullscreen???
//		setBounds(0,0,screenSize.width, screenSize.height - 42);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	
		
		
		//Creating and setting backgroundpanel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		//SpringLayout sl_contentPane = new SpringLayout();
		//contentPane.setLayout(sl_contentPane);
		//Dimension preferredSize = new Dimension(100,100);
		//contentPane.setPreferredSize(preferredSize);

		//Initializing components
		dannyMenuBar = new MenuBar();
		toolbarPanel = new ToolbarPanel();
		docView = new DocumentView();
		
		//Placing components
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(dannyMenuBar, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
				.addComponent(docView, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(toolbarPanel, GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(dannyMenuBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toolbarPanel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(docView, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		//PropertyChangeSupport and other important stuff
		pcs = new PropertyChangeSupport(this);
	}
	
	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}
}
