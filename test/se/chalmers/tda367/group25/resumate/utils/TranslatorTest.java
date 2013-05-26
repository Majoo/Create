package se.chalmers.tda367.group25.resumate.utils;
import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.utils.Translator;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;


public class TranslatorTest {

	@Test
	public void stringToImageTest() {
		String path = "C:\\Users\\Patricia\\Pictures\\sexIT-bilder\\DSC03953.JPG";
		BufferedImage img = Translator.stringToImage(path);
		
		//tests only if it hase been instantiated
		assertTrue(img != null);
	}
	
	@Test
	public void templateToPanelTest() {
		TemplatePanel newTempl = Translator.templateToPanel("DEF_CV");
		
		//tests only if it has been instantiated 
		assertTrue(newTempl != null);
	}

	
	@Test
	public void stringToColorTest() {
		String s = "Cyan";
		Color col = Color.CYAN;
		
		Color col2 = Translator.stringToColor(s);
		
		assertTrue(col.equals(col2));
		
	}
}
