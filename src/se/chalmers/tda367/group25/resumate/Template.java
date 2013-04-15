package se.chalmers.tda367.group25.resumate;

import java.util.ArrayList;
import java.util.List;


public class Template {

	private List <RMText> textList = new ArrayList <RMText>();
	private RMImage image;


	public Template(RMImage o1, RMText o2, RMText o3, RMText o4, RMText o5) {
		image = o1;
		textList.add(o2); textList.add(o3); textList.add(o4); textList.add(o5);
	}

	public Template copy() {
		// TODO Auto-generated method stub
		return null;
	}



	public RMImage getImageSection() {
		return image;
	}


	public RMText getRMText(int i) {
		return textList.get(i);
	}
	
	//Later on return a cloned version instead.
	public List <RMText> getTexts(){
		return this.textList;
	}
	
}