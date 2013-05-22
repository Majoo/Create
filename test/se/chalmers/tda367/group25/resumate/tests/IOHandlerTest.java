package se.chalmers.tda367.group25.resumate.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.io.IOHandler;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class IOHandlerTest {

	@Test
	public void testSaveFile() throws IOException {
		Map<SectionType, String> strings = new HashMap<SectionType, String>(1);
		String dirPath = System.getProperty("user.home") + "\\Test";
		String section = "P_I";
		String filePath = dirPath + "\\" + section + ".txt";

		strings.put(SectionType.PERSONAL_INFO, section);
		IOHandler.saveFile(dirPath, strings);

		File dir = new File(dirPath);
		File file = new File(filePath);

		assert (dir.isDirectory());
		assert (file.isFile());
	}

	@Test
	public void testOpenFile() {
		fail("Not yet implemented");
	}

}
