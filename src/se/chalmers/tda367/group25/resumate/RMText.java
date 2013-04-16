package se.chalmers.tda367.group25.resumate;

import se.chalmers.tda367.group25.resumate.utils.SectionName;

public class RMText extends Section{
	
	private String text;

	//Constructors
	public RMText(){
		super();
	}
	
	public RMText(SectionName sectionName){
		super(sectionName);
	}
	
	//Getters
	public String getText(){
		return this.text;
	}

}