package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.experiment.DannyMenuBar;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.itextpdf.awt.geom.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainView extends JFrame implements MainViewInterface{
	private DannyMenuBar dannyMenuBar;
	private JPanel toolbarPanel;
	private JPanel docView;

	private PropertyChangeSupport pcs;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */

	public MainView() {
		//Creating and setting backgroundpanel
		JPanel contentPane = new JPanel();
		Dimension preferredSize = new Dimension(100,100);
		//contentPane.setPreferredSize(preferredSize);

		//Initializing components
		dannyMenuBar = new DannyMenuBar();
		toolbarPanel = new ToolbarPanel();
		docView = new DocumentView();
		
		//Placing components
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(dannyMenuBar, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
						.addComponent(toolbarPanel, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
						.addComponent(docView, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(dannyMenuBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toolbarPanel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(docView, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
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
