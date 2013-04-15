package se.chalmers.tda367.group25.resumate;

import java.util.HashMap;
import java.util.Map;

public class TemplateStorage {
	
	private final static int nbrOfTmps = 3;
	private static Map<String, Template> templates = new HashMap<String, Template>(nbrOfTmps);
	
	private static final Template defCVTmp = new Template(new RMImage(), new RMText(), new RMText(), null, null);
	private static final Template defPLTmp = new Template(new RMImage(), new RMText(), null, null, null);
	private static final Template classyCVTmp = new Template(null, new RMText(), new RMText(), null, null);
	
	public static Template getTemplate(String name){
		return templates.getValue(name).copy();
	}
	

}
