package se.chalmers.tda367.group25.resumate.utils;
import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;


public class TranslatorTest {

	@Test
	public void stringToImageTest() {
		String path = "C:\\Users\\Patricia\\Pictures\\sexIT-bilder\\DSC03953.JPG";
		BufferedImage img = Translator.stringToImage(path);
		
		assertTrue(img != null);
	}
	
	@Test
	public void templateToPanelTest() {
		TemplatePanel newTempl = Translator.templateToPanel(Template.DEF_CV);
		
		assertTrue(newTempl != null);
	}

}
