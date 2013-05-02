package se.chalmers.tda367.group25.resumate.experiment2;

import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemplatePanelTest extends JPanel {

	JEditorPane editorPane;
	
	TemplatePanelTest(){
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.WEST, rigidArea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, rigidArea, -10, SpringLayout.SOUTH, this);
		add(rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rigidArea_1, 0, SpringLayout.NORTH, rigidArea);
		springLayout.putConstraint(SpringLayout.EAST, rigidArea_1, -10, SpringLayout.EAST, this);
		add(rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rigidArea_2, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, rigidArea_2, 0, SpringLayout.WEST, rigidArea);
		add(rigidArea_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rigidArea_3, 0, SpringLayout.NORTH, rigidArea_2);
		springLayout.putConstraint(SpringLayout.EAST, rigidArea_3, 0, SpringLayout.EAST, rigidArea_1);
		add(rigidArea_3);
		
		editorPane = new JEditorPane();
		springLayout.putConstraint(SpringLayout.NORTH, editorPane, 46, SpringLayout.SOUTH, rigidArea_2);
		springLayout.putConstraint(SpringLayout.WEST, editorPane, 33, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, editorPane, -42, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, editorPane, 410, SpringLayout.WEST, this);
		add(editorPane);
		
		JButton btnFindText = new JButton("Find Text");
		btnFindText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = JOptionPane.showInputDialog(null, null, "Find text", 2);
				findText(text, editorPane);
			
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnFindText, -6, SpringLayout.NORTH, editorPane);
		springLayout.putConstraint(SpringLayout.EAST, btnFindText, 0, SpringLayout.EAST, editorPane);
		add(btnFindText);
		
		this.setVisible(true);
	}
	
	/**
	 * Searches after the String input in variable text
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public void findText(String input, JEditorPane section){
		Scanner in = new Scanner(section.getText());
		while(in.hasNext()){
			if(in.findInLine(input) != null){
				int startIndex = in.findInLine(input).indexOf(input);
				int endIndex = in.findInLine(input).lastIndexOf(input, startIndex);	
				section.setSelectionStart(startIndex);
				section.setSelectionEnd(endIndex);
			}
		}			           			          
	}
}
