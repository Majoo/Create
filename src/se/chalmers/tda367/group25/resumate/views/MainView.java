package se.chalmers.tda367.group25.resumate.views;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import com.itextpdf.awt.geom.Dimension;

import se.chalmers.tda367.group25.resumate.utils.Labels;

/**
 * This class represents all the visual and graphical user interface 
 * of the frame, panels and toolbar.
 */
public class MainView extends JFrame implements MainViewInterface {
	private MenuBar menuBar;
	private ToolbarPanel toolbarPanel;
	private JTabbedPane tabbedPane;

	// A list of DocViews. 
	// Each one will be in an own tab.
	private List<DocumentView> docViewList = new ArrayList<DocumentView>(20);
	private PropertyChangeSupport pcs;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */

	public MainView() {
		// PropertyChangeSupport
		pcs = new PropertyChangeSupport(this);

		// The frame
		setVisible(true);
		setTitle("ResuMate" + " - your best friend in job hunting.");
		// Default size when not maximized
		setSize(840,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		// Always make it maximized when the program starts
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Creating and setting background panel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		// Initializing components
		menuBar = new MenuBar();
		menuBar.addPropertyChangeListener(this);
		
		// Set the layout of the components
		SpringLayout spLayout = new SpringLayout();
		spLayout.putConstraint(SpringLayout.NORTH, menuBar, 
				0, SpringLayout.NORTH, contentPane);
		spLayout.putConstraint(SpringLayout.WEST, menuBar, 
				0, SpringLayout.WEST, contentPane);
		spLayout.putConstraint(SpringLayout.SOUTH, menuBar, 
				26, SpringLayout.NORTH, contentPane);
		spLayout.putConstraint(SpringLayout.EAST, menuBar, 
				1280, SpringLayout.WEST, contentPane);
		contentPane.setLayout(spLayout);
		contentPane.add(menuBar);

		toolbarPanel = new ToolbarPanel();
		toolbarPanel.setToolTipText("<html><b>Protip!</b><br> " +
				"Don't change too much of the document!</html>");
		spLayout.putConstraint(SpringLayout.NORTH, toolbarPanel, 
				6, SpringLayout.SOUTH, menuBar);
		spLayout.putConstraint(SpringLayout.WEST, toolbarPanel, 
				0, SpringLayout.WEST, contentPane);
		spLayout.putConstraint(SpringLayout.SOUTH, toolbarPanel, 
				111, SpringLayout.NORTH, contentPane);
		spLayout.putConstraint(SpringLayout.EAST, toolbarPanel, 
				1280, SpringLayout.WEST, contentPane);
		toolbarPanel.addPropertyChangeListener(this);
		toolbarPanel.setVisible(true);
		contentPane.add(toolbarPanel);
		
		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		
		spLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 6,
				SpringLayout.SOUTH, toolbarPanel);
		spLayout.putConstraint(SpringLayout.WEST, tabbedPane, 0,
				SpringLayout.WEST, contentPane);
		spLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 738,
				SpringLayout.NORTH, contentPane);
		spLayout.putConstraint(SpringLayout.EAST, tabbedPane, 0,
				SpringLayout.EAST, menuBar);

		DocumentView docView = new DocumentView();
		docView.setToolTipText("<html><b>Protip!</b><br> " +
				"Open new tabs to work with seperate CV's and PL's!</html>");
		docViewList.add(docView);
		
		tabbedPane.setSize(599, 1000);
		tabbedPane.addTab("unsaved", null, docView, "unsaved");
		ButtonTabClose ctb = new ButtonTabClose(tabbedPane);
		tabbedPane.setTabComponentAt(0, ctb);
		ctb.addPropertyChangeListener(this);
		contentPane.add(tabbedPane);
		tabbedPane.setSelectedComponent(docView);
		pcs.firePropertyChange(Labels.UPDATE_INITIAL_TOOLBAR, false, true);

		// Update the frame
		this.invalidate();
		this.validate();
	}

	//-----PropertyChanged-Methods------
	/**
	 * Adds a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be registered
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes a propertychange listnener to this class.
	 * @param pcl
	 * 			the listener to be unregistered
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}

	/**
	 * Fires the propertychange event further to the main controller
	 * where the events are to be handled.
	 * 
	 * @param arg0
	 * 		the source of the event
	 * 		
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		try{
			pcs.firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(),
					arg0.getNewValue());
		} catch (NullPointerException e){
			System.out.println("Caught NullPointerException " +
					"in MainViews propertyChange");
		}
	}

	//-----Getters------
	/**
	 * Get the DocView in the tab that is currently in focus.
	 * 
	 * @return 
	 * 		the DocView that is in the tab that is currently in focus.
	 */
	public DocumentView getCurDocView() {
		return (DocumentView) tabbedPane.getSelectedComponent();
	}
	/**
	 * Get the ToolbarPanel in the tab that is currently in focus.
	 * 
	 * @return 
	 * 		the toolbarPanel that is in the tab that is currently in focus.
	 */
	public ToolbarPanel getToolbarPanel(){
		return toolbarPanel;
	}

	//----Setters------
	/**
	 * Creates a new tab and puts a DocumentView within it. 
	 * @param docView
	 *            the template the new DocumentView will have.
	 */
	public void newTab(DocumentView docView, String name) {
		docViewList.add(docView);
		tabbedPane.addTab(name, null, docView, "unsaved");
		ButtonTabClose ctb = new ButtonTabClose(tabbedPane);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(docView), ctb);
		ctb.addPropertyChangeListener(this);		
	}
	
	/**
	 * Creates a new tab with the default template 
	 */
	public void newTab(String name) {
		DocumentView docView = new DocumentView();
		this.newTab(docView, name);
	}

	/**
	 * Sends the initial DocumentView to its listener(s).
	 */
	public void sendInitialDocView() {
		DocumentView docView = this.docViewList.get(0);
		pcs.firePropertyChange(Labels.SEND_INITIAL_DVIEW, docView, 0);
	}

}
