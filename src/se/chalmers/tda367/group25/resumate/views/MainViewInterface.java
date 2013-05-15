package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import se.chalmers.tda367.group25.resumate.utils.Labels;

/**
 * This is what you can do with a MainView. 
 * I'm not sure what that meens just yet...
 * @author Patricia
 */
public interface MainViewInterface extends PropertyChangeListener{

	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl);

	public void removePropertyChangeListener(PropertyChangeListener pcl);

	@Override
	public void propertyChange(PropertyChangeEvent arg0);

	/**
	 * Get the DocView i.e. tab that is currently in focus.
	 * @return
	 * 			the DocView that is in the tab that is currently in focus.
	 */
	public DocumentView getCurDocView();

	/**
	 * Add a new DocumentView in a new tab. Needs to know what 
	 * template the user has chosen and this is given as a parameter.
	 * @param
	 * 			the template the new DocumentView will have.
	 */
	public void newTab(TemplatePanel templatePnl);
}
