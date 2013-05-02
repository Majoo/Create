package se.chalmers.tda367.group25.resumate.experiment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PDFExp extends JFrame {

	private JPanel contentPane;
	private JEditorPane editorPane;
	private JEditorPane editorPane_1;
	private JPanel panel_1;

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
		setBounds(100, 100, 577, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnExportToPdf = new JButton("Export to PDF");
		btnExportToPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createPdf(false);
			}
		});
		panel.add(btnExportToPdf);

		JButton btnExportToPdfShapes = new JButton("Export to PDF with Shapes");
		btnExportToPdfShapes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createPdf(true);
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
	}

	/**
	 * Creates PDF. The boolean shapes determines whether to save the text as an
	 * image or text in the created PDF
	 * 
	 * @param shapes
	 *            if shapes is true, the text is saved as an image, if false, as
	 *            text
	 */
	public void createPdf(boolean shapes) {
		Document document = new Document();
		try {
			PdfWriter writer;
			if (shapes)
				writer = PdfWriter.getInstance(document, new FileOutputStream(
						"my_jtable_shapes.pdf"));
			else
				writer = PdfWriter.getInstance(document, new FileOutputStream(
						"my_jtable_fonts.pdf"));
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			PdfTemplate tp = cb.createTemplate(500, 500);
			Graphics2D g2;
			if (shapes)
				g2 = tp.createGraphicsShapes(500, 500);
			else
				g2 = tp.createGraphics(500, 500);
			panel_1.print(g2);
			g2.dispose();
			cb.addTemplate(tp, 30, 300);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		document.close();
	}

}