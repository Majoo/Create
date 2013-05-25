package se.chalmers.tda367.group25.resumate.controllers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.chalmers.tda367.group25.resumate.io.IOHandler;
import se.chalmers.tda367.group25.resumate.io.PDFHandler;
import se.chalmers.tda367.group25.resumate.model.Document;
import se.chalmers.tda367.group25.resumate.utils.Labels;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

import com.itextpdf.text.DocumentException;

/**
 * This class delegates IO functions, such as saving, opening and exporting
 * Documents to the corresponding IO classes, IOHandler and PDFHandler.
 * 
 * @author Laszlo Sall Vesselenyi
 */
public class IOController {

	private PropertyChangeSupport pcs;

	private Map<SectionType, String> stringsFromFiles;

	private String recentPath;

	public IOController() {
		pcs = new PropertyChangeSupport(this);
		recentPath = System.getProperty("user.home");
	}

	/**
	 * Decides which IO function to perform.
	 * 
	 * @param function
	 *            String deciding which function to perform, must always be
	 *            non-null
	 * @param jc
	 *            only necessary when exporting, printing or sending, may be
	 *            null
	 * @param doc
	 *            only necessary when saving, may be null
	 * @param path
	 *            only necessary when saving and path already exists, may be
	 *            null
	 */
	public void chooseFunction(String function, JComponent jc, Document doc,
			String path) {

		Map<SectionType, String> strings;
		if (function.equals(Labels.SAVE_DOC)
				|| function.equals(Labels.SAVE_DOC_AS)) {
			strings = doc.getStrings();
		} else {
			strings = null;
		}

		if ((function.equals(Labels.SAVE_DOC))
				|| (function.equals(Labels.RENAME_DOC))) {
			try {
				IOHandler.saveFile(path, strings);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if ((function.equals(Labels.EXPORT_DOC))
				|| (function.equals(Labels.SAVE_DOC_AS))) {
			try {
				choosePath(jc, function, strings);
			} catch (IOException e) {
				// If incorrect file is chosen during OPEN_DOC issue warning and
				// try again.
				if (e.getMessage().equals("Not project folder")) {
					JOptionPane
							.showMessageDialog(
									null,
									"You chose a directory that is not a ResuMate project folder, try again. Hint: ResuMate project folders contain the file Project.rsmt.",
									"Invalid choice made.",
									JOptionPane.ERROR_MESSAGE);
					chooseFunction(function, jc, doc, path);
				} else {
					// Probably means that the user entered the wrong path name
					// when trying to save or export.
					JOptionPane.showMessageDialog(null,
							"You chose an invalid file or path, try again.",
							"Invalid choice made.", JOptionPane.ERROR_MESSAGE);
					chooseFunction(function, jc, doc, path);
				}
			} catch (DocumentException e) {
				// iText related exception
			} catch (NullPointerException e) {
				// If no file is chosen or operation is aborted, nothing
				// happens.
			}
		} else if (function.equals(Labels.OPEN_DOC)) {
				try {
					choosePath(jc, function, strings);
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (IOException e) {
					if (e.getMessage().equals("Not project folder")) {
						JOptionPane
								.showMessageDialog(
										null,
										"You chose a directory that is not a ResuMate project folder, try again. Hint: ResuMate project folders contain the file Project.rsmt.",
										"Invalid choice made.",
										JOptionPane.ERROR_MESSAGE);
						chooseFunction(function, jc, doc, path);
					}
				}
		} else if (function.equals(Labels.PRINT_DOC)
				|| (function.equals(Labels.SEND_DOC))) {
			// To be implemented in the future
		}
	}

	// --- IO Support Functions---//

	/**
	 * A method for choosing path and file name.
	 * 
	 * @param jc
	 * @param function
	 *            the context of the function e.g. save, save as, export as PDF
	 * @param stringsFromFiles
	 *            the Strings from the RMText instances in an instance of
	 *            Document
	 * 
	 * @throws DocumentException
	 * @throws NullPointerException
	 * @throws IOException
	 */
	private void choosePath(JComponent jc, String function,
			Map<SectionType, String> strings) throws DocumentException,
			NullPointerException, IOException {

		JFileChooser chooser = new JFileChooser(recentPath);
		setChooser(chooser, function);

		int returnVal = chooser.showDialog(null, getApproveText(function));

		String filePath = chooser.getCurrentDirectory().getPath();
		String fileName = chooser.getSelectedFile().getName();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (function.equals(Labels.EXPORT_DOC)) {
				PDFHandler.createPdf(jc, filePath + "\\" + fileName);
			} else if (function.equals(Labels.SAVE_DOC_AS)) {
				IOHandler.saveFile(filePath + "\\" + fileName, strings);
			} else if (function.equals(Labels.OPEN_DOC)) {
				stringsFromFiles = IOHandler.openFile(filePath + "\\"
						+ fileName);
			}
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			// Do nothing
		}
	}

	/**
	 * Returns correct Filter for JFileChooser.
	 * 
	 * @param function
	 *            the context of the function e.g. save, save as, export as PDF
	 * @return Filter with the correct properties
	 */
	private FileNameExtensionFilter getFilter(String function) {
		if (function.equals(Labels.EXPORT_DOC)) {
			return new FileNameExtensionFilter("PDF", "pdf");
		} else if (function.equals(Labels.SAVE_DOC_AS)) {
			return new FileNameExtensionFilter("Directories", "doc");
		} else if (function.equals(Labels.OPEN_DOC)) {
			return new FileNameExtensionFilter("Directories", "doc");
		} else {
			return null;
		}
	}

	/**
	 * Sets some properties of the JFileChooser that are dependent on the
	 * function. Mainly relevant for saving in this iteration.
	 * 
	 * @param jfc
	 *            the JFileChooser which will be set up
	 * @param function
	 *            the context of the JFileChooser
	 */
	private void setChooser(JFileChooser jfc, String function) {
		jfc.setAcceptAllFileFilterUsed(false);

		// Depending on the desired function, different kinds of Filter are
		// required, which is why the returnFilter method is called
		jfc.setFileFilter(getFilter(function));

		// When saving, only directories are relevant
		if (function.equals(Labels.SAVE_DOC_AS)
				|| function.equals(Labels.OPEN_DOC)) {
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		} else {
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		}
	}

	/**
	 * Gets the correct text for the Approve Button depending on the function
	 * being performed.
	 * 
	 * @param function
	 *            the context of the JFileChooser
	 * @return text for the Approve Button
	 */
	private String getApproveText(String function) {
		if (function.equals(Labels.SAVE_DOC_AS)) {
			return "Save";
		} else if (function.equals(Labels.OPEN_DOC)) {
			return "Open";
		} else if (function.equals(Labels.EXPORT_DOC)) {
			return "Export";
		} else {
			return null;
		}
	}

	// ---Getters--- //

	public String getRecentPath() {
		return recentPath;
	}

	public Map<SectionType, String> getStringsMap() {
		return stringsFromFiles;
	}

	// ---Setters--- //

	public void setRecentPath(String newPath) {
		this.recentPath = newPath;
	}

	public void setStringsMap(Map<SectionType, String> strings) {
		this.stringsFromFiles = strings;
	}

	// ---PropertyChanged Methods--- //

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}
}
