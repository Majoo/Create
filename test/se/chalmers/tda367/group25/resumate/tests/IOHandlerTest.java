package se.chalmers.tda367.group25.resumate.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.io.IOHandler;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class IOHandlerTest {

	@Test
	public void testFolderCreation() throws IOException {
		Map<SectionType, String> strings = new HashMap<SectionType, String>(1);
		String dirPath = System.getProperty("user.home")
				+ "\\testFolderCreation";

		// A File with same path as the directory that is created by the
		// saveFile method.
		File dir = new File(dirPath);

		// If a directory of that name already exists, choose another name
		String newDirPath = dirPath;
		int i = 1; // Used for finding correct directory
		while (dir.exists()) {
			newDirPath = dirPath + "(" + i + ")";
			dir = new File(newDirPath);
			i++;
		}
		if (i > 1) {
			dirPath = newDirPath;
		}

		IOHandler.saveFile(dirPath, strings);

		assertTrue(dir.isDirectory());
	}

	@Test
	public void testFileCreation() throws IOException {
		Map<SectionType, String> strings = new HashMap<SectionType, String>(1);
		String dirPath = System.getProperty("user.home") + "\\testFileCreation";

		// A File with same path as the directory that is created by the
		// saveFile method.
		File dir = new File(dirPath);

		// If a directory of that name already exists, choose another name
		String newDirPath = dirPath;
		int i = 1; // Used for finding correct directory
		while (dir.exists()) {
			newDirPath = dirPath + "(" + i + ")";
			dir = new File(newDirPath);
			i++;
		}
		if (i > 1) {
			dirPath = newDirPath;
		}

		String fileName = "PERSONAL_INFO.txt";

		strings.put(SectionType.PERSONAL_INFO, new String());
		// Just a String to make the method work.

		IOHandler.saveFile(dirPath, strings);

		String filePath = dirPath + "\\" + fileName;
		File file = new File(filePath);

		assertTrue(file.exists());
	}

	/* TODO
	 * @Test public void testOpenFile() throws IOException { Map<SectionType,
	 * String> strings = new HashMap<SectionType, String>(1); String dirPath =
	 * System.getProperty("user.home") + "\\testOpenCreation";
	 * 
	 * // A File with same path as the directory that is created by the //
	 * saveFile method. File dir = new File(dirPath);
	 * 
	 * // If a directory of that name already exists, choose another name String
	 * newDirPath = dirPath; int i = 1; // Used for finding correct directory
	 * while (dir.exists()) { newDirPath = dirPath + "(" + i + ")"; dir = new
	 * File(newDirPath); i++; } if (i > 1) { dirPath = newDirPath; }
	 * 
	 * String fileName = "PERSONAL_INFO.txt"; String content = "Content";
	 * 
	 * strings.put(SectionType.PERSONAL_INFO, content);
	 * 
	 * IOHandler.saveFile(dirPath, strings);
	 * 
	 * //TODO openFile in IOHandler }
	 */

}
