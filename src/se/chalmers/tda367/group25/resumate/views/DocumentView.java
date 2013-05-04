package se.chalmers.tda367.group25.resumate.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.SpringLayout;

public class DocumentView extends JPanel{
	public DocumentView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblDocumentview = new JLabel("documentview");
		springLayout.putConstraint(SpringLayout.NORTH, lblDocumentview, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblDocumentview, -136, SpringLayout.EAST, this);
		add(lblDocumentview);
		
		JEditorPane editorPane = new JEditorPane();
		springLayout.putConstraint(SpringLayout.NORTH, editorPane, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, editorPane, 21, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, editorPane, 290, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, editorPane, 440, SpringLayout.WEST, this);
		add(editorPane);
	}

}
