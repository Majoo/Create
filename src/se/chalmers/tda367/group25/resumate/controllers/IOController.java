package se.chalmers.tda367.group25.resumate.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.chalmers.tda367.group25.resumate.io.IOHandler;
import se.chalmers.tda367.group25.resumate.io.PDFHandler;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

import com.itextpdf.text.DocumentException;

/**
 * This class delegates IO functions, such as saving, opening and exporting
 * Documents to the corresponding IO classes, IOHandler and PDFHandler.
 * 
 * @author Laszlo Sall Vesselenyi
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
	 * @param strings
	 *            only necessary when saving, may be null
	 * @param path
	 *            only necessary when saving and path already exists, may be
	 *            null
	 */
	public void chooseFunction(String function, JComponent jc,
			Map<SectionType, String> strings, String path) {
		if (function.equals(Labels.SAVE_DOC)) {
			try {
				IOHandler.saveFile(path, strings);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ((function.equals(Labels.EXPORT_DOC))
				|| (function.equals(Labels.SAVE_DOC_AS))
				|| (function.equals(Labels.OPEN_DOC))
				|| (function.equals(Labels.RENAME_DOC))) {
			try {
				choosePath(jc, function, strings);
			} catch (FileNotFoundException e) {
				// Probably means that the user entered the wrong path name.
				chooseFunction(function, jc, strings, path);
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
	 * @param jc
	 * @param function
	 *            the context of the function e.g. save, save as, export as PDF
	 * @param strings
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws NullPointerException
	 */
	public void choosePath(JComponent jc, String function,
			Map<SectionType, String> strings) throws FileNotFoundException,
			DocumentException, NullPointerException {

		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		if (function.equals(Labels.SAVE_DOC_AS)) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}

		// Depending on the desired function, different kinds of Filter are
		// required, which is why the returnFilter method is called
		chooser.setFileFilter(getFilter(function));
		int returnVal = chooser.showSaveDialog(null);
		String filePath = chooser.getCurrentDirectory().getPath();
		String fileName = chooser.getSelectedFile().getName();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				if (function.equals(Labels.EXPORT_DOC)) {
					PDFHandler.createPdf(jc, filePath + "\\" + fileName);
				} else if (function.equals(Labels.SAVE_DOC_AS)) {
					IOHandler.saveFile(filePath, strings);
				} else if (function.equals(Labels.OPEN_DOC)) {
					IOHandler.openFile(filePath);
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
	private FileNameExtensionFilter getFilter(String function) {
		if (function.equals(Labels.EXPORT_DOC)) {
			return new FileNameExtensionFilter("PDF", "pdf");
		} else if (function.equals(Labels.SAVE_DOC_AS)) {
			// RSMT = temporary file name
			return new FileNameExtensionFilter("Directory");
		} else if (function.equals(Labels.OPEN_DOC)) {
			// RSMT = temporary file name
			return new FileNameExtensionFilter("ResuMate file", "rsmt");
		} else {
			return null;
		}
	}
}
