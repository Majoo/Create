package se.chalmers.tda367.group25.resumate.views;
import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.views.MainView;


public class MainViewTest {

	@Test
	public void test() {
		MainView mv = new MainView();
		assertTrue(mv.getCurDocView().getID() == "First DocumentView");
	}

}
