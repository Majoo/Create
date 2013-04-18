package se.chalmers.tda367.group25.resumate.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import se.chalmers.tda367.group25.resumate.controllers.DocumentController;
import se.chalmers.tda367.group25.resumate.controllers.TextController;
import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Template;
import se.chalmers.tda367.group25.resumate.utils.TemplateToPanel;

public class DocumentView extends JFrame {

	private DocumentPanel documentPanel;
	private TextController txc;
	private DocumentController dc;

	public DocumentView(Document doc) {
		// The controller

		dc = new DocumentController(this, doc);
		txc = new TextController(doc);

		// Setting the frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 650);
		setTitle("ResuMate");
		documentPanel = new DocumentPanel();
		setContentPane(documentPanel);
		documentPanel.setView(this);

		// the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);

		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new DocumentView(new Document());

			}
		});

		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = JOptionPane.showConfirmDialog(null,
						"�r du s�ker p� att du vill avsluta?", null,
						JOptionPane.YES_NO_OPTION);
				if (selection == JOptionPane.YES_OPTION) {
					System.exit(1);
				}
			}
		});

	}

	public void textAction(InputMethodEvent arg0, String text) {
		txc.updateText(arg0, text);
	}

	public void changedTemplate(Template templateName) {
		dc.changedTemplate(templateName);
	}

	public void updateTextInView(Template templateName, List<String> text) {
		documentPanel.updateTextInView(text);

	}

}
