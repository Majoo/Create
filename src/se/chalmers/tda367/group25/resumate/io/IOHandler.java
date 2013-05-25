package se.chalmers.tda367.group25.resumate.io;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
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

	public static IOHandler getInstance() {
		return instance;
	}

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
				/*
				 * if (Desktop.isDesktopSupported()) { Desktop desktop =
				 * Desktop.getDesktop(); if
				 * (desktop.isSupported(Desktop.Action.OPEN)) {
				 * desktop.open(directory); } }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes the content from the RMText objects stored in the Map to text
	 * files, and creates the RSMT file.
	 * 
	 * @param fileName
	 *            the directory in which to write the files
	 * @param strings
	 *            the Map with the contents
	 * @throws IOException
	 */
	private static synchronized void writeToFiles(String fileName,
			Map<SectionType, String> strings) throws IOException {

		writeSingleFile(new File(fileName + "\\Project.rsmt"), "");
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
		if (strings.containsKey(SectionType.EMPTY)) {
			writeSingleFile(new File(fileName + "\\EMPTY.txt"),
					strings.get(SectionType.EMPTY));
		}
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
	 * Open file. Synchronized for sake of eventual thread safety.
	 * 
	 * @param fileName
	 *            the file to open
	 * @throws IOException
	 * 
	 */
	public static synchronized Map<SectionType, String> openFile(String fileName)
			throws IOException {
		System.out.println("In openFile");
		File chosenDir = new File(fileName);
		File rsmtInDir = new File(fileName + "\\Project.rsmt");

		if (chosenDir.isDirectory() && rsmtInDir.exists()) {
			System.out.println("In if-block");
			BufferedReader br = new BufferedReader(new FileReader(chosenDir));

			String data;
			while ((data = br.readLine()) != null) {

			}
			br.close();
		}
		throw new IOException("Not project folder");
	}

	/**
	 * Shows a PDF, indicated by the file parameter, using the natively
	 * associated application, if supported by the current platform.
	 * 
	 * @param file
	 *            the PDF file to show
	 * @throws IOException
	 */
	private static void showFile(File file) throws IOException {
		System.out.println("showFile");
		if (Desktop.isDesktopSupported()) {
			System.out.println("Desktop.isDesktopSupported()");
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.OPEN)) {
				System.out.println("desktop.isSupported(Desktop.Action.OPEN)");
				desktop.open(file);
			}
		}
	}
}
