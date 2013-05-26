package se.chalmers.tda367.group25.resumate.io;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

/**
 * This singleton class handles IO functions, saving and opening Documents. This
 * is done by saving each Section as a separate text document, which in turn is
 * named after the SectionType. It follows then that opening a Document is done
 * by creating a new Document, and then setting the contents of the Sections to
 * the content of the corresponding text documents.
 * 
 * @author Laszlo Sall Vesselenyi
 */
public class IOHandler {

	private static volatile IOHandler instance = new IOHandler();

	private IOHandler() {
	}

	// ---Getters--- //

	public static IOHandler getInstance() {
		return instance;
	}

	// ---IO Methods--- //

	/**
	 * Save to file. The project is saved by saving each RMText as a separate
	 * text file, and saving an RSMT file to act as a locator for opening a
	 * Document in the future. Synchronized for sake of eventual thread safety.
	 * 
	 * @param fileName
	 *            the file to save to
	 */
	public static synchronized void saveFile(String fileName,
			Map<SectionType, String> strings) throws IOException {
		File directory = new File(fileName);
		try {
			if (directory.mkdirs() || directory.exists()) {
				writeToFiles(fileName, strings);
				showFile(directory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 ** Open file. Synchronized for sake of eventual thread safety.
	 * 
	 * @param fileName
	 *            the file to open
	 * @return
	 * @throws IOException
	 */
	public static synchronized Map<SectionType, String> openFile(String fileName)
			throws IOException {
		File chosenDir = new File(fileName);

		if (chosenDir.isDirectory()) {
			readFromFiles(fileName);
		}
		throw new IOException("Not directory");
	}

	/**
	 * Writes the content from String objects stored in the Map to text files,
	 * and creates the RSMT file.
	 * 
	 * @param fileName
	 *            the directory in which to write the files
	 * @param strings
	 *            the Map with the contents
	 * @throws IOException
	 */
	private static void writeToFiles(String fileName,
			Map<SectionType, String> strings) throws IOException {

		writeSingleFile(new File(fileName + "\\Project.rsmt"),
				strings.toString());
		if (strings.containsKey(SectionType.HEADER)) {
			writeSingleFile(new File(fileName + "\\HEADER.txt"),
					strings.get(SectionType.HEADER));
		}
		if (strings.containsKey(SectionType.PERSONAL_INFO)) {
			writeSingleFile(new File(fileName + "\\PERSONAL_INFO.txt"),
					strings.get(SectionType.PERSONAL_INFO));
		}
		if (strings.containsKey(SectionType.WORK_EXPERIENCE)) {
			writeSingleFile(new File(fileName + "\\WORK_EXPERIENCE.txt"),
					strings.get(SectionType.WORK_EXPERIENCE));
		}
		if (strings.containsKey(SectionType.EDUCATION)) {
			writeSingleFile(new File(fileName + "\\EDUCATION.txt"),
					strings.get(SectionType.EDUCATION));
		}
	}

	/**
	 * Reads the content of the text files in the directory and stores them in a
	 * Map to be loaded by a Document object.
	 * 
	 * @return a Map with SectionType keys and String values to be used when
	 *         loading a Document
	 * @throws IOException
	 */
	private static Map<SectionType, String> readFromFiles(String fileName)
			throws IOException {
		File rsmtInDir = new File(fileName + "\\Project.rsmt");
		if (rsmtInDir.exists()) {
			Map<SectionType, String> strings = new HashMap<SectionType, String>(
					3);
			String data = readSingleFile(rsmtInDir);
			if (data.contains("PERSONAL_INFO")) {
				strings.put(SectionType.PERSONAL_INFO, readSingleFile(new File(
						fileName + "\\PERSONAL_INFO.txt")));
			}
			if (data.contains("WORK_EXPERIENCE")) {
				strings.put(SectionType.WORK_EXPERIENCE,
						readSingleFile(new File(fileName
								+ "\\WORK_EXPERIENCE.txt")));
			}
			if (data.contains("EDUCATION")) {
				strings.put(SectionType.EDUCATION, readSingleFile(new File(
						fileName + "\\EDUCATION.txt")));
			}
			if (data.contains("HEADER")) {
				strings.put(SectionType.HEADER, readSingleFile(new File(
						fileName + "\\HEADER.txt")));
			}
			return strings;
		}
		throw new IOException("Not project directory");
	}

	/**
	 * Performs the actual writing of a File by means of a BufferedWriter.
	 * 
	 * @throws IOException
	 */
	private static void writeSingleFile(File file, String content)
			throws IOException {
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file), Charset.forName("UTF-8")
						.newEncoder()));
		if (content != null) {
			w.write(content);
		}
		w.close();
	}

	/**
	 * Reads and returns the String content of a single file.
	 * 
	 * @param file
	 *            the file to be read
	 * @return the String content of the file
	 * @throws IOException
	 */
	private static String readSingleFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), Charset.forName("UTF-8")
						.newDecoder()));
		String content = "";
		while (br.readLine() != null) {
			content = content + br.readLine();
		}
		br.close();
		return content;
	}

	// ---Auxiliary methods--- //

	/**
	 * Shows a directory, indicated by the file parameter, using the native file
	 * explorer if supported by the current platform.
	 * 
	 * @param file
	 *            the PDF file to show
	 * @throws IOException
	 */
	private static void showFile(File file) throws IOException {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.OPEN)) {
				desktop.open(file);
			}
		}
	}
}
