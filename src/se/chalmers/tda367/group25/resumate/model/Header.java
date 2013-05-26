package se.chalmers.tda367.group25.resumate.model;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.utils.SectionType;

public class Header extends AbsTextSection{
	
	//Headers
	private String workExpHeader = "";
	private String educationHeader = "";
	private List <String> textList;
	
	public Header(){
		super(SectionType.HEADER, "Tahoma", "Black", 12);
		textList = new ArrayList<String>(2);
		textList.add(workExpHeader);
		textList.add(educationHeader);
	}
	
	//Mutators for the headers
	public void setWorkExpHeader(String text){
		this.workExpHeader = text;
	}
	public void setEducationHeader(String text){
		this.educationHeader = text;
	}
	
	//Accessors for the headers
	public String getworkExpHeader(){
		return workExpHeader;
	}
	public String getEducationHeader(){
		return educationHeader;
	}

	@Override
	public List<String> getText() {
		return textList;
	}
	

}
