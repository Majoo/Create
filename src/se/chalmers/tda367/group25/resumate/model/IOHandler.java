package se.chalmers.tda367.group25.resumate.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComponent;

public class IOHandler {

	/**
	 * Save to file.
	 * 
	 * @param fileName
	 *            the file to save to
	 */
	public void saveFile(String fileName) {
		FileWriter w;
		try {
			w = new FileWriter(fileName);
			// textArea.write(w);
		} catch (IOException e) {
		}

	}

	/**
	 * Open file.
	 * 
	 * @param fileName
	 *            the file to open
	 */
	public void openFile(String fileName) {
		FileReader r;
		try {
			r = new FileReader(fileName);
			// textArea.read(r, null);
		} catch (IOException e) {
		}
	}

	/**
	 * Send the Document.
	 */
	public void send() {

	}

	/**
	 * Decide whether to print or export PDF.
	 * 
	 * @param jc
	 *            JComponent to print or export
	 * @param function
	 *            String deciding how to handle jc
	 */
	public void handlePdf(JComponent jc, String function) {
		if (function.equals("print"))
			print(jc);
		else if (function.equals("export"))
			exportAsPdf(jc);
	}

	/**
	 * Print the Document.
	 * 
	 * @param jc
	 *            JComponent to print
	 */
	public void print(JComponent jc) {
	}

	/**
	 * Exports JComponent representation of Document as PDF.
	 * 
	 * @param jc
	 *            JComponent to export
	 */
	public void exportAsPdf(JComponent jc) {
	}

}
