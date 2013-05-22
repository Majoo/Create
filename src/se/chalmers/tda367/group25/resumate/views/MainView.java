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
		// PropertyChangeSupport and other important stuff
		pcs = new PropertyChangeSupport(this);

		// frame
		setVisible(true);
		setTitle("ResuMate" + "- [the name of the file]");
		setSize(840,500);										//The default size when you minimize the frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		setExtendedState(JFrame.MAXIMIZED_BOTH);				//fullscreen

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
		toolbarPanel.setToolTipText("Protip! Don't change too much of the document!");
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
		layout.putConstraint(SpringLayout.SOUTH, tabbedPane, 738,
				SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, tabbedPane, 0,
				SpringLayout.EAST, menuBar);

		DocumentView docView = new DocumentView();
		docView.getTemplatePanel().setToolTipText("Protip!\r\n The best way of writing a Curriculum Vitae or Personal Letter is to make it interesting. \r\n");
		docView.setID("First DocumentView");
		docViewList.add(docView);
		tabbedPane.addTab("unsaved", null, docView, "unsaved");
		contentPane.add(tabbedPane);
		tabbedPane.setSelectedComponent(docView);

		System.out.println(getCurDocView().getID());

		this.invalidate();
		this.validate();
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
		if (!arg0.getNewValue().equals(null)) {
			pcs.firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(),
					arg0.getNewValue());
		}
	}

	// -----GETTERS-----
	/**
	 * Get the DocView in the tab that is currently in focus.
	 * 
	 * @return the DocView that is in the tab that is currently in focus.
	 */
	public DocumentView getCurDocView() {
		return (DocumentView) tabbedPane.getSelectedComponent();
	}

	// -----SETTERS-----
	/**
	 * Creates a new tab and puts a DocumentView in it. 
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
		pcs.firePropertyChange(Labels.SEND_INITIAL_DOCVIEW, docView, "first");
	}

}
