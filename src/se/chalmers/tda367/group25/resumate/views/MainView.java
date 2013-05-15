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


public class MainView extends JFrame implements MainViewInterface, PropertyChangeListener{
	private MenuBar menuBar;
	private JPanel toolbarPanel;
	private JTabbedPane tabbedPane;
	//A list of DocViews. Each one will be in an own tab.
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

		//Creating and setting backgroundpanel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		//Sorry men kan inte placera ut de vettigt så löser det med gridlayout sålänge
		contentPane.setLayout(new GridLayout(3,1));
		setContentPane(contentPane);

		//Initializing components
		menuBar = new MenuBar();
		menuBar.addPropertyChangeListener(this);
		contentPane.add(menuBar);
		
		toolbarPanel = new ToolbarPanel();
		toolbarPanel.addPropertyChangeListener(this);
		toolbarPanel.setVisible(true);
		contentPane.add(toolbarPanel);
		
		tabbedPane = new JTabbedPane();
		DocumentView docView = new DocumentView();
		//The documentview is created here and then sent to documentcontroller
		//through maincontroller.
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
		//pcs.firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(), arg0.getNewValue());


		switch (arg0.getPropertyName()) {
		case Labels.INSERT_IMAGE:
			pcs.firePropertyChange(Labels.INSERT_IMAGE, getCurDocView(), false);

			break;	
		case Labels.TEXTSIZE_CHANGED:
			/* docView??
			pcs.firePropertyChange(arg0.getPropertyName(), this.docView.getFocusCycleRootAncestor(),
					arg0.getNewValue());*/
		}

	}

	//-----GETTERS-----
	/**
	 * Get the DocView i.e. tab that is currently in focus.
	 * @return
	 * 			the DocView that is in the tab that is currently in focus.
	 */
	private DocumentView getCurDocTab() {
		// TODO Auto-generated method stub
		return null;
	}

	//-----SETTERS-----
	/**
	 * Add a new DocumentView in a new tab. Needs to know what 
	 * template the user has chosen and this is given as a parameter.
	 * @param
	 * 			the template the new DocumentView will have.
	 */
	public void newTab(TemplatePanel templatePnl){

	}
}
