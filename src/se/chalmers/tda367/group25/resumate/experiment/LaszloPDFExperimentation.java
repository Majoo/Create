package se.chalmers.tda367.group25.resumate.experiment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class LaszloPDFExperimentation extends JFrame {

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
					LaszloPDFExperimentation frame = new LaszloPDFExperimentation();
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
	public LaszloPDFExperimentation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 577, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnExportToPdf = new JButton("Export to PDF");
		btnExportToPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				savePdf(false);
			}
		});
		panel.add(btnExportToPdf);

		JButton btnExportToPdfShapes = new JButton("Export to PDF with Shapes");
		btnExportToPdfShapes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				savePdf(true);
			}
		});
		panel.add(btnExportToPdfShapes);

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
						LaszloPDFExperimentation.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
	}

	/**
	 * Creates PDF. The boolean shapes determines whether to save the text as an
	 * image or text in the created PDF. Original taken from
	 * http://www.javaworld.com/javaworld/jw-12-2006/jw-1209-swing.html
	 * 
	 * @param shapes
	 *            if shapes is true, the text is saved as an image, if false, as
	 *            text
	 * @param filePathAndName
	 *            the String used to decide where the PDF file will be saved and
	 *            what its name will be
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("deprecation")
	public void createPdf(boolean shapes, String filePathAndName)
			throws FileNotFoundException, DocumentException {

		Document document = new Document();
		PdfWriter writer;

		String fileName;
		if (shapes) {
			fileName = filePathAndName + "_shapes.pdf";
			writer = PdfWriter.getInstance(document, new FileOutputStream(
					new File(fileName)));
		} else {
			fileName = filePathAndName + "_fonts.pdf";
			writer = PdfWriter.getInstance(document, new FileOutputStream(
					new File(fileName)));
		}
		
		int panelWidth = panel_1.getWidth();
		int panelHeight = panel_1.getHeight();
		
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		PdfTemplate tp = cb.createTemplate(panelWidth, panelHeight);
		Graphics2D g2;
		if (shapes)
			g2 = tp.createGraphicsShapes(panelWidth, panelHeight);
		else
			g2 = tp.createGraphics(panelWidth, panelHeight);
		panel_1.print(g2);
		g2.dispose();
		cb.addTemplate(tp, 30, 300);
		document.close();
	}

	/**
	 * Decides the path and name of the PDF, and then calls createPdf() to actually create the document.
	 * 
	 * @param shapes
	 *            if shapes is true, the text is saved as an image, if false, as
	 *            text
	 */
	public void savePdf(boolean shapes) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF",
				"pdf");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(null);
		String filePathAndName = chooser.getCurrentDirectory().getPath() + "\\"
				+ chooser.getSelectedFile().getName();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				createPdf(shapes, filePathAndName);
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (DocumentException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
