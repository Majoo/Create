package se.chalmers.tda367.group25.resumate.utils;

import javax.swing.JPanel;

import se.chalmers.tda367.group25.resumate.views.ClassyCVPanel;
import se.chalmers.tda367.group25.resumate.views.DefaultCVPanel;
import se.chalmers.tda367.group25.resumate.views.DefaultPLPanel;
import se.chalmers.tda367.group25.resumate.views.AbsDocumentPanel;

public class TemplateToPanel {

	public static AbsDocumentPanel translate(Template temp) {

		AbsDocumentPanel s;
		switch(temp){
			
		case DEF_CV: s = new DefaultCVPanel();
		case CLASSY_CV: s = new ClassyCVPanel();
		case DEF_PL: s = new DefaultPLPanel();
		default: s = null; //never invoked
		}
		return s;
	}
}
