package se.chalmers.tda367.group25.resumate.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.SpringLayout;

/**
 * What the hell gör den här klassen??? Vi har ju TemplatePanel liksom
 *  eller snälla I don't getIT?
 * @author Patricia
 *
 */
public class DocumentView extends JPanel{
	public DocumentView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JEditorPane editorPane = new JEditorPane();
		springLayout.putConstraint(SpringLayout.NORTH, editorPane, 23, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, editorPane, 21, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, editorPane, 123, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, editorPane, 480, SpringLayout.WEST, this);
		add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		springLayout.putConstraint(SpringLayout.NORTH, editorPane_1, 20, SpringLayout.SOUTH, editorPane);
		springLayout.putConstraint(SpringLayout.WEST, editorPane_1, 0, SpringLayout.WEST, editorPane);
		springLayout.putConstraint(SpringLayout.SOUTH, editorPane_1, 142, SpringLayout.SOUTH, editorPane);
		springLayout.putConstraint(SpringLayout.EAST, editorPane_1, 0, SpringLayout.EAST, editorPane);
		add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		springLayout.putConstraint(SpringLayout.NORTH, editorPane_2, 20, SpringLayout.SOUTH, editorPane_1);
		springLayout.putConstraint(SpringLayout.WEST, editorPane_2, 0, SpringLayout.WEST, editorPane);
		springLayout.putConstraint(SpringLayout.SOUTH, editorPane_2, 120, SpringLayout.SOUTH, editorPane_1);
		springLayout.putConstraint(SpringLayout.EAST, editorPane_2, 459, SpringLayout.WEST, editorPane);
		add(editorPane_2);
	}

}
