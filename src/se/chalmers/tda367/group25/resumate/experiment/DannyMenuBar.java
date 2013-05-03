package se.chalmers.tda367.group25.resumate.experiment;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;




public class DannyMenuBar extends JFrame {
	
	private JTextArea informationTextArea;
	//private JTextArea aboutmeTextArea;
	private String clipBoardData = "";
	private String currentFileDirectory = "";
	private JPanel contentPane;

	
	public DannyMenuBar(){
		
		//create menubar
				JMenuBar menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				
				//the file
				JMenu mnFile = new JMenu("File");
				menuBar.add(mnFile);
				
				JMenuItem mntmNew = new JMenuItem("New");
				mntmNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int selection = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to create a new document?", null,
								JOptionPane.YES_NO_OPTION);
						if (selection == JOptionPane.YES_OPTION) {
							DannyForm textEditor = new DannyForm();
							textEditor.setLocationRelativeTo(null);
							textEditor.setVisible(true);
							currentFileDirectory = "";			//a new file gets renamed to nothing
						}
					}
				});
				mnFile.add(mntmNew);
				
				//open document
				JMenuItem mntmOpen = new JMenuItem("Open");
				mntmOpen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser opChooser = new JFileChooser();		//file chooser
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Resumate File", "rsmt"); //a filter that only shows rsmt-files
						opChooser.setFileFilter(filter);					//applying the file chooser with filter
						
						int returnVal = opChooser.showOpenDialog(null); 	
						File chosenFile = opChooser.getSelectedFile();
						
						try{
							if(returnVal == JFileChooser.APPROVE_OPTION){
								BufferedReader br = new BufferedReader(new FileReader(chosenFile));
								currentFileDirectory = ""; //when open new page, set the current file name to nothing
								informationTextArea.setText(""); //empty the document workspace
								currentFileDirectory = chosenFile.getAbsolutePath(); //then set it to absolute path of chosen
								
								
								String data;
								while((data = br.readLine()) != null){				//whenever the buffered reader isn't null, 
									informationTextArea.append(data + "\n");		//overwrite the text area with the opened data
								}
								br.close();
							}
						}catch(IOException err){
							JOptionPane.showMessageDialog(null,  "ERROR!");			
							
						}
					}
				});
				mnFile.add(mntmOpen);
				
				JMenuItem mntmSave = new JMenuItem("Save");
				mntmSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if("".equals(currentFileDirectory)){					//if the current file is a new one (untitled)
							JFileChooser sdChooser = new JFileChooser();		//file chooser
							FileNameExtensionFilter filter = new FileNameExtensionFilter("Resumate File", "rsmt");
							sdChooser.setFileFilter(filter);
							int returnVal = sdChooser.showSaveDialog(null);
							
							try{
								if(returnVal == JFileChooser.APPROVE_OPTION){
									File directory = sdChooser.getCurrentDirectory();
									String path = directory.getAbsolutePath();					//the absolute path of the directory, named "path"
									String fileName = sdChooser.getSelectedFile().getName();	//get the file name
									if(!fileName.contains("rsmt")){								//if the file name doesn't contain rsmt,
										fileName = fileName + ".rsmt";							//name it a new name with .rsmt at the end
									}
									BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "\\" + fileName), "UTF-8"));
									currentFileDirectory = path + "\\" + fileName;				//the current file directory is now "theabsolutepath\\filename.rsmt"
									bw.write(informationTextArea.getText());					//get the document text and write it over
									bw.close();
								}
								
							}catch(IOException err){
								JOptionPane.showMessageDialog(null,  "ERROR!");
							}
						
						}else{
							
							try{
								//if it is not empty, we'll save it into the current directory
								BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentFileDirectory), "UTF-8"));
								bw.write(informationTextArea.getText());
								bw.close();
								
							}catch(IOException err){
								JOptionPane.showMessageDialog(null,  "ERROR!");
							}
							
						}
					
					
					
					
					
					}
				});
				mnFile.add(mntmSave);
				
				JMenuItem mntmSaveAs = new JMenuItem("Save As...");
				mntmSaveAs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser sdChooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Resumate File", "rsmt");
						sdChooser.setFileFilter(filter);
						int returnVal = sdChooser.showSaveDialog(null);
						
						try {
							
							if(returnVal == JFileChooser.APPROVE_OPTION){
								File directory = sdChooser.getCurrentDirectory();
								String path = directory.getAbsolutePath();
								String fileName = sdChooser.getSelectedFile().getName();
								if(!fileName.contains("rsmt")){
									fileName = fileName + ".rsmt";
								}
								BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "\\" + fileName)));
								currentFileDirectory = path + "\\" + fileName;
								bw.write(informationTextArea.getText());
								bw.close();
							}
						}catch(IOException err){
							JOptionPane.showMessageDialog(null, "ERROR!");
						}
						
					}
				});
				mnFile.add(mntmSaveAs);
				
				JMenuItem mntmExit = new JMenuItem("Exit");
				mntmExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selection = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to exit?", null,
								JOptionPane.YES_NO_OPTION);
						if (selection == JOptionPane.YES_OPTION) {
							System.exit(1);
						}
					}
				});
				mnFile.add(mntmExit);
				
				
				//the edit
				JMenu mnEdit = new JMenu("Edit");
				menuBar.add(mnEdit);
				
				JMenuItem mntmCut = new JMenuItem("Cut");
				mntmCut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//copy
						clipBoardData = informationTextArea.getSelectedText();					//save the text in a clipboard
						StringSelection stringSelection = new StringSelection(clipBoardData);	
						Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
						clpbrd.setContents(stringSelection, null);
						informationTextArea.replaceSelection("");								//erase the workplace
					}
				});
				mnEdit.add(mntmCut);
				
				JMenuItem mntmCopy = new JMenuItem("Copy");
				mntmCopy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clipBoardData = informationTextArea.getSelectedText();					
						StringSelection stringSelection = new StringSelection(clipBoardData);
						Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
						clpbrd.setContents(stringSelection, null);								//the selected string copies in the clipboard
					}
				});
				mnEdit.add(mntmCopy);
				
				JMenuItem mntmPaste = new JMenuItem("Paste");
				mntmPaste.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						informationTextArea.append(clipBoardData);
					}
				});
				mnEdit.add(mntmPaste);
				
				JMenuItem mntmSelectAll = new JMenuItem("Select All");
				mntmSelectAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						informationTextArea.selectAll();
					}
				});
				mnEdit.add(mntmSelectAll);
				
				
				
				//add content
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				SpringLayout sl_contentPane = new SpringLayout();
				contentPane.setLayout(sl_contentPane);
				
				informationTextArea = new JTextArea();
				sl_contentPane.putConstraint(SpringLayout.NORTH, informationTextArea, 16, SpringLayout.NORTH, contentPane);
				sl_contentPane.putConstraint(SpringLayout.WEST, informationTextArea, 31, SpringLayout.WEST, contentPane);
				sl_contentPane.putConstraint(SpringLayout.EAST, informationTextArea, 226, SpringLayout.WEST, contentPane);
				contentPane.add(informationTextArea);
				
				JTextArea aboutmeTextArea = new JTextArea();
				sl_contentPane.putConstraint(SpringLayout.SOUTH, informationTextArea, -134, SpringLayout.NORTH, aboutmeTextArea);
				sl_contentPane.putConstraint(SpringLayout.WEST, aboutmeTextArea, 17, SpringLayout.WEST, contentPane);
				sl_contentPane.putConstraint(SpringLayout.EAST, aboutmeTextArea, -15, SpringLayout.EAST, contentPane);
				sl_contentPane.putConstraint(SpringLayout.NORTH, aboutmeTextArea, 243, SpringLayout.NORTH, contentPane);
				sl_contentPane.putConstraint(SpringLayout.SOUTH, aboutmeTextArea, -10, SpringLayout.SOUTH, contentPane);
				contentPane.add(aboutmeTextArea);
		
	}
	
	
}
