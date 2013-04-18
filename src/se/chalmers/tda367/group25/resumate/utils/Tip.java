package se.chalmers.tda367.group25.resumate.utils;

import java.util.HashMap;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.model.SectionType;


public class Tip {
	//Creates empty map.
	private static final int nbrOfTips = 3;
	private static final Map<SectionType,String> tips = new HashMap<SectionType,String>(nbrOfTips);
	//Fills the map with tips.
	
	
	/* Get the tip that should be associated with the section*/
	public static String getTip(SectionType secName) {
		return tips.get(secName);
	}
	
	
}
