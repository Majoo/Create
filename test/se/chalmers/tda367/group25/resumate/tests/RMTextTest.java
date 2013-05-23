package se.chalmers.tda367.group25.resumate.tests;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.BeforeClass;
import org.junit.Test;

import se.chalmers.tda367.group25.resumate.controllers.MainController;
import se.chalmers.tda367.group25.resumate.model.RMText;
import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Styles;
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
		t = new RMText(SectionType.PERSONAL_INFO);
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
	public void testGetStyle() {

		/*
		 * Invokes the method in RMText which handles the styles
		 * and checks if the style in the view and the one stored 
		 * in the model are equal.
		 */
		t.changeStyle(p.getCurrentSection(), "B");
		
		boolean ModelStyle = t.getStyles().get("B");
		boolean ViewStyle= Styles.B;
		
		assertTrue(ModelStyle == ViewStyle);
		
		/*
		 * Change back to the original style
		 */
		t.changeStyle(p.getCurrentSection(), "B");
		
	}
	
	@Test
	public void testChangeFont() {	
		/*
		 * Tests by setting the the font of the current textarea by
		 * invoking the method which handles this located in RMText
		 */
		t.changeFont(p.getCurrentSection(), "Calibri");
		
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
		t.changeSize(p.getCurrentSection(), 15);
		
		int ModelSize = t.getSize();
		int ViewSize = p.getCurrentSection().getFont().getSize();
		
		assertTrue(ModelSize == ViewSize);
	}
	
	@Test
	public void testChangeStyle() {
		/*
		 * Tests by setting the styles in various combinations
		 * and invoking the method which handles this located
		 * in RMText
		 */
		String style = "U";
		t.changeStyle(p.getCurrentSection(), style);
		boolean isUinModel = t.getStyles().get(style);
		boolean isUinView = Styles.U;

		/*
		 * Adds the italic style to the text
		 */
		style = "I";
		t.changeStyle(p.getCurrentSection(), style);
		boolean isIinModel = t.getStyles().get(style);
		boolean isIinView = Styles.I;
		
		/*
		 * Tests if the style in the view and in the model is underlined and italic.
		 */
		assertTrue(isUinModel == true && isUinView == isUinModel);
		assertTrue(isIinModel == true && isIinView == isIinModel);
		
		
		/*
		 * Adds the underline style to the text
		 */
		style = "U";
		t.changeStyle(p.getCurrentSection(), style);
		isUinModel = t.getStyles().get(style);
		isUinView = Styles.U;
		
		/*
		 * Tests if the style in the view and in the model is still italic but not underlined.
		 */
		assertTrue(isUinModel == false && isUinView == isUinModel);
		assertTrue(isIinModel == true && isIinView == isIinModel);
		
		
		/*
		 * Adds the bold style to the text
		 */
		style = "B";
		t.changeStyle(p.getCurrentSection(), style);
		boolean isBinModel = t.getStyles().get(style);
		boolean isBinView = Styles.B;
		
		/*
		 * Tests if the style in the view and in the model is still italic, not underlined but is also bold.
		 */
		assertTrue(isBinModel == true && isBinView == isBinModel);
		assertTrue(isUinModel == false && isUinView == isUinModel);
		assertTrue(isIinModel == true && isIinView == isIinModel);

		
		/*
		 * Removes the bold style to the text
		 */
		style = "B";
		t.changeStyle(p.getCurrentSection(), style);
		isBinModel = t.getStyles().get(style);
		isBinView = Styles.B;
		
		/*
		 * Tests if the style in the view and in the model is still italic but not underlined or bold.
		 */
		assertTrue(isUinModel == false && isUinView == isUinModel);
		assertTrue(isIinModel == true && isIinView == isIinModel);
		assertTrue(isBinModel == false && isBinView == isBinModel);
	}

	@Test
	public void testReplaceText() {
		/*
		 * Tests if the text has been replaced by checking if
		 * the text in the viewed in the view and stored in the model 
		 * is the same.
		 */
		t.replaceText(p.getCurrentSection(), "It's", "Was");
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
		t.changeColor(p.getCurrentSection(), Color.cyan);
		
		Color ModelColor = t.getColor();
		Color ViewColor = p.getCurrentSection().getForeground();
		
		assertTrue(ModelColor.equals(ViewColor));
		
	}


}
