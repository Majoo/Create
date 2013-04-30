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
	 * Print the Document.
	 */
	public void print() {

	}
	
	/**
	 * Exports document as PDF.
	 */
	public void exportAsPDF(JComponent jc){
		
	}

}
