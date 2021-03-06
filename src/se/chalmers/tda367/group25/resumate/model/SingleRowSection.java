package se.chalmers.tda367.group25.resumate.model;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

/**
 * A class which represents a section with many fields of single row text. The
 * size, font, style and color of the text section can be changed. The text is
 * stored for saving references.
 */
public class SingleRowSection extends AbsTextSection {

	private Map<SectionType, String> texts;
	private boolean B = false;
	private boolean U = false;
	private boolean I = false;

	/**
	 * Creates a new SingleRowSection with the default font, size and color.
	 */
	public SingleRowSection(int size) {
		super("Tahoma", "Black", size);
		this.texts = new HashMap<SectionType, String>(17);
	}

	/**
	 * Sets the text of the single row to the parameter text. Which single row
	 * to set is specified by the parameter name.
	 * 
	 * @param text
	 *            the text to be set
	 * 
	 * @param name
	 *            the SectionType whichs text is to be set
	 */
	public void setText(SectionType name, String text) {
		texts.put(name, text);
	}

	@Override
	public void changeFont(JTextComponent section, String font) {
		super.changeFont(section, font);
		if (U) {
			changeStyle(section, "U");
		}
	}

	/**
	 * Replace a part of a single row with the String specified. Which single
	 * row to replace in is specified by the parameter name.
	 * 
	 * @param section
	 *            the JTextComponent in which text is to be replaced
	 * 
	 * @param replace
	 *            the text to be replaced
	 * 
	 * @param replaceWith
	 *            the text to replace with
	 * 
	 * @param sectionType
	 *            the name of the single row to replaced in
	 */
	public void replaceText(JTextComponent section, String replace,
			String replaceWith, SectionType sectionType) {
		setText(sectionType,
				getText(sectionType).replaceAll(replace, replaceWith));
		// Update the text in the view
		section.setText(section.getText().replaceAll(replace, replaceWith));
	}

	/**
	 * Changes the style of the specific textarea Checks whether the current
	 * style is the one which has been chosen. If so then it will remove the
	 * specified style. Changes the style of the MutliRowSection depending on
	 * the parameter style.
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 * @param style
	 *            the style by which the section is to be customized with
	 */
	public void changeStyle(JTextComponent section, String style) {
		Font currentFont = section.getFont();
		Font font = currentFont;

		switch (style) {
		case "B":
			if (!B) {
				font = currentFont.deriveFont(currentFont.getStyle()
						+ Font.BOLD);
			} else {
				font = currentFont.deriveFont(currentFont.getStyle()
						& ~Font.BOLD);
			}
			B = !B;
			break;

		case "I":
			if (!I) {
				font = currentFont.deriveFont(currentFont.getStyle()
						+ Font.ITALIC);
			} else {
				font = currentFont.deriveFont(currentFont.getStyle()
						& ~Font.ITALIC);
			}
			I = !I;
			break;

		case "U":
			Map<TextAttribute, Integer> attributes = new HashMap<TextAttribute, Integer>();
			if (!U) {
				attributes.put(TextAttribute.UNDERLINE,
						TextAttribute.UNDERLINE_ON);

			} else {
				attributes.put(TextAttribute.UNDERLINE, -1);
			}
			U = !U;
			font = currentFont.deriveFont(attributes);
		}
		section.setFont(font);
	}

	/**
	 * Get the text of a single row by SectionType
	 * 
	 * @param name
	 *            the SectionType from which to get the text
	 * @return the text of the SectionType name
	 */
	public String getText(SectionType name) {
		return texts.get(name);
	}

}
