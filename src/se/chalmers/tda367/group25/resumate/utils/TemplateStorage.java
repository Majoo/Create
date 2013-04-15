package se.chalmers.tda367.group25.resumate.utils;

import java.util.HashMap;
import java.util.Map;

import se.chalmers.tda367.group25.resumate.RMImage;
import se.chalmers.tda367.group25.resumate.RMText;
import se.chalmers.tda367.group25.resumate.Template;

public class TemplateStorage {
	
	private final static int nbrOfTmps = 3;
	private static Map<String, Template> templates = new HashMap<String, Template>(nbrOfTmps);
	
	private static final Template defCVTmp = new Template(new RMImage(), new RMText(), new RMText(), null, null);
	private static final Template defPLTmp = new Template(new RMImage(), new RMText(), null, null, null);
	private static final Template classyCVTmp = new Template(null, new RMText(), new RMText(), null, null);
	
	public static Template getTemplate(String name){
		return templates.get(name).copy();
	}
	

}
