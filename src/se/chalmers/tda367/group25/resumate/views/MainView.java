package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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


public class MainView extends JFrame implements MainViewInterface, PropertyChangeListener{
	private MenuBar menuBar;
	private JPanel toolbarPanel;
	private JTabbedPane docViews;
	private List<DocumentView> docViewList;

	private PropertyChangeSupport pcs;

	/**
	 * Creates MainView, the Frame of the GUI.
	 */

	public MainView() {
		// frame
		setVisible(true);
		setTitle("ResuMate" + "- [the name of the file]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// java.awt.Dimension screenSize =
		// Toolkit.getDefaultToolkit().getScreenSize(); //fullscreen???
		// setBounds(0,0,screenSize.width, screenSize.height - 42);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		//Creating and setting backgroundpanel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		//Initializing components
		menuBar = new MenuBar();
		menuBar.addPropertyChangeListener(this);
		toolbarPanel = new ToolbarPanel();
		toolbarPanel.addPropertyChangeListener(this);
		//The initial docView
		DocumentView docView = new DocumentView();
		docViews.add(docView);
		pcs.firePropertyChange(Labels.SEND_INITIAL_DOCVIEW, docView, true);
		
		//Placing components
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
				.addComponent(docView, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(toolbarPanel, GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toolbarPanel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(docView, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

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
	private DocumentView getCurDocView() {
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
