package se.chalmers.tda367.group25.resumate.controllers;
import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.utils.Labels;


public class MainControllerTest {

	@Test
	public void delegateTest() {
		assertTrue(Labels.CROP_IMAGE.contains("IMAGE"));
		
	}

}