package se.chalmers.tda367.group25.resumate;

import se.chalmers.tda367.group25.resumate.utils.SectionName;

public abstract class Section {
	
	private SectionName secName;
	
	//---Constructors---//
	public Section(){
		this.secName = SectionName.EMPTY;
	}
	
	public Section(SectionName secName){
		this.secName = secName;
	}
	
	//---Getters---//
	public SectionName getSecName(){
		return secName;
	}
	
}
