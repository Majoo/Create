package se.chalmers.tda367.group25.resumate.utils;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;

import se.chalmers.tda367.group25.resumate.model.SectionType;
import se.chalmers.tda367.group25.resumate.model.Template;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;
import se.chalmers.tda367.group25.resumate.views.concreteTemplatePanels.CV_Def;

public class Translator {
	private static ImageIO imIO;

	/**
	 * Translates a DocumentView Panel to a Template.
	 * 
	 * @param p
	 *            the Panel to translate
	 * @return the corresponding Template
	 */
	public static Template panelToTemplate(Panel p) {
		
		String name  = p.getName();
		Template template = null;
		switch(name){
		case "CV_Def":
			template = Template.DEF_CV;
			break;
		
		default: //Do nothing, never invoked.
		
		}
		return template;
		
	}
	
	/**
	 * Translates a an Object which is an instance of Template into its
	 * corresponding TemplatePanel.
	 * 
	 * @param o
	 * 		the object to be translated
	 * @return
	 * 		the TemplatePanel which the template corresponds to.
	 */
	public static TemplatePanel templateToPanel(Object o){
		
		TemplatePanel panel = null;
		Template template = null;
		if(o instanceof Template){
			template = (Template)o;
		}
		switch(template){
		
		case DEF_CV:
			panel = new CV_Def(); //It should get all the information stored from its parent.
			break;
		
		case DEF_PL:
		
			break;
		
		default: //Do nothing, never invoke
			
		}
		
		return panel;
	}
	

	/**
	 * Translates a JEditorPane to a SectionType.
	 * 
	 * @param c
	 *          the Container to translate
	 * @return 
	 * 			the corresponding SectionType
	 */

	public static SectionType containerToSectionType(JEditorPane container) {
		
		String name = container.getName();
		SectionType section = null;
		
		if(name.equals(null)){
			System.out.println("name is null");
		}
		
		switch(name){
		case "personalInfoText":
			section = SectionType.PERSONAL_INFO;
			break;
		case "workingExperienceText":
			section = SectionType.WORK_EXPERIENCE;
			break;
		case "headerTitle":
			section = SectionType.HEADER;
			break;
		default: //Do nothing, never invoked.
		
		}
		
		if(section.equals(null)){
			System.out.println("Sectiontype is null");
		}
		
		return section;
	}
	
	/**
	 * Takes in a String that represents an image in the filesystem
	 * and converts it to a BufferedImage.
	 * @param filename 
	 * 					the filename of the image to make a BufferedImage from
	 * @return a BufferedImage
	 */
	public static BufferedImage stringToImage(String filename) {
		BufferedImage img = null;
		try{
			img = imIO.read(new File(filename));
		}catch(IOException e){
			System.out.println("Kunde inte översätta filnamn till BufferedImage i Translator");
		}
		return img;
	}
	
}
