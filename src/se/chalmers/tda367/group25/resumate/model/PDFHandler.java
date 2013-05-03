package se.chalmers.tda367.group25.resumate.model;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFHandler {

	/**
	 * Creates PDF.
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
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(new File(filePathAndName)));

		document.open();
		PdfContentByte cb = writer.getDirectContent();
		PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);
		Graphics2D g2 = tp.createGraphicsShapes(panelWidth, panelHeight);
		jc.print(g2);
		g2.dispose();
		cb.addTemplate(tp, 300, 300);
		document.close();
	}

	/**
	 * Lets the user decide the path and name of the PDF, and then calls
	 * createPdf() to actually create the document.
	 * 
	 * @param jc
	 *            JComponent representation of Document to save as PDF
	 */
	public static void exportPdf(JComponent jc) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF",
				"pdf");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(null);
		String filePathAndName = chooser.getCurrentDirectory().getPath() + "\\"
				+ chooser.getSelectedFile().getName();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				createPdf(jc, filePathAndName);
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (DocumentException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
