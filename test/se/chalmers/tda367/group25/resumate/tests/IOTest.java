package se.chalmers.tda367.group25.resumate.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.io.IOHandler;
import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class IOTest {

	private Map<SectionType, String> strings = new HashMap<SectionType, String>(5);
		
	@Test
	public void saveTest() throws IOException {
	
		strings.put(SectionType.PERSONAL_INFO, "P_I");
		IOHandler.saveFile(System.getProperty("user.home"), strings);
		fail("Not yet implemented");
	}

}
