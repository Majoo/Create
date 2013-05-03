package se.chalmers.tda367.group25.resumate.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComponent;

import se.chalmers.tda367.group25.resumate.model.IOHandler;
import se.chalmers.tda367.group25.resumate.model.PDFHandler;
import se.chalmers.tda367.group25.resumate.utils.Labels;

/*
 * This class forwards IO assignments.
 */
public class IOController {

	private IOHandler ioHandler;

	public IOController() {

	}

	/**
	 * Save to file.
	 * 
	 * @param fileName
	 *            the file to save to
	 */
	public void saveFile(String fileName) {
		ioHandler.saveFile(fileName);
	}

	/**
	 * Open file.
	 * 
	 * @param fileName
	 *            the file to open
	 */
	public void openFile(String fileName) {
		ioHandler.openFile(fileName);
	}

	/**
	 * Decide whether to send, print or export PDF.
	 * 
	 * @param jc
	 *            JComponent to print or export
	 * @param function
	 *            String deciding how to handle jc
	 */
	public void handlePdf(JComponent jc, String function) {
		if (function.equals(Labels.PRINT_DOC))
			;
		else if (function.equals(Labels.EXPORT_DOC))
			PDFHandler.exportPdf(jc);
		else if (function.equals(Labels.SEND_DOC))
			;
		else
			System.out.println("No such command!");
	}
}
