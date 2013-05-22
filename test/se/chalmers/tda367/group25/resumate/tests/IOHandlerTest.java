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
		String dirPath = System.getProperty("user.home") + "\\Test";

		// A File with same path as the directory that is created by the
		// saveFile method.
		File dir = new File(dirPath);
		dir.createNewFile();
		dir.setWritable(true);
		dir.delete();

		IOHandler.saveFile(dirPath, strings);

		assertTrue(dir.isDirectory());
	}

	@Test
	public void testFileCreation() throws IOException {
		Map<SectionType, String> strings = new HashMap<SectionType, String>(1);
		String dirPath = System.getProperty("user.home") + "\\Test";
		String fileName = "PERSONAL_INFO.txt";
		String filePath = dirPath + "\\" + fileName;

		strings.put(SectionType.PERSONAL_INFO, new String());
		// Just a String to make the method work.

		// A File with same path as the directory that is created by the
		// saveFile method.
		File dir = new File(dirPath);
//		dir.createNewFile();
//		dir.setWritable(true);
//		System.out.println("canWrite in Test: " + dir.canWrite());

		IOHandler.saveFile(dirPath, strings);

		File file = new File(filePath);
		assertTrue(file.exists());
	}
	
	//TODO testOpenFile()

}
