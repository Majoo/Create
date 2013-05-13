import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.views.ConcreteCVPanel;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;


public class RMTextTest {
	RMText t = new RMText();
	TemplatePanel p = new ConcreteCVPanel();
	
	//add some things first heree
	
	@Test
	public void testGetText() {
		//Need to store text first, now its null thus its equal.
		assertTrue(t.getText().equals(p.getOtherText())); // The logical check
	}

	@Test
	public void testGetFont() {
		//Need to store a changed font first, now its null thus its equal.
		assertTrue(t.getFont().equals(p.getOtherText().getFont())); // The logical check
	}

	@Test
	public void testGetSize() {
		//Need to store a changed size first, now its null thus its equal.
		assertTrue(t.getSize() == (p.getOtherText().getFont().getSize())); // The logical check
	}

	@Test
	public void testGetStyle() {
		//Need to store a changed style first, now its null thus its equal.
		//assertTrue(t.getStyle().equals(p.getOtherText().getFont().getStyle())); // The logical check
	}

}
