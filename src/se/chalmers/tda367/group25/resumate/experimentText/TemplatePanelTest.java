package se.chalmers.tda367.group25.resumate.experimentText;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

public class TemplatePanelTest extends JPanel implements FocusListener {

	//private JEditorPane editorPane;
	private JToggleButton tglbtnB;
	private JToggleButton tglbtnI;
	private JToggleButton tglbtnU;
	private JComboBox fontComboBox;
	private JComboBox sizeComboBox;
	private JTextField txtFont;
	private TemplatePanel p;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private JEditorPane section;

	public TemplatePanelTest() {
		p = new TemplatePanel();
		p.addFocusListener(this);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		// Setting GUI-placement
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.WEST, rigidArea, 10,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, rigidArea, -10,
				SpringLayout.SOUTH, this);
		add(rigidArea);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rigidArea_1, 0,
				SpringLayout.NORTH, rigidArea);
		springLayout.putConstraint(SpringLayout.EAST, rigidArea_1, -10,
				SpringLayout.EAST, this);
		add(rigidArea_1);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rigidArea_2, 10,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, rigidArea_2, 0,
				SpringLayout.WEST, rigidArea);
		add(rigidArea_2);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rigidArea_3, 0,
				SpringLayout.NORTH, rigidArea_2);
		springLayout.putConstraint(SpringLayout.EAST, rigidArea_3, 0,
				SpringLayout.EAST, rigidArea_1);
		add(rigidArea_3);

		// Setting properties for the textarea
		springLayout.putConstraint(SpringLayout.NORTH, p.getOtherText(), 46,
				SpringLayout.SOUTH, rigidArea_2);
		springLayout.putConstraint(SpringLayout.WEST, p.getOtherText(), 33,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, p.getOtherText(), -42,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, p.getOtherText(), 410,
				SpringLayout.WEST, this);
		p.getOtherText().addFocusListener(this);
		add(p.getOtherText());

		// Setting properties for the "Find text"-button
		JButton btnFindText = new JButton("Find");
		btnFindText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = JOptionPane.showInputDialog(null, null,
						"Find text", 2);
				findText(text);

			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnFindText, -6,
				SpringLayout.NORTH, p.getOtherText());
		springLayout.putConstraint(SpringLayout.EAST, btnFindText, 0,
				SpringLayout.EAST, p.getOtherText());
		add(btnFindText);

		// Setting properties for the "Replace text"-button
		JButton btnReplaceText = new JButton("Replace");
		springLayout.putConstraint(SpringLayout.SOUTH, btnReplaceText, -6,
				SpringLayout.NORTH, p.getOtherText());
		springLayout.putConstraint(SpringLayout.EAST, btnReplaceText, -6,
				SpringLayout.WEST, btnFindText);
		btnReplaceText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String replaceText = null;
				String replaceWith = null;

				boolean replaceWithNeedsInput = true;
				boolean replaceNeedsInput = true;
				while(replaceNeedsInput){
					replaceText = JOptionPane.showInputDialog(null, null,
							"Replace text", 2);
					if(replaceText.isEmpty()){
						JOptionPane.showMessageDialog(null,"Please enter a word to replace");
					} else {
						replaceNeedsInput = false;
						while(replaceWithNeedsInput){
							replaceWith = JOptionPane.showInputDialog(null, null,
							"Replace " + replaceText + " with:", 2);
							if (replaceWith.isEmpty()){
								JOptionPane.showMessageDialog(null,"Please enter a word to replace with");
							} else {
								replaceWithNeedsInput = false;
								replaceText(replaceText, replaceWith);
							}
						}
					}
				}	
			}
		});
		add(btnReplaceText);

		// Setting properties for the button which makes the text bold
		tglbtnB = new JToggleButton("B");
		springLayout.putConstraint(SpringLayout.NORTH, tglbtnB, 0,
				SpringLayout.NORTH, btnFindText);
		springLayout.putConstraint(SpringLayout.WEST, tglbtnB, 0,
				SpringLayout.WEST, p.getOtherText());
		tglbtnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeStyle("B");
			}
		});
		tglbtnB.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(tglbtnB);

		// Setting properties for the button which make the text italic
		tglbtnI = new JToggleButton("I");
		springLayout.putConstraint(SpringLayout.WEST, tglbtnI, 6,
				SpringLayout.EAST, tglbtnB);
		springLayout.putConstraint(SpringLayout.SOUTH, tglbtnI, -6,
				SpringLayout.NORTH, p.getOtherText());
		tglbtnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeStyle("I");
			}
		});
		tglbtnI.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(tglbtnI);

		// Setting properties for the button which make the text underlined
		tglbtnU = new JToggleButton("U");
		springLayout.putConstraint(SpringLayout.WEST, tglbtnU, 6,
				SpringLayout.EAST, tglbtnI);
		springLayout.putConstraint(SpringLayout.SOUTH, tglbtnU, -6,
				SpringLayout.NORTH, p.getOtherText());
		tglbtnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeStyle("U");
			}
		});
		Map  <TextAttribute, Integer> attributes = new HashMap  <TextAttribute, Integer>();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		Font font = tglbtnU.getFont().deriveFont(attributes);
		tglbtnU.setFont(font);
		add(tglbtnU);

		// Setting properties for the combobox in which the fonts are listed
		fontComboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, fontComboBox, 0,
				SpringLayout.WEST, tglbtnI);
		springLayout.putConstraint(SpringLayout.SOUTH, fontComboBox, -6,
				SpringLayout.NORTH, tglbtnB);
		fontComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t = fontComboBox.getSelectedItem().toString();
				changeFont(t);
			}
		});
		/*
		 * ResuMate, this can be used in the graphical part of our
		 * program. Gathering all the fonts on the computer and then take their
		 * name to be listed in the combobox.
		 */

		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Font[] fonts = e.getAllFonts(); // Get the fonts
		String[] fontName = new String[fonts.length];
		for (int i = 0; i < fonts.length; i++) {
			fontName[i] = fonts[i].getFontName();

		}
		fontComboBox.setModel(new DefaultComboBoxModel(fontName));
		fontComboBox.getModel().setSelectedItem(fontName[54]);
		add(fontComboBox);

		// Setting properties for the combobox in which the sizes for the text
		// are listed
		sizeComboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, fontComboBox, 0,
				SpringLayout.EAST, sizeComboBox);
		sizeComboBox.setMaximumRowCount(5);
		sizeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt((sizeComboBox.getSelectedItem()
						.toString()));
				changeSize(i);
			}
		});
		// Setting the numbers to be included in the combobox
		Integer[] numbers = new Integer[501];
		for (int i = 1; i < numbers.length; i++) {
			numbers[i - 1] = i;
		}
		sizeComboBox.setModel(new DefaultComboBoxModel(numbers));
		sizeComboBox.getModel().setSelectedItem(numbers[11]);
		springLayout.putConstraint(SpringLayout.WEST, sizeComboBox, 6,
				SpringLayout.EAST, tglbtnU);
		springLayout.putConstraint(SpringLayout.SOUTH, sizeComboBox, -6,
				SpringLayout.NORTH, p.getOtherText());
		add(sizeComboBox);

		// Setting the textfield for the fonts
		txtFont = new JTextField();
		txtFont.setBorder(null);
		springLayout.putConstraint(SpringLayout.WEST, txtFont, 6,
				SpringLayout.EAST, rigidArea_2);
		springLayout.putConstraint(SpringLayout.SOUTH, txtFont, -6,
				SpringLayout.NORTH, tglbtnB);
		springLayout.putConstraint(SpringLayout.EAST, txtFont, 45,
				SpringLayout.EAST, rigidArea_2);
		txtFont.setEditable(false);
		txtFont.setText("Font:");
		add(txtFont);
		txtFont.setColumns(10);

		JButton btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -6, SpringLayout.NORTH, btnFindText);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, btnFindText);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeText();

			}
		});
		add(btnSave);
		this.setVisible(true);
	}

	public void findText(String input) {
		//updateCurrentSection();
		// Removes the previous highlights if there were any. (Will be placed somewhere else in the GUI later)
		section.getHighlighter().removeAllHighlights();

		if (input.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Nothing to search");
			return;
		}
		/*
		 * Gets the text from the chosen editorpane and searches after the input from the beginning of the text.
		 */
		String content = section.getText();
		int start = content.indexOf(input, 0);
		int end;
		DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
				Color.YELLOW);
		int matchesFound = 0;
		boolean isSearching = true;
		
		/*
		 * Searches for the specific word.
		 * The text is found if the index of start is larger or equal to zero. The indexes of start and end it will change 
		 * so that it will be after the found word. The found word is marked by a highlighter.
		 */
		while (isSearching) {
			if (start >= 0) {
				++matchesFound;
				try {
					end = start + input.length();
					section.getHighlighter().addHighlight(start, end, painter);
					start = content.indexOf(input, end);

				} catch (BadLocationException e) {
					JOptionPane.showMessageDialog(null,
							"Error: " + e.getMessage());
				}
			} else {
				isSearching = false;
				if (matchesFound == 0) {
					JOptionPane.showMessageDialog(null, "'" + input
							+ "' not found.");
				}
			}
		}
		//JOptionPane.showMessageDialog(null, "Matches found: " + matchesFound);
	}
	
	
	public void updateCurrentSection(){
		p.setCurrentSection((JEditorPane)p.getFocusCycleRootAncestor());
		section = p.getCurrent();
	}
	
	
	public void replaceText(String replaceThis, String replaceWith) {
		//updateCurrentSection();
		pcs.firePropertyChange(TextController.replace, section, replaceThis + "/" + replaceWith);
		pcs.firePropertyChange(TextController.text, section, section.getText());
	}

	public void changeFont(String font) {
		//updateCurrentSection();
		pcs.firePropertyChange(TextController.font, section, font);
	}

	public void changeSize(int size) {
		//updateCurrentSection();
		pcs.firePropertyChange(TextController.size, section, size);

	}

	public void changeStyle(String style) {
		//updateCurrentSection();
		pcs.firePropertyChange(TextController.style, section, style);
	}
	
	public void changeText() {
		//updateCurrentSection();
		pcs.firePropertyChange(TextController.text, section, p.getOtherText().getText());
	}
	
	/**
	 * Adds an observer to this class 
	 * 
	 * @param PCL
	 * 			the observer to be added
	 */
	public void addObserver(PropertyChangeListener PCL){
		pcs.addPropertyChangeListener(PCL);
		
	}
	
	/**
	 * Removes an observer of this class
	 * 
	 * @param PCL
	 * 			the observer to be removed
	 */
	public void removeObserver(PropertyChangeListener PCL){
		pcs.removePropertyChangeListener(PCL);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		System.out.print("focus");
		if(arg0.getComponent() instanceof JEditorPane){
			//updateCurrentSection();
			section = (JEditorPane)arg0.getComponent();
			System.out.print("swag");
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
