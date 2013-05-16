package se.chalmers.tda367.group25.resumate.experiment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("serial")
public class PDFExp extends JFrame {

	private JPanel contentPane;
	private JEditorPane editorPane;
	private JEditorPane editorPane_1;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDFExp frame = new PDFExp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PDFExp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 495, 2000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnExportToPdf = new JButton("Export to PDF");
		btnExportToPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportPdf(panel_1);
			}
		});
		panel.add(btnExportToPdf);

		JButton btnBeep = new JButton("Beep");
		btnBeep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Toolkit.getDefaultToolkit().beep();
			}
		});
		panel.add(btnBeep);

		panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);

		editorPane_1 = new JEditorPane();
		panel_1.add(editorPane_1, BorderLayout.SOUTH);
		editorPane = new JEditorPane();
		panel_1.add(editorPane, BorderLayout.NORTH);

		lblNewLabel = new JLabel();
		lblNewLabel
				.setIcon(new ImageIcon(
						PDFExp.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
	}

	/**
	 * Creates PDF.
	 * 
	 * Original taken from
	 * http://www.javaworld.com/javaworld/jw-12-2006/jw-1209-swing.html
	 * (2013-4-29)
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
	public void createPdf(JComponent jc, String filePathAndName)
			throws FileNotFoundException, DocumentException {

		int panelWidth = jc.getWidth();
		int panelHeight = jc.getHeight();

		Document document = new Document();

		File file = new File(filePathAndName + ".pdf");
		int i = 1;
		while (file.exists()) {
			file = new File(filePathAndName + "_" + i + ".pdf");
			i++;
		}

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(file));

		document.open();
		System.out.print(document.rightMargin()-document.leftMargin());
		PdfContentByte cb = writer.getDirectContent();
		PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);
		Graphics2D g2 = tp.createGraphicsShapes(panelWidth, panelHeight);
		jc.print(g2);
		cb.addTemplate(tp, document.left(document.leftMargin()), document.top()
				- panelHeight);
		g2.dispose();

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

	/**
	 * Lets the user decide the path and name of the PDF, and then calls
	 * createPdf() to actually create the document.
	 * 
	 * @param jc
	 *            JComponent representation of Document to save as PDF
	 */
	public void exportPdf(JComponent jc) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF",
				"pdf");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filePathAndName = chooser.getCurrentDirectory().getPath()
					+ "//" + chooser.getSelectedFile().getName();
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
