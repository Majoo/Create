package se.chalmers.tda367.group25.resumate.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.DocumentException;

import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.model.IOHandler;
import se.chalmers.tda367.group25.resumate.model.PDFHandler;
import se.chalmers.tda367.group25.resumate.utils.Labels;

/*
 * This class forwards IO assignments.
 */
public class IOController {

	public IOController() {
	}

	/**
	 * Decides which IO function to perform.
	 * 
	 * @param function
	 *            String deciding which function to perform, must always be
	 *            non-null
	 * @param jc
	 *            only necessary when exporting, printing or sending, may be
	 *            null
	 * @param doc
	 *            only necessary when saving, may be null
	 * @param path
	 *            only necessary when saving and path already exists, may be
	 *            null
	 */
	public void chooseFunction(String function, JComponent jc, Document doc,
			String path) {
		if (function.equals(Labels.SAVE_DOC)) {
			
		} else if ((function.equals(Labels.EXPORT_DOC))
				|| (function.equals(Labels.SAVE_DOC_AS))
				|| (function.equals(Labels.OPEN_DOC))
				|| (function.equals(Labels.RENAME_DOC))) {
			try {
				choosePath(jc, function, doc);
			} catch (FileNotFoundException e) {
				// Probably means that the user entered the wrong path name.
				// Thus, let them try again.
				chooseFunction(function, jc, doc, path);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				// If no file is chosen or operation is aborted, nothing happens
			}
		} else if (function.equals(Labels.PRINT_DOC)
				|| (function.equals(Labels.SEND_DOC))) {

		} else {
			System.out.println("No such command!");
		}

	}

	/**
	 * A method for choosing path and file name.
	 * 
	 * @param function
	 *            the context of the function e.g. save, save as, export as PDF
	 * @param doc
	 *            TODO
	 */
	public void choosePath(JComponent jc, String function, Document doc)
			throws FileNotFoundException, DocumentException,
			NullPointerException {

		JFileChooser chooser = new JFileChooser();

		// Depending on the desired function, different kinds of Filter are
		// required, which is why the returnFilter method is called
		chooser.setFileFilter(returnFilter(function));
		int returnVal = chooser.showSaveDialog(null);
		String filePathAndName = chooser.getCurrentDirectory().getPath() + "\\"
				+ chooser.getSelectedFile().getName();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				if (function.equals(Labels.EXPORT_DOC)) {
					PDFHandler.createPdf(jc, filePathAndName);
				} else if (function.equals(Labels.SEND_DOC)) {
					;
				} else if (function.equals(Labels.SAVE_DOC_AS)) {
					IOHandler.saveFile(filePathAndName, doc);
				} else if (function.equals(Labels.OPEN_DOC)) {
					IOHandler.openFile(filePathAndName);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns correct Filter for JFileChooser.
	 * 
	 * @param function
	 *            the context of the function e.g. save, save as, export as PDF
	 * @return Filter with the correct properties
	 */
	public FileNameExtensionFilter returnFilter(String function) {
		if (function.equals(Labels.EXPORT_DOC)) {
			return new FileNameExtensionFilter("PDF", "pdf");
		} else if (function.equals(Labels.SAVE_DOC)) {
			// RSMT = temporary file name
			return new FileNameExtensionFilter("ResuMate file", "rsmt");
		} else if (function.equals(Labels.SAVE_DOC_AS)) {
			// RSMT = temporary file name
			return new FileNameExtensionFilter("ResuMate file", "rsmt");
		}
		return null;
	}
}
