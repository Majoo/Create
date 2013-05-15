package se.chalmers.tda367.group25.resumate.model;

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

public class PDFHandler {

	/**
	 * Creates PDF, using the external iText library.
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
	public static void createPdf(JComponent jc, String filePathAndName)
			throws FileNotFoundException, DocumentException {

		int panelWidth = jc.getWidth();
		int panelHeight = jc.getHeight();

		Document document = new Document();

		File file = new File(filePathAndName + ".pdf");
		
		// If a file with the same name exists, append a digit
		// indicating how many there are with the same name
		int i = 1;
		while (file.exists()) {
			file = new File(filePathAndName + "(" + i + ")" + ".pdf");
			i++;
		}

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));

		document.open();
		PdfContentByte cb = writer.getDirectContent();
		PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);
		Graphics2D g2 = tp.createGraphicsShapes(panelWidth, panelHeight);
		jc.print(g2);
		g2.dispose();
		cb.addTemplate(tp, (document.left()), (document.top() - jc.getHeight()));
		
		// If the incoming JComponent representation of a Document is larger
				// than a single PDF document, create new pages accordingly
				int delta = (int) (panelHeight - document.top());
				while (delta >= 0) {
					document.newPage();
					PdfTemplate tp2 = cb.createTemplate(panelWidth, panelHeight);
					Graphics2D g22 = tp2.createGraphicsShapes(panelWidth, panelHeight);
					jc.print(g22);
					cb.addTemplate(tp2, document.left(document.leftMargin()), document.top()-delta);
					g22.dispose();
					delta = (int) (delta - document.top());
				}
		
		document.close();
	}
}
