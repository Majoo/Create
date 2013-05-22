package se.chalmers.tda367.group25.resumate.views;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.awt.event.ActionEvent;

import javax.naming.CannotProceedException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;


public class ViewHandler {
	/**
	 * Searches after the String input in variable text. 
	 * If it is found then the current textcontainer will mark this text.
	 * 
	 * @param input
	 *            the String which is to be found
	 */
	public static void findText(JEditorPane section, String input) {

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
					JOptionPane.showMessageDialog(null, "'" + input
							+ "' not found.");
				}
			}
		}
	//	JOptionPane.showMessageDialog(null, "Matches found: " + matchesFound);
	}
	/**
	 * Copy the text made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	public static void textCopy(JEditorPane section){
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
	public static void textCut(JEditorPane section){
		String clipBoardData = section.getSelectedText();
		StringSelection stringSelection = new StringSelection(clipBoardData);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		//delete
		section.replaceSelection("");
		
	}
	/**
	 * Paste the text made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	
	public static void textPaste(JEditorPane section){
		new StringBuffer();
		//String clipBoardData = "";
			section.paste();
			
	}
	
	/**
	 * Select all the text in the current textarea.
	 * @param section
	 * 			the current textarea.
	 */
	public static void selectAll(JEditorPane section, String selection){
			section.selectAll();
	}
	
	/**
	 * Undo's the change made in the current textarea.
	 * @param section
	 * 			the current textarea.
	 * @param manager
	 * 			the manager which is connected to the current section
	 */
	public static void undoAction(JEditorPane section, UndoManager manager){
		try {
			manager.undo();
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
	public static void redoAction(JEditorPane section, UndoManager manager){
		try {
			manager.redo();
		} catch (CannotRedoException e) {
			Toolkit.getDefaultToolkit().beep();
		}
	}
}
