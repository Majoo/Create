package se.chalmers.tda367.group25.resumate.views;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.GroupLayout.Alignment;

public class ToolbarPanel extends JPanel{
	private PropertyChangeSupport pcs;
	
	
	
	private JButton temp1But, temp2But, temp3But;
	private JComboBox otherTemps;

	/**
	 * Create the panel.
	 */
	public ToolbarPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		//Tools panel
		JPanel toolsPan = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, toolsPan, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, toolsPan, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, toolsPan, 69, SpringLayout.NORTH, this);
		
		toolsPan.setLayout(new GridLayout(2,1));
		//Upper part tools panel
		JPanel upperToolsPan = new JPanel();
		upperToolsPan.setLayout(new GridLayout(1,10));
		
		
		
		toolsPan.add(upperToolsPan);
		
		JButton btnNewDoc = new JButton("New Doc");
		upperToolsPan.add(btnNewDoc);
		
		JButton btnSomething = new JButton("Something");
		upperToolsPan.add(btnSomething);
		
		JButton btnSave = new JButton("Save");
		upperToolsPan.add(btnSave);
		
		JButton btnSend = new JButton("Send");
		upperToolsPan.add(btnSend);
		
		JButton btnPrint = new JButton("Print");
		upperToolsPan.add(btnPrint);
		
		JButton btnCut = new JButton("Cut");
		upperToolsPan.add(btnCut);
		
		JButton btnCopy = new JButton("Copy");
		upperToolsPan.add(btnCopy);
		
		JButton btnPaste = new JButton("Paste");
		upperToolsPan.add(btnPaste);
		
		JButton btnForward = new JButton("Forward");
		upperToolsPan.add(btnForward);
		
		JButton btnBackward = new JButton("Backward");
		upperToolsPan.add(btnBackward);
		//Lower part tools panel
		JPanel lowerToolsPan = new JPanel();
		
		JComboBox fontCB = new JComboBox();
		GroupLayout gl_lowerToolsPan = new GroupLayout(lowerToolsPan);
		gl_lowerToolsPan.setHorizontalGroup(
			gl_lowerToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lowerToolsPan.createSequentialGroup()
					.addContainerGap()
					.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(417, Short.MAX_VALUE))
		);
		gl_lowerToolsPan.setVerticalGroup(
			gl_lowerToolsPan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lowerToolsPan.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		lowerToolsPan.setLayout(gl_lowerToolsPan);
		
		toolsPan.add(lowerToolsPan);
		
		
		add(toolsPan);
		
		
		//Template chooser panel
		JPanel tempsPan = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, toolsPan, -6, SpringLayout.WEST, tempsPan);
		springLayout.putConstraint(SpringLayout.NORTH, tempsPan, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tempsPan, 525, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tempsPan, 69, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, tempsPan, -10, SpringLayout.EAST, this);
		
		tempsPan.setLayout(new GridLayout(1, 4));
		temp1But = new JButton("temp1");
		tempsPan.add(temp1But);
		temp2But = new JButton("temp2");
		tempsPan.add(temp2But);
		temp3But = new JButton("temp3");
		tempsPan.add(temp3But);
		otherTemps = new JComboBox();
		tempsPan.add(otherTemps);
		
		add(tempsPan);
		
		//PropertyChangeSupport, Listeners and other important stuff.
		pcs = new PropertyChangeSupport(this);
		

	}
	
	/**
	 * Add a PropertyChangeListener given as a parameter.
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}
	
	/**
	 * Remove the PropertyChangeListener given as a parameter.
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl){
		pcs.removePropertyChangeListener(pcl);
	}
}
