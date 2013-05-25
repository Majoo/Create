package se.chalmers.tda367.group25.resumate.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import se.chalmers.tda367.group25.resumate.utils.Labels;

/**
 * An interface to describe a MainView. 
 */
public interface MainViewInterface extends PropertyChangeListener{

	@Override
	public void propertyChange(PropertyChangeEvent e);

}
