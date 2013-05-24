package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import se.chalmers.tda367.group25.resumate.utils.Labels;

/**
 * This class is the visual and graphical user interface 
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
		setTitle("ResuMate" + "- [the name of the file]");
		// Default size when not fullscreened
		setSize(840,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		// Always make it fullscreened when the program starts
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
		toolbarPanel.setToolTipText("Protip! " +
				"Don't change too much of the document!");
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
		docView.getTemplatePanel().setToolTipText("Protip!\r\n " +
				"The best way of writing a Curriculum Vitae " +
				"or Personal Letter is to make it interesting. \r\n");
		docView.setID("First DocumentView");
		docViewList.add(docView);
		tabbedPane.addTab("unsaved", null, docView, "unsaved");
		contentPane.add(tabbedPane);
		tabbedPane.setSelectedComponent(docView);

		System.out.println(getCurDocView().getID());

		// Update the frame
		this.invalidate();
		this.validate();
	}

	// Property Change-methods
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		try{
			pcs.firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(),
					arg0.getNewValue());
		} catch (NullPointerException e){
			
		}
	}

	// Getters
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

	// Setters
	/**
	 * Creates a new tab and puts a DocumentView within it. 
	 * 
	 * @param docView
	 *            the template the new DocumentView will have.
	 */
	public void newTab(DocumentView docView) {
		docViewList.add(docView);
		tabbedPane.addTab("unsaved", null, docView, "unsaved");
	}

	/**
	 * Sends the initial DocumentView to its listener(s).
	 */
	public void sendInitialDocView() {
		DocumentView docView = this.docViewList.get(0);
		pcs.firePropertyChange(Labels.SEND_INITIAL_DVIEW, docView, "first");
	}

}
