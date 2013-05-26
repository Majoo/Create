package se.chalmers.tda367.group25.resumate.model;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.JTextComponent;

import se.chalmers.tda367.group25.resumate.utils.SectionType;
import se.chalmers.tda367.group25.resumate.utils.Styles;

public class SingleRowSection extends AbsTextSection {
	private Map<String, Boolean> styles = new HashMap<String, Boolean>(17);
	private Map<SectionType, String> texts;
	
	public SingleRowSection(){
		super("Tahoma","Black", 12);
		this.styles = new HashMap<String, Boolean>(3);
		this.texts = new HashMap <SectionType, String>(17);
	}
	
	public void setText(SectionType name, String text){
		texts.put(name, text);
	}
	
	public void changeFont(JTextComponent section, String font){
		super.changeFont(section, font);
		if (Styles.U) {
			changeStyle(section, "U");
		}
	}
	
	/**
	 * Replaces the a text with another
	 * 
	 * @param replace
	 *            the text to replace
	 * 
	 * @param replaceWith
	 *            the text to be replaced with
	 * 
	 * @param section
	 *            the JTextPane whose contents is to be customized
	 */
	public void replaceText(JTextComponent section, String replace,
			String replaceWith, SectionType sectionType) {
		setText(sectionType, getText(sectionType).replaceAll(replace, replaceWith));
		// Update the text in the view
		section.setText(section.getText().replaceAll(replace, replaceWith));
	}
	
	public void changeStyle(JTextComponent section, String style) {
		System.out.println("In changeStyle in SingleRow");
		Font currentFont = section.getFont();
		Font font = currentFont;

		switch (style) {
		case "B":
			if (!Styles.B) {
				font = currentFont.deriveFont(currentFont.getStyle()
						+ Font.BOLD);
			} else {
				font = currentFont.deriveFont(currentFont.getStyle()
						& ~Font.BOLD);
			}
			Styles.B = !Styles.B;
			styles.put("B", Styles.B);
			break;

		case "I":
			if (!Styles.I) {
				font = currentFont.deriveFont(currentFont.getStyle()
						+ Font.ITALIC);
			} else {
				font = currentFont.deriveFont(currentFont.getStyle()
						& ~Font.ITALIC);
			}
			Styles.I = !Styles.I;
			styles.put("I", Styles.I);
			break;

		case "U":
			Map<TextAttribute, Integer> attributes = new HashMap<TextAttribute, Integer>();
			if (!Styles.U) {
				attributes.put(TextAttribute.UNDERLINE,
						TextAttribute.UNDERLINE_ON);

			} else {
				attributes.put(TextAttribute.UNDERLINE, -1);
			}
			Styles.U = !Styles.U;
			styles.put("U", Styles.U);
			font = currentFont.deriveFont(attributes);
		}
		section.setFont(font);
	}

	public String getText(SectionType name){
		return texts.get(name);
	}

}
