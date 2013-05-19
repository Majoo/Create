package se.chalmers.tda367.group25.resumate.experimentText;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

/**
 * A class which represents a section with text
 * of a template.
 * 
 * @author ResuMate
 *
 */
public class RMText {

	private String text;
	private String secType;
	private String font;
	private int size;
	Map <String, Boolean> styles;

	/**
	 * Default constructor of a RMtext Section in a Document.
	 */
	public RMText() {
		this.secType = "";
		styles = new HashMap <String, Boolean>();
		styles.put("B", Styles.B);
		styles.put("I", Styles.I);
		styles.put("U", Styles.U);
	}


	/**
	 * Returns the String text from this RMText.
	 * 
	 * @return the String text from this RMText
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Returns SectionType of this RMText.
	 * 
	 * @return the SectionType of this RMText
	 */
	public String getSecType() {
		return this.secType;
	}

	/**
	 * Sets the String text to the parameter input.
	 * 
	 * @param input
	 *            the new String to which to set the String text
	 */
	public void setText(String input) {
		this.text = input;
	}
	
	/**
	 * Changes the font of the RMText depending  on the 
	 * parameter font.
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * 
	 * @param font
	 * 			the font by which the section is to be customized with
	 */
	
	public void changeFont(JEditorPane section, String font){
		Font currentFont = section.getFont();
		section.setFont(new Font(font, currentFont.getStyle(), currentFont.getSize()));
		if(Styles.U){
			changeStyle(section,"U");
		}
		this.font = font;
	}
	
	
	/**
	 * Changes the size of the RMText depending on the 
	 * parameter size.
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * @param size
	 * 			the size by which the section is to be customized with
	 */
	public void changeSize(JEditorPane section, int size){
		Font currentFont = section.getFont();
		section.setFont(currentFont.deriveFont(currentFont.getStyle(), size));
		this.size = size;
	}
	
	
	/**
	 * Changes the style of the specific textarea
	 * Checks wether the current style is the one which has been chosen.
	 * If so then it will remove the specified style.
	 * Changes the style of the RMText depending on the 
	 * parameter style.
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 * @param style
	 * 			the style by which the section is to be customized with
	 */
	
	public void changeStyle(JEditorPane section, String style){
		Font currentFont = section.getFont();
		Font font = currentFont;
		String f = null;
		
		switch(style){
		case "B":
			if(!Styles.B){	
				font = currentFont.deriveFont(currentFont.getStyle() + Font.BOLD);
				f = "<SPAN CLASS=" + "<b>" + section.getText() + "</b>";
			}else{
				font = currentFont.deriveFont(currentFont.getStyle() & ~Font.BOLD);
			}
			Styles.B = !Styles.B;
			styles.put("B", Styles.B);
			break;
		
		case "I":	
			if(!Styles.I ){	
				font = currentFont.deriveFont(currentFont.getStyle() + Font.ITALIC);
			}else{
				font = currentFont.deriveFont(currentFont.getStyle() & ~Font.ITALIC);
			}
			Styles.I = !Styles.I ;
			styles.put("I", Styles.I );
			break;
		
		case "U":
			Map  <TextAttribute, Integer> attributes = new HashMap  <TextAttribute, Integer>();
			if(!Styles.U){
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		       
			} else {
				attributes.put(TextAttribute.UNDERLINE, -1);
			}
			Styles.U = !Styles.U;
			styles.put("U", Styles.U);
	        font = currentFont.deriveFont(attributes);	
		}
		//section.setFont(font);
		String msgBuffer =new String("");
		String m = msgBuffer.concat(f);
		section.setText(m);
	}
	
	/**
	 * Replaces the a text with another
	 * 
	 * @param replace
	 * 			the text to replace
	 * 
	 * @param replaceWith
	 * 			the text to be replaced with
	 * 
	 * @param section
	 * 			the JEditorPane whose contents is to be customized
	 */
	public void replaceText(JEditorPane section, String replace, String replaceWith){
		section.setText(section.getText().replaceAll(replace, replaceWith));
		this.setText(section.getText());
	}

	
	/**
	 * Returns the font of the RMText
	 */
	public String getFont(){
		return this.font;
	}
	
	/**
	 * Returns the size of the RMText
	 */
	public int getSize(){
		return this.size;
	}
	
	/**
	 * Returns a map with the styles of the RMText
	 */
	public Map <String, Boolean> getStyles(){
		return styles;
	}
	
}