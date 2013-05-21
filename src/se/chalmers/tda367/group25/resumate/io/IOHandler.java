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
	 * Save to file. The project is saved by saving each RMText as a separate
	 * text file, and saving an RSMT file to act as a locator for opening a
	 * Document in the future.
	 * 
	 * @param fileName
	 *            the file to save to
	 */
	public static synchronized void saveFile(String fileName,
			Map<SectionType, String> strings) throws IOException {
		File directory = new File(fileName);
		// Create directory for RSMT files
		if (directory.mkdirs()) {

			// Create all files in RSMT "project", i.e., the files corresponding
			// the instances of RMText in a Document, by doing the following:
			//
			// Get the map of RMText Sections from the Document to be saved.
			// For each existing RMText, save a text file.
			FileWriter w;
			if (strings.containsKey(SectionType.HEADER)) {
				w = new FileWriter(fileName + "\\HEADER.txt");
				w.write(strings.get(SectionType.HEADER));
			}
			if (strings.containsKey(SectionType.PERSONAL_INFO)) {
				w = new FileWriter(fileName + "\\PERSONAL_INFO.txt");
				w.write(strings.get(SectionType.PERSONAL_INFO));
			}
			if (strings.containsKey(SectionType.WORK_EXPERIENCE)) {
				w = new FileWriter(fileName + "\\WORK_EXPERIENCE.txt");
				w.write(strings.get(SectionType.WORK_EXPERIENCE));
			}
			if (strings.containsKey(SectionType.EMPTY)) {
				w = new FileWriter(fileName + "\\EMPTY.txt");
				w.write(strings.get(SectionType.EMPTY));
			}
			w = new FileWriter(fileName + "\\Project.rsmt");

			w.close();
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
	public static synchronized void openFile(String fileName)
			throws IOException, FileNotFoundException {

		File chosenFile = new File(fileName);

		BufferedReader br = new BufferedReader(new FileReader(chosenFile));

		String data;
		while ((data = br.readLine()) != null) {

		}
		br.close();

	}

}
