package se.chalmers.tda367.group25.resumate.experimentText;
import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.experimentText.*;


public class RMTextTester {
	TemplatePanelTestMain TPT = new TemplatePanelTestMain();
	RMText t = new RMText();
	TemplatePanelTest p = new TemplatePanelTest();
	
	@Test
	public void testGetText(){
		assertTrue(t.getText().equals(p.getOtherText().getText())); // The logical check
	}

	@Test
	public void testGetFont() {
		assertTrue(t.getFont().equals(p.getOtherText().getFont().getName())); // The logical check
	}

	@Test
	public void testGetSize() {
		assertTrue(t.getSize() == p.getOtherText().getFont().getSize()); // The logical check
	}

	@Test
	public void testGetStyle() {
		assertTrue(t.getStyle().equals(p.getOtherText().getFont().getStyle())); // The logical check
	}
	
	@Test
	public void testChangeFont() {	
		//testSetText();
		p.getOtherText().setText("this is a test");
		p.changeFont(p.getOtherText(), "Calibri");
		testGetFont();
	}

	@Test
	public void testChangeSize() {
		//testSetText();
		p.getOtherText().setText("this is a test");
		p.changeSize(p.getOtherText(), 15);
		testGetSize();
	}

	@Test
	public void testChangeStyle() {
		//testSetText();
		//p.getOtherText().setText("swag yolo mjau");
		//p.changeStyle(p.getOtherText(), "B");
		//testGetStyle();
	}

	@Test
	public void testReplaceText() {
		p.replaceText("is", "was", p.getOtherText());
		testSetText();
	}

	@Test
	public void testSetText() {
		p.getOtherText().setText("this is a test");
		testGetText();
	}
}
