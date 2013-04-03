package TextEditor1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextEditor extends JFrame implements ActionListener {

	JLabel nameField;
	JButton openB;
	JButton saveB;
	JButton quitB;
	JButton boldB;
	//JToggleButton boldB;
	JButton italicB;
	JTextArea textArea;
	String defaultFont = "Monospaced";
	int defaultFontStyle = Font.PLAIN;
	int defaultFontSize = 12;
	String currentFont;
	int currentFontStyle;
	int currentSize;
	
	
	public TextEditor ()  {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel optionPanel = new JPanel();
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new GridLayout(2,1));
		actionPanel.setPreferredSize(new Dimension (50, 50));
		optionPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		optionPanel.setLayout(new GridLayout(1,5));
		//optionPanel.add(new JLabel("Name: ", JLabel.RIGHT));
		
		Container c = getContentPane();
		currentFont = defaultFont;
		currentFontStyle= defaultFontStyle;
		currentSize = defaultFontSize;
		
		
		nameField = new JLabel("Name :");
		openB = new JButton("Open");
		saveB = new JButton("Save as...");
		quitB = new JButton("Quit");
		//boldB = new JToggleButton(new ImageIcon("Bold.png"), false);
		boldB = new JButton("B");
		italicB = new JButton("I");
		textArea = new JTextArea(20, 10);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	

		openB.addActionListener(this);
		saveB.addActionListener(this);
		quitB.addActionListener(this);
		boldB.addActionListener(this);
		italicB.addActionListener(this);
	
		optionPanel.add(openB);
		optionPanel.add(saveB);
		optionPanel.add(quitB); 
		actionPanel.add(boldB); 
		actionPanel.add(italicB);
		
		mainPanel.add(nameField, BorderLayout.NORTH);
		mainPanel.add(actionPanel, BorderLayout.WEST);
		mainPanel.add(optionPanel, BorderLayout.EAST);
		c.add(mainPanel, BorderLayout.NORTH);
		c.add(scrollPane, BorderLayout.CENTER);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(openB)) {
			JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
			int selection = fc.showOpenDialog(null);
			if(selection == JFileChooser.APPROVE_OPTION) {
				readFile(fc.getSelectedFile().getName());
			}
		}
		
		else if (e.getSource().equals(saveB)){
			JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
			int selection = fc.showSaveDialog(null);
			if(selection == JFileChooser.APPROVE_OPTION) {
				saveFile(fc.getSelectedFile().getName());
			}
		}
		else if (e.getSource().equals(quitB)){
			System.exit(0);
		}
		else if(e.getSource().equals(boldB)){	
			if(!textArea.getFont().equals(boldB)){
				changeFontStyle(Font.BOLD);
			} else {
			changeFontStyle(Font.PLAIN);			
			}
		}
		else if (e.getSource().equals(italicB)) {
			if(!textArea.getFont().equals(italicB)){
				changeFontStyle(Font.ITALIC);
			} else {
				changeFontStyle(Font.PLAIN);
			}
		}
			
	}
	
	/*private class FontActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(bold) ){	
				if(!textArea.getFont().equals(boldB)){
					changeFontStyle(Font.BOLD);
				} else {
				changeFontStyle(Font.PLAIN);			
				}
			}
			else if (e.getSource().equals(italicB)) {
				if(!textArea.getFont().equals(italicB)){
					changeFontStyle(Font.ITALIC);
				} else {
					changeFontStyle(Font.PLAIN);
				}
			}
				
			
			
		}
	}*/
	
	
	private void changeFont(String fontName) {
		textArea.setFont(new Font(fontName,currentFontStyle, currentSize));
	}
	
	private void changeFontStyle(int styleName){
		textArea.setFont(new Font(currentFont, styleName, currentSize));
	}
	
	private void changeSize(int size){
		textArea.setFont(new Font(currentFont, currentFontStyle, size));
		
	}
	
	
	
	private void readFile(String name) {
		try {
			FileReader r = new FileReader(name);
			textArea.read(r, null);
			nameField.setText(name);
		}
		catch (IOException e) {}
	}
	
	private void saveFile(String name) {
		try {
			FileWriter w = new FileWriter(name + ".txt");
			textArea.write(w);
		} 
		catch (IOException e) {}
		
	}
	
	
	public static void main (String [] arg) {
			TextEditor t = new TextEditor();
	}
	
	
	
	
}
