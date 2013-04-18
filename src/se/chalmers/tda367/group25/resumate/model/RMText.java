package se.chalmers.tda367.group25.resumate.model;

import javax.swing.JOptionPane;


public class RMText{
	
	private String text;
	private SectionType secType;

	//Constructors
	public RMText(){
		this.secType = SectionType.EMPTY;
	}
	
	public RMText(SectionType sectionType){
		this.secType = sectionType;
	}
	
	//-----Getters-----//
	public String getText(){
		return this.text;
	}
	
	public SectionType getSecType(){
		return this.secType;
	}
	
	//-----Setters-----//
	public void setText(String input){
		this.text = input;
	}

}