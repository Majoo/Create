package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeListener;

/**
 * This is what you can do with a MainView. 
 * I'm not sure what that meens just yet...
 * @author Patricia
 */
public interface MainViewInterface {

	//PROPERTY-CHANGED-METHODS
	public void addPropertyChangeListener(PropertyChangeListener pcl);

	public void removePropertyChangeListener(PropertyChangeListener pcl);
}
