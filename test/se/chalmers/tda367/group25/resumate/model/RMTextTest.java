package se.chalmers.tda367.group25.resumate.model;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.Test;

import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.CV_Def;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;


/*
 * This is a testclass for RMText and its interaction with views and controllers
 */
public class RMTextTest {
	
	static RMText t;
	static TemplatePanel p;

	@BeforeClass 
	public static void method(){
		p = new CV_Def();
		t = new RMText(Translator.containerToSectionType(p.getCurrentSection()));
		//t = new RMText(SectionType.PERSONAL_INFO);
		t.setText("This is a test");
		p.getCurrentSection().setText("This a test");
	}
	
	/*
	 * Invokes the method testChangeText
	 * since the function of getText() is tested there
	 */
	@Test
	public void testGetText() {
		testChangeText();
	}

	/*
	 * Invokes the method testChangeFont
	 * since the function of getFont() is tested there
	 */
	@Test
	public void testGetFont() {
		testChangeFont();
	}

	/*
	 * Invokes the method testChangeSize
	 * since the function of getSize() is tested there
	 */
	@Test
	public void testGetSize() {
		testChangeSize();
	}
	
	@Test
	public void testGetColor(){
		testChangeColor();
	}
	
	@Test
	public void testChangeFont() {	
		/*
		 * Tests by setting the the font of the current textarea by
		 * invoking the method which handles this located in RMText
		 */
//		t.changeFont(p.getCurrentSection(), "Calibri");
		// TODO
		
		String ModelFont = t.getFont();
		String ViewFont = p.getCurrentSection().getFont().getName();
		
		assertTrue(ModelFont.equals(ViewFont)); 
	}
	
	@Test
	public void testChangeSize() {
		/*
		 * Tests by setting the textsize of the current textarea by
		 * invoking the method which handles this located in RMText
		 */
//		t.changeSize(p.getCurrentSection(), 15);
		// TODO
		
		int ModelSize = t.getSize();
		int ViewSize = p.getCurrentSection().getFont().getSize();
		
		assertTrue(ModelSize == ViewSize);
	}

	@Test
	public void testReplaceText() {
		/*
		 * Tests if the text has been replaced by checking if
		 * the text in the viewed in the view and stored in the model 
		 * is the same.
		 */
//		t.replaceText(p.getCurrentSection(), "It's", "Was");
		// TODO
		String ModelText = t.getText();
		String ViewText = p.getCurrentSection().getText();
		
		assertTrue(ModelText.equals(ViewText));
	}

	@Test
	public void testChangeText() {
		/*
		 * Tests by setting the text of the current textarea by
		 * invoking the method which handles this located in RMText
		 */
		t.setText(p.getCurrentSection().getText());
		String ModelText = t.getText();
		String ViewText = p.getCurrentSection().getText();
		
		assertTrue(ModelText.equals(ViewText));
	}
	
	@Test
	public void testChangeColor(){
		/*
		 * Tests by setting the textcolor of the current textarea by
		 * invoking the method which handles this located in RMText
		 */
//		t.changeColor(p.getCurrentSection(), Color.cyan);
		
//		Color ModelColor = t.getColor();
		Color ViewColor = p.getCurrentSection().getForeground();
		// TODO
//		assertTrue(ModelColor.equals(ViewColor));
		
	}


}
