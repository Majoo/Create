
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.chalmers.tda367.group25.resumate.experimentText.*;

/*
 * This is a testclass for RMText and its interaction with TemplatePanelTest
 */

public class RMTextTester {
	static RMText t;
	static TemplatePanelTest p;
	
	@BeforeClass 
	public static void method(){
		p = new TemplatePanelTest();
		TextController tc = new TextController();
		tc.getRMText().setText("This a test");
		t = tc.getRMText();
		p.addObserver(tc);
	}
	
	/*
	 * Invokes the method testChangeText
	 * since the function of getText() is tested there
	 */
	@Test
	public void testGetText(){
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
	public void testGetStyle() {
		p.changeStyle(p.getTextArea(), "B");
		
		boolean ModelStyle = t.getStyles().get("B");
		boolean ViewStyle= Styles.B;
		
		assertTrue(ModelStyle == ViewStyle);
		/*
		 * Change back to the original style
		 */
		p.changeStyle(p.getTextArea(), "B");
		
	}
	
	@Test
	public void testChangeFont() {	
		p.changeFont(p.getTextArea(), "Calibri");
		
		String ModelFont = t.getFont();
		String ViewFont = p.getTextArea().getFont().getName();
		
		assertTrue(ModelFont.equals(ViewFont)); 
	}

	@Test
	public void testChangeSize() {
		p.changeSize(p.getTextArea(), 15);
		int ModelSize = t.getSize();
		int ViewSize = p.getTextArea().getFont().getSize();
		
		assertTrue(ModelSize == ViewSize);
	}

	@Test
	public void testChangeStyle() {
		/*
		 * Testing by setting the styles in various combinations
		 */
		String style = "U";
		p.changeStyle(p.getTextArea(), style);
		boolean isUinModel = t.getStyles().get(style);
		boolean isUinView = Styles.U;

		style = "I";
		p.changeStyle(p.getTextArea(), style);
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
		p.changeStyle(p.getTextArea(), style);
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
		p.changeStyle(p.getTextArea(), style);
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
		p.changeStyle(p.getTextArea(), style);
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
		p.getTextArea().setText("It's a test");
		p.replaceText("It's", "was", p.getTextArea());
		String ModelText = t.getText();
		String ViewText = p.getTextArea().getText();
		
		assertTrue(ModelText.equals(ViewText));
	}

	@Test
	public void testChangeText() {
		p.getTextArea().setText("This is a test");
		p.changeText(p.getTextArea());
		String ModelText = t.getText();
		String ViewText = p.getTextArea().getText();
		
		assertTrue(ModelText.equals(ViewText));
	}
}
