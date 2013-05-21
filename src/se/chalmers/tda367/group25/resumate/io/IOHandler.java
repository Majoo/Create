package se.chalmers.tda367.group25.resumate.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

/**
 * This class handles IO functions, saving and opening Documents. This is done
 * by saving each Section as a separate text document, which in turn is named
 * after the SectionType. It follows then that opening a Document is done by
 * creating a new Document, and then setting the contents of the Sections to the
 * content of the corresponding text documents.
 * 
 * @author Laszlo Sall Vesselenyi
 * @author Danny Lam
 */
public class IOHandler {

	/**
	 * Save to file.
	 * 
	 * @param fileName
	 *            the file to save to
	 */
	public static void saveFile(String fileName, Map<SectionType, String> strings)
			throws IOException {
		File directory = new File(fileName);
		// Create directory for RSMT files
		if (directory.mkdirs()) {
			// Create all files in RSMT "project", i.e., the files corresponding
			// the instances of RMText in a Document, by doing the following:
			//
			// Get the map of RMText Sections from the Document to be saved.
			// Map map = doc.getRMTextMap();
			// For each existing RMText, save a text document.
			// for(int i = 0; i < map.size();i++){
			FileWriter w = new FileWriter(fileName + "//"
					+ "The label of the current RMText goes here");
			// }
			// Create .RSMT file in the folder to make
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
	public static void openFile(String fileName) throws IOException,
			FileNotFoundException {

		File chosenFile = new File(fileName);

		BufferedReader br = new BufferedReader(new FileReader(chosenFile));

		String data;
		while ((data = br.readLine()) != null) {

		}
		br.close();

	}

}
