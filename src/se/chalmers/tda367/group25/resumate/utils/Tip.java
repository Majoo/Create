package se.chalmers.tda367.group25.resumate.utils;

import java.util.HashMap;
import java.util.Map;

//TODO later
public class Tip {
	//Creates empty map.
	private static final int nbrOfTips = 3;
	private static final Map<SectionName,String> tips = new HashMap<SectionName,String>(nbrOfTips);
	//Fills the map with tips.
	
	
	public static String getTip(SectionName secName) {
		return tips.get(secName);
	}
	
	
}
