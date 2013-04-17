package se.chalmers.tda367.group25.resumate.utils;

import java.util.ArrayList;
import java.util.List;

public class TemplateToSections {

	public static List <SectionType> translate(Template temp) {
		List <SectionType> tmp = new ArrayList <SectionType>(3);
		
		switch(temp){
			
		case DEF_CV: case CLASSY_CV:
			tmp.add(SectionType.PERSONAL_INFO);
			tmp.add(SectionType.WORK_EXPERIENCE);
			
		case DEF_PL:
			tmp.add(SectionType.PERSONAL_INFO);
		}
		return tmp;
	}
	
}
