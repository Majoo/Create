package se.chalmers.tda367.group25.resumate.model;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

public abstract class Section {
	
	private SectionType secType;
	
	//---Constructors---//
	public Section(){
		this.secType = SectionType.EMPTY;
	}
	
	public Section(SectionType secName){
		this.secType = secName;
	}
	
	//---Getters---//
	public SectionType getSecName(){
		return secType;
	}
	
}
