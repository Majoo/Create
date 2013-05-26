package se.chalmers.tda367.group25.resumate.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.views.CV_Classy;
import se.chalmers.tda367.group25.resumate.views.CV_Def;
import se.chalmers.tda367.group25.resumate.views.PL_Def;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;

/**
 * A class that translates different components 
 */

public class Translator {

	/**
	 * Translates a an Object which is an instance of Template into its
	 * corresponding TemplatePanel.
	 * 
	 * @param o
	 *            the object to be translated
	 * @return the TemplatePanel which the template corresponds to.
	 */
	public static TemplatePanel templateToPanel(String name) {

		TemplatePanel panel = null;
		
		switch (name) {
		case "CV_Def":
			panel = new CV_Def();
			break;

		case "DEF_PL":
			panel = new PL_Def();
			break;

		case "CLASSY_CV":
			panel = new CV_Classy();
			break;

		default: // Do nothing, never invoke
		}
		return panel;
	}

	
	public static SectionType containerToSection(JTextComponent container){
		String name = container.getName();
		SectionType section = null;

		switch (name) {
		// The text fields of personal info
		case "nameField":		
		case "cityzipcodeField":		
		case "addressField":
		case "phoneField":
		case "emailField":
		case "empty1Field":
		case "empty2Field":
			section = SectionType.PERSONAL_INFO;
			break;
			
		// The info title fields of personal info	
		case "nameTitle":
		case "cityzipcodeTitle":
		case "addressTitle":
		case "phoneTitle":
		case "emailTitle":	
			section = SectionType.INFO_TITLE;
			break;
			
		// Other text fields 
		case "workExpText":
			section = SectionType.WORK_EXPERIENCE;
			break;

		case "educationText":
			section = SectionType.EDUCATION_EXPERIENCE;
			break;

		// Headers
		case "workExpHeader":
		case "educationHeader":
			section = SectionType.HEADER;
			break;
		}
		return section;
	}
	
	
	/**
	 * Translates a JTextComponent to a SectionType.
	 * 
	 * @param container
	 *            		the JTextComponent to translate
	 * @return 
	 * 					the corresponding SectionType
	 */

	public static SectionType containerToSectionType(JTextComponent container) {

		String name = container.getName();
		SectionType section = null;

		switch (name) {
		// The info titles of personal info
		case "nameTitle":
			section = SectionType.NAME_TITLE;
			break;
	
		case "cityzipcodeTitle":
			section = SectionType.CITYZIPCODE_TITLE;
			break;
			
		case "addressTitle":
			section = SectionType.ADDRESS_TITLE;
			break;
			
		case "phoneTitle":
			section = SectionType.PHONE_TITLE;
			break;
			
		case "emailTitle":
			section = SectionType.EMAIL_TITLE;
			break;
		
		// The text fields of personal info
		case "nameField":
			section = SectionType.NAME_PERSONAL;
			break;
			
		case "cityzipcodeField":
			section = SectionType.CITYZIPCODE_PERSONAL;
			break;
			
		case "addressField":
			section = SectionType.ADDRESS_PERSONAL;
			break;
			
		case "phoneField":
			section = SectionType.PHONE_PERSONAL;
			break;
			
		case "emailField":
			section = SectionType.EMAIL_PERSONAL;
			break;
			
		case "empty1Field":
			section = SectionType.EMPTY1_PERSONAL;
			break;
			
		case "empty2Field":
			section = SectionType.EMPTY2_PERSONAL;
			break;

		// Other text fields 
		case "workExpText":
			section = SectionType.WORK_EXPERIENCE;
			break;

		case "educationText":
			section = SectionType.EDUCATION_EXPERIENCE;
			break;

		// Headers
		case "workExpHeader":
			section = SectionType.WORK_HEADER;
			break;
			
		case "educationHeader":
			section = SectionType.EDU_HEADER;
			break;

		default: // Do nothing, never invoked.

		}

		return section;
	}

	public static Color stringToColor(String name) {
		Color col = null;
		switch (name) {
		case "Black":
			col = Color.BLACK;
			break;
		case "Blue":
			col = Color.BLUE;
			break;
		case "Cyan":
			col = Color.CYAN;
			break;
		case "Dark Gray":
			col = Color.DARK_GRAY;
			break;
		case "Gray":
			col = Color.GRAY;
			break;
		case "Green":
			col = Color.GREEN;
			break;
		case "Light Gray":
			col = Color.LIGHT_GRAY;
			break;
		case "Magenta":
			col = Color.MAGENTA;
			break;
		case "Orange":
			col = Color.ORANGE;
			break;
		case "Pink":
			col = Color.PINK;
			break;
		case "Red":
			col = Color.RED;
			break;
		case "White":
			col = Color.WHITE;
			break;
		case "Yellow":
			col = Color.YELLOW;
			break;

		default: // Do nothing, never invoked
		}
		return col;
	}

	/**
	 * Takes in a String that represents an image in the filesystem 
	 * and converts it to a BufferedImage.
	 * 
	 * @param filepath
	 *            the filename of the image to make a BufferedImage from
	 * @return a BufferedImage
	 */
	public static BufferedImage stringToImage(String filepath) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			System.out
					.println("Kunde inte översätta filnamn " +
							"till BufferedImage i Translator");
		}
		return img;
	}

}
