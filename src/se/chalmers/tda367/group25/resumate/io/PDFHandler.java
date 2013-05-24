package se.chalmers.tda367.group25.resumate.io;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JComponent;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This class handles exporting a document as a PDF.
 * 
 * @author Laszlo Sall Vesselenyi
 */
public class PDFHandler {

	private static volatile PDFHandler instance = null;

	private PDFHandler() {
	}

	public static PDFHandler getInstance() {
		return instance;
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
	 * @param filePathAndName
	 *            the String used to decide where the PDF file will be saved and
	 *            what its name will be
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("deprecation")
	public static synchronized void createPdf(JComponent jc,
			String filePathAndName) throws FileNotFoundException,
			DocumentException {

		int panelWidth = jc.getWidth();
		int panelHeight = jc.getHeight();

		Document document = new Document();

		int a = (int) (document.leftMargin() + document.rightMargin() - panelWidth);

		File file = getUniqueFile(filePathAndName);

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));

		document.open();
		PdfContentByte cb = writer.getDirectContent();

		// If the incoming JComponent representation of a Document is larger
		// than a single PDF document, create new pages accordingly
		int delta = panelHeight;
		while (delta >= 0) {
			document.newPage();
			PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);

			// Creates graphics where text is handled as fonts instead of simple
			// graphics
			Graphics2D g2 = tp.createGraphics(panelWidth, panelHeight);
			jc.print(g2);

			cb.addTemplate(tp, -25, document.top() - delta); // 0 = document.left(document.leftMargin())
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
}
