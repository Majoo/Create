package se.chalmers.tda367.group25.resumate.io;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		if (directory.mkdirs() || directory.exists()) {
			writeToFiles(fileName, strings);
			showFile(directory);
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
		
		if (chosenDir.getName().contains(".rsmt")) {
			readFromFiles(fileName);
		}
		return null;
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
		if (strings.containsKey(SectionType.WORK_HEADER)) {
			writeSingleFile(new File(fileName + "\\WORK_HEADER.txt"),
					strings.get(SectionType.WORK_HEADER));
		}
		if (strings.containsKey(SectionType.EDU_HEADER)) {
			writeSingleFile(new File(fileName + "\\EDU_HEADER.txt"),
					strings.get(SectionType.EDU_HEADER));
		}
		if (strings.containsKey(SectionType.WORK_EXPERIENCE)) {
			writeSingleFile(new File(fileName + "\\WORK_EXPERIENCE.txt"),
					strings.get(SectionType.WORK_EXPERIENCE));
		}
		if (strings.containsKey(SectionType.EDUCATION_EXPERIENCE)) {
			writeSingleFile(new File(fileName + "\\EDUCATION.txt"),
					strings.get(SectionType.EDUCATION_EXPERIENCE));
		}
		if (strings.containsKey(SectionType.NAME_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\NAME.txt"),
					strings.get(SectionType.NAME_PERSONAL));
		}
		if (strings.containsKey(SectionType.ADDRESS_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\ADDRESS.txt"),
					strings.get(SectionType.ADDRESS_PERSONAL));
		}
		if (strings.containsKey(SectionType.CITYZIPCODE_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\CITYZIPCODE.txt"),
					strings.get(SectionType.CITYZIPCODE_PERSONAL));
		}
		if (strings.containsKey(SectionType.PHONE_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\PHONE.txt"),
					strings.get(SectionType.PHONE_PERSONAL));
		}
		if (strings.containsKey(SectionType.EMAIL_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\EMAIL.txt"),
					strings.get(SectionType.EMAIL_PERSONAL));
		}
		if (strings.containsKey(SectionType.EMPTY1_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\EMPTY1.txt"),
					strings.get(SectionType.EMPTY1_PERSONAL));
		}
		if (strings.containsKey(SectionType.EMPTY2_PERSONAL)) {
			writeSingleFile(new File(fileName + "\\EMPTY2.txt"),
					strings.get(SectionType.EMPTY2_PERSONAL));
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
			Map<SectionType, String> strings = new HashMap<SectionType, String>();
			File rsmt = new File(fileName);
			String data = readSingleFile(rsmt);
			File dir = rsmt.getParentFile();
			try{
			if (data.contains("WORK_HEADER")) {
				System.out.println("ay yo marco polo");
				strings.put(SectionType.WORK_HEADER, readSingleFile(new File(
						dir + "\\WORK_HEADER.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("EDU_HEADER")) {
				System.out.println("ay yo marco polo2");
				strings.put(SectionType.EDU_HEADER, readSingleFile(new File(
						dir + "\\EDU_HEADER.txt")));
			}}catch (FileNotFoundException e){
			}try{
			if (data.contains("WORK_EXPERIENCE")) {
				System.out.println("ay yo marco polo3");
				strings.put(SectionType.WORK_EXPERIENCE,
						readSingleFile(new File(dir
								+ "\\WORK_EXPERIENCE.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("EDUCATION")) {
				System.out.println("ay yo marco polo4");
				strings.put(SectionType.EDUCATION_EXPERIENCE, readSingleFile(new File(
						dir + "\\EDUCATION.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("NAME_PERSONAL")) {
				System.out.println("ay yo marco polo5");
				strings.put(SectionType.NAME_PERSONAL, readSingleFile(new File(dir
						+ "\\NAME.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("ADDRESS_PERSONAL")) {
				System.out.println("ay yo marco polo6");
				strings.put(SectionType.ADDRESS_PERSONAL, readSingleFile(new File(
						dir + "\\ADDRESS.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("CITYZIPCODE_PERSONAL")) {
				System.out.println("ay yo marco polo7");
				strings.put(SectionType.CITYZIPCODE_PERSONAL, readSingleFile(new File(
						dir + "\\CITYZIPCODE.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("PHONE_PERSONAL")) {
				System.out.println("ay yo marco polo8");
				strings.put(SectionType.PHONE_PERSONAL, readSingleFile(new File(dir
						+ "\\PHONE.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("EMAIL_PERSONAL")) {
				System.out.println("ay yo marco polo9");
				strings.put(SectionType.EMAIL_PERSONAL, readSingleFile(new File(dir
						+ "\\EMAIL.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("EMPTY1_PERSONAL")) {
				System.out.println("ay yo marco polo10");
				strings.put(SectionType.EMPTY1_PERSONAL, readSingleFile(new File(
						dir + "\\EMPTY1.txt")));
			}}catch (FileNotFoundException e){
			}
			try{
			if (data.contains("EMPTY2_PERSONAL")) {
				System.out.println("ay yo marco polo11");
				strings.put(SectionType.EMPTY2_PERSONAL, readSingleFile(new File(
						dir + "\\EMPTY2.txt")));
			}}catch (FileNotFoundException e){
				System.out.println("Exception");
			}
			System.out.println("ay yo marco polo12");
			System.out.println(strings.toString());
			return strings;
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
		String bufferedContent;
		while ((bufferedContent = br.readLine()) != null) {
			content = content + bufferedContent;
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
