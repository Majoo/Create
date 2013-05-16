package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.itextpdf.awt.geom.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import java.awt.CardLayout;

public class MainView extends JFrame implements MainViewInterface {
	private MenuBar menuBar;
	private JPanel toolbarPanel;
	private JTabbedPane tabbedPane;
	// A list of DocViews. Each one will be in an own tab.
	private List<DocumentView> docViewList = new ArrayList<DocumentView>(20);

	private PropertyChangeSupport pcs;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */

	public MainView() {
		// frame
		setVisible(true);
		setTitle("ResuMate" + "- [the name of the file]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Creating and setting backgroundpanel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		// Initializing components
		menuBar = new MenuBar();
		menuBar.addPropertyChangeListener(this);

		// Set the layout of the components
		SpringLayout layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, menuBar, 0,
				SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST,
				contentPane);
		layout.putConstraint(SpringLayout.SOUTH, menuBar, 26,
				SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, menuBar, 1280,
				SpringLayout.WEST, contentPane);
		contentPane.setLayout(layout);
		contentPane.add(menuBar);

		toolbarPanel = new ToolbarPanel();
		layout.putConstraint(SpringLayout.NORTH, toolbarPanel, 6,
				SpringLayout.SOUTH, menuBar);
		layout.putConstraint(SpringLayout.WEST, toolbarPanel, 0,
				SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, toolbarPanel, 111,
				SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, toolbarPanel, 1280,
				SpringLayout.WEST, contentPane);
		toolbarPanel.addPropertyChangeListener(this);
		toolbarPanel.setVisible(true);
		contentPane.add(toolbarPanel);

		tabbedPane = new JTabbedPane();
		layout.putConstraint(SpringLayout.NORTH, tabbedPane, 6,
				SpringLayout.SOUTH, toolbarPanel);
		layout.putConstraint(SpringLayout.WEST, tabbedPane, 0,
				SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, tabbedPane, 588,
				SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, tabbedPane, 0,
				SpringLayout.EAST, menuBar);
		DocumentView docView = new DocumentView();
		// The documentview is created here and then sent to documentcontroller
		// through maincontroller.
		pcs.firePropertyChange(Labels.SEND_INITIAL_DOCVIEW, docView, "first");
		docViewList.add(docView);
		tabbedPane.addTab("unsaved", null, docView, "unsaved");
		contentPane.add(tabbedPane);

		// PropertyChangeSupport and other important stuff
		pcs = new PropertyChangeSupport(this);
	}

	// PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		/*
		 * By firing the another property change here with the same information
		 * (nothing will be lost) as the argument. he event handling will be
		 * sent to the class which is listening to this class, namely, the
		 * MainController. There the event will switch depending on the label.
		 */
		// pcs.firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(),
		// arg0.getNewValue());

		switch (arg0.getPropertyName()) {
		case Labels.INSERT_IMAGE:
			// arg0.getOldValue() is the string representation of the file
			// the user chose to upload.
			pcs.firePropertyChange(Labels.INSERT_IMAGE, arg0.getOldValue(),
					getCurDocView());

			break;
		// Text handling:
		case Labels.TEXT_ENTERED:
		case Labels.TEXTFONT_CHANGED:
		case Labels.TEXTSIZE_CHANGED:
		case Labels.TEXTSTYLE_CHANGED:
		case Labels.TEXT_REPLACED:
			
			/* Need to get the focused texteditor and not the focused component
			 * (since it will be the one which sent the event here).*/
			 //pcs.firePropertyChange(arg0.getPropertyName(), getCurDocView().getTemplatePanel(), arg0.getNewValue());
			 

		}

	}

	// -----GETTERS-----
	/**
	 * Get the DocView i.e. tab that is currently in focus.
	 * 
	 * @return the DocView that is in the tab that is currently in focus.
	 */
	public DocumentView getCurDocView() {
		return (DocumentView) tabbedPane.getTabComponentAt(tabbedPane
				.getSelectedIndex());
	}

	// -----SETTERS-----
	/**
	 * Add a new DocumentView in a new tab. Needs to know what template the user
	 * has chosen and this is given as a parameter.
	 * 
	 * @param the
	 *            template the new DocumentView will have.
	 */
	public void newTab(TemplatePanel templatePnl) {
		DocumentView newDocView = new DocumentView(templatePnl);
		docViewList.add(newDocView);
		tabbedPane.addTab("unsaved", null, newDocView, "unsaved");
	}

	/**
	 * Update the DocumentView with the Image in filesystem that has the
	 * filename given as parameter.
	 * 
	 * @param docView
	 *            - the DocumentView to upload the image in
	 * @param filename
	 *            - the filename of the Image to be uploaded
	 */
	public void setImage(DocumentView docView, String filename) {
		// Göra en BufferedImage av filnamnet

		// get the TemplatePanel of the docView
		// invoke the setImage-method
	}
}
