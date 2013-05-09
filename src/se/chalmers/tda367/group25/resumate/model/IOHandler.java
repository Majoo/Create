package se.chalmers.tda367.group25.resumate.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	 * @throws IOException 
	 * 
	 */
	public void openFile(String fileName) throws IOException, FileNotFoundException {

		File chosenFile = new File(fileName);

		BufferedReader br = new BufferedReader(new FileReader(chosenFile));

		String data;
		while ((data = br.readLine()) != null) {

		}
		br.close();

	}

}
