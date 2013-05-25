package se.chalmers.tda367.group25.resumate.utils;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import se.chalmers.tda367.group25.resumate.views.TemplatePanel;


public class ViewHandler {
	
	private static int isFalse = 0;
	
	/**
	 * Searches after the String input in variable text. 
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public static void findText(JTextComponent section, String input) {

		// Removes the previous highlights if there were any. 
			section.getHighlighter().removeAllHighlights();

		if (input.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Nothing to search");
			return;
		}
		/*
		 * Gets the text from the chosen editorpane and searches after the input from the beginning of the text.
		 */
		String content = section.getText();
		int start = content.indexOf(input, 0);
		int end;
		DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
				Color.YELLOW);
		int matchesFound = 0;
		boolean isSearching = true;
		
		/*
		 * Searches for the specific word.
		 * The text is found if the index of start is larger or equal to zero. The indexes of start and end it will change 
		 * so that it will be after the found word. The found word is marked by a highlighter.
		 */
		while (isSearching) {
			if (start >= 0) {
				++matchesFound;
				try {
					end = start + input.length();
					section.getHighlighter().addHighlight(start, end, painter);
					start = content.indexOf(input, end);

				} catch (BadLocationException e) {
					JOptionPane.showMessageDialog(null,
							"Error: " + e.getMessage());
				}
			} else {
				isSearching = false;
				if (matchesFound == 0) {
					isFalse++;
				} 
			}
		}
	//	JOptionPane.showMessageDialog(null, "Matches found: " + matchesFound);
	}
	
	public static void showNoMatchesPopUp(String input, int searchedComponents){
		if(isFalse == searchedComponents){
			JOptionPane.showMessageDialog(null, "'" + input
					+ "' not found.");
		}
	}
	
	
	/**
	 * Copy the text made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	public static void textCopy(JTextComponent section){
		// Copy the selected text into a clipboard.
		String clipBoardData = section.getSelectedText();
		StringSelection stringSelection = new StringSelection(clipBoardData);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		
	}
	/**
	 * Cut the text made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	public static void textCut(JTextComponent section){
		// Copy the selected text into a clipboard.
		String clipBoardData = section.getSelectedText();
		StringSelection stringSelection = new StringSelection(clipBoardData);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		// Delete
		section.replaceSelection("");
		
	}
	/**
	 * Paste the text made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	
	public static void textPaste(JTextComponent section){
			section.paste();
			
	}
	
	/**
	 * Select all the text in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	public static void selectAll(JTextComponent section){	
		section.selectAll();	
	}
	
	/**
	 * Undo's the change made in the current textarea.
	 * Only undo one character (event) at a time.
	 * @param section
	 * 			the current textarea.
	 * @param manager
	 * 			the manager which is connected to the current section
	 */
	public static void undoAction(UndoManager manager){
		try {
				// while(section.getCaret().equals(" ")){
			manager.undo();
				// }
			} catch (CannotUndoException e) {
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	/**
	 * Redo's the change made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 * @param manager
	 * 			the manager which is connected to the current section
	 */
	public static void redoAction(UndoManager manager){
		try {
			manager.redo();
		} catch (CannotRedoException e) {
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	/**
	 * Removes the border around a panel in the current document
	 * 
	 * @param p
	 * 		the template to remove the borders from.	
	 */	
	public static void removeBorder(TemplatePanel p){
		for(JComponent comp :p.getBorderedComponents())
			comp.setBorder(null);
	}
	
	/**
	 * Adds the original borders around the panel in the current document.
	 * 
	 * @param p
	 * 		the template to set the back the borders to.
	 */
	public static void setBackBorder(TemplatePanel p){
		for(JComponent comp :p.getBorderedComponents())
			comp.setBorder(BorderFactory.createDashedBorder(Color.black));
	}
	
	/*public static void changeTemplate(TemplatePanel previous, TemplatePanel current){

		String workText = previous.getWorkingExperienceText().getText();
		String persText = previous.getPersonalInfoText().getText();
		String headText = previous.getHeaderTitle().getText();
		String eduText = previous.getEducationText().getText();
		
		current.getWorkingExperienceText().setText(workText);
		current.getPersonalInfoText().setText(persText);
		current.getHeaderTitle().setText(headText);
		current.getEducationText().setText(eduText);
		
		/*System.out.println(workText);
		System.out.println(persText);
		System.out.println(headText);
		System.out.println(eduText);*/
		
	}
	
	

