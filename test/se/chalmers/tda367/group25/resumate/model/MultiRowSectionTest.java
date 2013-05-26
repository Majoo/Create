package se.chalmers.tda367.group25.resumate.model;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.Test;

import se.chalmers.tda367.group25.resumate.model.MultiRowSection;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.CV_Def;
import se.chalmers.tda367.group25.resumate.views.CV_Def2;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;


/*
 * This is a testclass for RMText and its interaction with views and controllers
 */
public class MultiRowSectionTest {
	
	static MultiRowSection t;
	static TemplatePanel p;

	@BeforeClass 
	public static void method(){
		p = new CV_Def2();
		t = new MultiRowSection();
		t.setText("This is a test");
		p.getCurrentSection().setText("This a test");
	}
	
	
	@Test
	public void testChangeFont() {	
		t.changeFont(p.getCurrentSection(), "Calibri");
		
		String modelFont = t.getFont();
		String viewFont = p.getCurrentSection().getFont().getName();
		
		assertTrue(modelFont.equals(viewFont)); 
	}
	
	@Test
	public void testChangeSize() {
		t.changeSize(p.getCurrentSection(), 15);
		
		int modelSize = t.getSize();
		int viewSize = p.getCurrentSection().getFont().getSize();
		
		assertTrue(modelSize == viewSize);
	}

	@Test
	public void testChangeText() {
		t.setText(p.getCurrentSection().getText());
		
		String modelText = t.getText();
		String viewText = p.getCurrentSection().getText();
		
		assertTrue(modelText.equals(viewText));
	}
	
	@Test
	public void testChangeColor(){
		t.changeColor(p.getCurrentSection(), Color.cyan, "Cyan");
		
		//Uses the Translator method which will also be tested.
		Color modelColor = Translator.stringToColor(t.getColor());
		Color viewColor = p.getCurrentSection().getForeground();
		
		assertTrue(modelColor.equals(viewColor));
		
	}


}
