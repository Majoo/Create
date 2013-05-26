package se.chalmers.tda367.group25.resumate.io;

import java.awt.Desktop;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JComponent;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This singleton class handles exporting a document as a PDF by means of the
 * external iText library.
 * 
 * @author Laszlo Sall Vesselenyi
 */
public class PDFHandler {

	private static volatile PDFHandler instance = new PDFHandler();

	private PDFHandler() {
	}

	public static PDFHandler getInstance() {
		return instance;
	}

	/**
	 * Delegates work to correct method, depending on the function parameter.
	 * Available alternatives are Labels.EXPORT_DOC, Labels.PRINT_DOC and
	 * Labels.SEND_DOC.
	 * 
	 * @param jc
	 *            JComponent representation of Document to save as PDF
	 * @param filePathAndName
	 *            the String used to decide where the PDF file will be saved and
	 *            what its name will be
	 * @param function
	 * @throws DocumentException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static synchronized void initPdfCreation(JComponent jc,
			String filePathAndName, String function) throws DocumentException,
			IOException {

		Document document = new Document();
		
		File file = getUniqueFile(filePathAndName);
		
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		
		int panelWidth = jc.getWidth();
		int panelHeight = jc.getHeight();
		int delta = panelHeight;
		
		// If the incoming JComponent representation of a Document is higher
		// than a single PDF document, create new pages accordingly
		while (delta >= 0) {
			document.newPage();
			PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);

			// Creates graphics where text is handled as fonts instead of simple
			// graphics/shapes
			Graphics2D g2 = tp.createGraphics(panelWidth, panelHeight);
			jc.print(g2);

			cb.addTemplate(tp, 0, document.top() - delta);

			g2.dispose();
			delta = (int) (delta - document.top());
		}

		document.close();

		/*
		 * if (function.equals(Labels.EXPORT_DOC)) { createPDF(jc, file);
		 * showFile(file); } else if (function.equals(Labels.PRINT_DOC)) {
		 * printFile(file); } else if (function.equals(Labels.SEND_DOC)) {
		 * sendFile(file); }
		 */

	}

	/**
	 * Creates PDF, using the external iText library. If a document is longer
	 * than a single page, the PDF is extended.
	 * 
	 * Original taken from
	 * http://www.javaworld.com/javaworld/jw-12-2006/jw-1209-swing.html
	 * (2013-4-28)
	 * 
	 * @param jc
	 *            JComponent representation of Document to save as PDF
	 * @param file
	 *            the String used to decide where the PDF file will be saved and
	 *            what its name will be
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	private static void createPDF(JComponent jc, File file)
			throws FileNotFoundException, DocumentException {
		Document document = new Document();

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));
		PdfContentByte cb = writer.getDirectContent();

		int panelWidth = jc.getWidth();
		int panelHeight = jc.getHeight();
		int delta = panelHeight;
		document.open();
		// If the incoming JComponent representation of a Document is higher
		// than a single PDF document, create new pages accordingly
		while (delta >= 0) {
			document.newPage();
			PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);

			// Creates graphics where text is handled as fonts instead of simple
			// graphics/shapes
			Graphics2D g2 = tp.createGraphics(panelWidth, panelHeight);
			jc.print(g2);

			cb.addTemplate(tp, 0, document.top() - delta);
			// -25 instead of document.left(document.leftMargin())

			g2.dispose();
			delta = (int) (delta - document.top());
		}

		document.close();
	}

	/**
	 * Returns a File with a unique path and file name by concatenating an
	 * integer in parenthesis to the file name. The integer corresponds to how
	 * many files of the same name already exist.
	 * 
	 * @param fileName
	 *            the original path and file name
	 * @return a File with a unique path and file name
	 */
	private static synchronized File getUniqueFile(String fileName) {
		File file = new File(fileName + ".pdf");
		int i = 1;
		while (file.exists()) {
			file = new File(fileName + "(" + i + ")" + ".pdf");
			i++;
		}
		return file;
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
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.OPEN)) {
				desktop.open(file);
			}
		}
	}

	/**
	 * Prints the PDF that was temporarily created, if supported by the current
	 * platform.
	 * 
	 * @param file
	 *            the PDF file to print
	 * @throws IOException
	 */
	private static void printFile(File file) throws IOException {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.PRINT)) {
				desktop.print(file);
			}
		}
	}

	/**
	 * Opens the native email application and the folder containing the PDF to
	 * be sent as an email attachment.
	 * 
	 * @param file
	 *            the PDF to send as an email attachment
	 * @throws IOException
	 */
	private static void sendFile(File file) throws IOException {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.MAIL)) {
				desktop.mail();
				showFile(file.getParentFile());
			}
		}
	}
}