package se.chalmers.tda367.group25.resumate.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.views.MainView;


public class MainViewTest {

	@Test
	public void test() {
		MainView mv = new MainView();
		assert(mv.getCurDocView().getID() == "First DocumentView");
	}

}
