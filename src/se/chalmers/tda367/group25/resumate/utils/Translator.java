package se.chalmers.tda367.group25.resumate.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.views.CV_Classy;
import se.chalmers.tda367.group25.resumate.views.CV_Def;
import se.chalmers.tda367.group25.resumate.views.PL_Def;
import se.chalmers.tda367.group25.resumate.views.TemplatePanel;

public class Translator {

	/**
	 * Translates a DocumentView Panel to a Template.
	 * 
	 * @param name
	 *            the name of Panel to translate
	 * @return the corresponding Template
	 */
	public static Template panelToTemplate(String name) {
		Template template = null;
		switch (name) {
		case "CV_Def":
			template = Template.DEF_CV;
			break;

		case "CV_Classy":
			template = Template.CLASSY_CV;
			break;

		case "PL_Def":
			template = Template.DEF_PL;
			break;

		default: // Do nothing, never invoked.

		}
		return template;

	}

	/**
	 * Translates a an Object which is an instance of Template into its
	 * corresponding TemplatePanel.
	 * 
	 * @param o
	 *            the object to be translated
	 * @return the TemplatePanel which the template corresponds to.
	 */
	public static TemplatePanel templateToPanel(Object o) {

		TemplatePanel panel = null;
		Template template = null;
		if (o instanceof Template) {
			template = (Template) o;
		}
		System.out.println(template);

		switch (template) {

		case DEF_CV:
			panel = new CV_Def();
			break;

		case DEF_PL:
			panel = new PL_Def();
			break;

		case CLASSY_CV:
			panel = new CV_Classy();
			break;

		default: // Do nothing, never invoke

		}

		return panel;
	}

	/**
	 * Translates a JTextPane to a SectionType.
	 * 
	 * @param c
	 *            the Container to translate
	 * @return the corresponding SectionType
	 */

	public static SectionType containerToSectionType(JTextComponent container) {

		String name = container.getName();
		SectionType section = null;

		switch (name) {
		// Personal Info
		case "nameField":
		case "cityzipcodeField":
		case "addressField":
		case "phoneField":
		case "emailField":
		case "empty1Field":
		case "empty2Field":
			section = SectionType.PERSONAL_INFO;
			break;

		// Texts
		case "workingExperienceText":
			section = SectionType.WORK_EXPERIENCE;
			break;

		case "educationText":
			section = SectionType.EDUCATION;
			break;

		// Headers
		case "workExpHeader":
		case "educationHeader":
			section = SectionType.HEADER;
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
	 * Takes in a String that represents an image in the filesystem and converts
	 * it to a BufferedImage.
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
					.println("Kunde inte �vers�tta filnamn till BufferedImage i Translator");
		}
		return img;
	}

}
