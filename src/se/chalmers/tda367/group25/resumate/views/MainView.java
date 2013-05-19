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
		// PropertyChangeSupport and other important stuff
		pcs = new PropertyChangeSupport(this);
		
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

		layout.putConstraint(SpringLayout.NORTH, tabbedPane, 6, SpringLayout.SOUTH, toolbarPanel);
		layout.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, tabbedPane, 738, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, menuBar);

		DocumentView docView = new DocumentView();
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
		System.out.println("Inne i PropertyChangeEvent i MainView");
		switch (arg0.getPropertyName()) {
		case Labels.INSERT_IMAGE:
			// arg0.getOldValue() is the path of the jpg/gif-file
			// getCurDocView() returns the documentView in the tab that is in focus.
			pcs.firePropertyChange(Labels.INSERT_IMAGE, arg0.getOldValue(),
					getCurDocView());

			break;
		// Text handling:
		case Labels.TEXT_ENTERED:
		case Labels.TEXTFONT_CHANGED:
		case Labels.TEXTSIZE_CHANGED:
		case Labels.TEXTSTYLE_CHANGED:
		case Labels.TEXT_REPLACED:
			
			System.out.println("Switch in MainView text");
			
			//The current section is given from the template which listens to its components
			JEditorPane currentSection =  getCurDocView().getTemplatePanel().getCurrentSection();
			
			if(!currentSection.equals(null) && !arg0.getNewValue().equals(null)){
				System.out.println("Fire text");
				pcs.firePropertyChange(arg0.getPropertyName(), currentSection, arg0.getNewValue());
				System.out.println("Text fired");
			}
			break;
			
		case Labels.TEMPLATE_CHANGED:
			
			pcs.firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(), arg0.getNewValue());
			
		default: //Do nothing
			break;
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
	 * Add a new DocumentView in a new tab. Needs to know what template the user
	 * has chosen and this is given as a parameter.
	 * 
	 * @param the
	 *            template the new DocumentView will have.
	 */
	public void newTab(DocumentView docView) {
		docViewList.add(docView);
		tabbedPane.addTab("unsaved", null, docView, "unsaved");
	}
	
	/**
	 * Sends the initial DocumentView to DocumentController through MainController.
	 */
	public void sendInitialDocView(){
		DocumentView docView = this.docViewList.get(0);
		pcs.firePropertyChange(Labels.SEND_INITIAL_DOCVIEW, docView, "first");
		System.out.println("Last in sendInitialDocView() i.e. message sent to MC");
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
