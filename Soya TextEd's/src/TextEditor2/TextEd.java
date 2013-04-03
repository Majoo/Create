package TextEditor2;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.text.DefaultEditorKit;


public class TextEd extends JFrame {

	private JTextArea area = new JTextArea(10,16);
	private JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
	private String currentFile = "Untitled";
	private boolean isChanged = false;
	/*private JMenuItem save;
	private JMenuItem saveAs;
	//private JMenuItem neew;
	private JMenuItem open;
	private JMenuItem exit;*/
	private JButton color; 
	
	public TextEd () {
		area.setFont(new Font("Monospaced", Font.PLAIN, 12));
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll,BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		scroll.setColumnHeaderView(toolBar);
		
		JToggleButton bold = new JToggleButton("B");
		toolBar.add(bold);
		
		JToggleButton italic = new JToggleButton("I");
		toolBar.add(italic);
		
		JToggleButton lined = new JToggleButton("U");
		lined.setToolTipText("Underline text");
		lined.setMnemonic('U');
		toolBar.add(lined);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"6", "8", "10", "12", "14", "16", "18", "20", "24", "30", "36", "42", "50"}));
		comboBox.setSelectedIndex(3);
		toolBar.add(comboBox);
		
		color = new JButton("A");
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame jd = new JInternalFrame();
				JColorChooser col = new JColorChooser();
				jd.add(col);
				color.setBackground(col.getColor());
				setVisible(true);
			}
		});
		toolBar.add(color);
		
		
		
		//Menu
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		mb.add(file);
		mb.add(edit);
		
		/*neew = new JMenuItem("New");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As");
		exit = new JMenuItem("Exit");*/
	
		file.add(neew); file.add(open);
		file.add(save); file.add(saveAs);
		file.addSeparator(); file.add(exit);
		
		for(int i = 0; i <4; i++){
			file.getItem(i).setIcon(null);
		}
		
		/*JMenuItem cut= new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");*/
		edit.add(cut); edit.add(copy); edit.add(paste);
		edit.getItem(0).setText("Cut");
		edit.getItem(1).setText("Copy");
		edit.getItem(2).setText("Paste");

		JToolBar toolB = new JToolBar();
		getContentPane().add(toolB, BorderLayout.NORTH);
		/*JButton newB = new JButton(new ImageIcon("new.png"));
		JButton openB = new JButton(new ImageIcon("open.png"));
		JButton saveB = new JButton(new ImageIcon("save.png"));
		JButton saveSB = new JButton(new ImageIcon("saveAs.png"));
		JButton cutB = new JButton(new ImageIcon("cut.png"));
		JButton copyB = new JButton(new ImageIcon("copy.png"));
		JButton pasteB =  new JButton(new ImageIcon("paste.png"));
		newB.addActionListener(nB);
		openB.addActionListener(oB);
		saveB.addActionListener(sB);
		saveSB.addActionListener(ssB);
		//toolB.add(newB);
		toolB.add(openB); toolB.add(saveB); 
		toolB.add(cutB); toolB.add(copyB); toolB.add(pasteB);*/
		toolB.add(neew); toolB.add(open); toolB.add(save); toolB.add(saveAs); toolB.addSeparator();
		JButton cu = toolB.add(cut), cop = toolB.add(copy), pas = toolB.add(paste);
		cu.setText(""); cu.setIcon(new ImageIcon("cut.png")); cu.setToolTipText("Cut");
		cop.setText(""); cop.setIcon(new ImageIcon("copy.png")); cop.setToolTipText("Copy");
		pas.setText(""); pas.setIcon(new ImageIcon("paste.png")); pas.setToolTipText("Paste");		
		
		save.setEnabled(false);
		saveAs.setEnabled(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		area.addKeyListener(kl);
		setTitle(currentFile);
		setVisible(true);	
	}
	
	private KeyListener kl = new KeyAdapter() {
		public void keyPressed(KeyEvent e){
			isChanged = true;
			save.setEnabled(true);
			saveAs.setEnabled(true);
		}
	};
	
	Action neew = new AbstractAction("New", new ImageIcon("new.png")) {
	//private ActionListener nB = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			saveOld();
			area.setText("");
			currentFile = "Untitled";
			isChanged = false;
			save.setEnabled(false);
			saveAs.setEnabled(false);
		}
	};
	
	Action open = new AbstractAction("Open", new ImageIcon("open.png")) {
	//private ActionListener oB = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			saveOld();
			if(dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				readFile(dialog.getSelectedFile().getName());
			}
			saveAs.setEnabled(false);
		}
	};
	
	Action save = new AbstractAction("Save", new ImageIcon("save.png")) {
	//private ActionListener sB = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!currentFile.equals("Untitled")){
				saveFile(currentFile);
			} else {
				saveFileAs();
			}
		}
	};
	
	Action saveAs = new AbstractAction("Save As", new ImageIcon("saveAs.png")) {
	//private ActionListener ssB = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				saveFileAs();
		}
	};
	
	Action exit = new AbstractAction("Exit") {
	//private ActionListener ssB = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				saveOld();
				System.exit(0);
		}
	};
	
	
	ActionMap m = area.getActionMap();
		Action cut = m.get(DefaultEditorKit.cutAction);
		Action copy = m.get(DefaultEditorKit.copyAction);
		Action paste = m.get(DefaultEditorKit.pasteAction);
		
	private void saveFileAs() {
		if(dialog.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
		saveFile(dialog.getSelectedFile().getName());
		}
	}
	
	private void saveOld(){
		if(isChanged){
			if(JOptionPane.showConfirmDialog(this, "Would you like to save " + currentFile + "?"," ",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				saveFile(currentFile);
			}
		}
	}
	
	private void readFile(String fileName){
		try {
			FileReader r = new FileReader(fileName);
			area.read(r, null);
			r.close();
			currentFile = fileName;
			setTitle(currentFile);
			isChanged = false;
		} 
		catch (IOException e){
			Toolkit.getDefaultToolkit().beep(); //Ange ljudsignal
			JOptionPane.showMessageDialog(this, "Det går inte att hitta filen" + fileName);
		}
	}
		
	private void saveFile(String fileName) {
		try { 
			FileWriter w = new FileWriter(fileName);
			area.write(w);
			w.close();
			currentFile = fileName;
			setTitle(currentFile);
			isChanged = false;
			save.setEnabled(false);
			
		}
		catch (IOException e){}
	}
	
	public static void main (String [] args) {
		TextEd m = new TextEd();
	}
}
