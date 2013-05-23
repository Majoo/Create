package se.chalmers.tda367.group25.resumate.model;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.tda367.group25.resumate.utils.SectionType;


public class PersonalInformationSection extends AbsTextSection {
	
	//Personal Info Titles
	private String nameTitles;
	private String phoneTitles;
	private String emailTitles;
	private String addressTitles;
	private String cityZipCodeTitles;
	
	//Personal Info TextFields
	private String nameField;
	private String cityZipCodeField;
	private String addressField;
	private String phoneField;
	private String emailField;
	private String emptyField1;
	private String emptyField2;

	private List <String> textList;
	
	public PersonalInformationSection(){
		super(SectionType.PERSONAL_INFO, "Tahoma", "Black", 12);
		textList = new ArrayList<String>(12);
		//Add all the titles
		textList.add(nameTitles);
		textList.add(phoneTitles);
		textList.add(emailTitles);
		textList.add(addressTitles);
		textList.add(cityZipCodeTitles);
		
		//Add all the fields
		textList.add(nameField);
		textList.add(cityZipCodeField);
		textList.add(addressField);
		textList.add(phoneField);
		textList.add(emailField);
		textList.add(emptyField1);
		textList.add(emptyField2);
	}
	
	//Mutators for the fields
	public void setNameField(String text){
		this.nameField = text;
	}
	public void setCityZipCodeField(String text){
		this.cityZipCodeField = text;
	}
	public void setAddressField(String text){
		this.addressField = text;
	}
	public void setPhoneField(String text){
		this.phoneField = text;
	}
	public void setEmailField(String text){
		this.emailField = text;
	}
	public void setEmptyField1(String text){
		this.emptyField1 = text;
	}
	public void setEmptyField2d(String text){
		this.emptyField2 = text;
	}
	
	//Mutators for the titels
	public void setNameTitles(String text){
		this.nameTitles = text;
	}
	public void setCityZipCodeTitles(String text){
		this.cityZipCodeTitles = text;
	}
	public void setAddressTitles(String text){
		this.addressTitles = text;
	}
	public void setPhoneTitles(String text){
		this.phoneTitles = text;
	}
	public void setEmailTitles(String text){
		this.emailTitles = text;
	}
	
	//Accessors for the titles
	
	public String getNameTitles(){
		return nameTitles;
	}	
		
	public String getPhoneTitles(){
		return phoneTitles;
	}	
	
	public String getEmailTitles(){
		return emailTitles;
	}	
	public String getTitlesAdress(){
		return addressTitles;
	}	
	public String getCityZipCodeTitles(){
		return cityZipCodeTitles;
	}	
	
	
	//Accessors for the fields
	public String getNameField(){
		return nameField;
	}
	public String cityzipcodeField(){
		return cityZipCodeField;
	}	
	public String getAddressField(){
		return addressField;
	}
	
	public String getPhoneField(){
		return phoneField;
	}
	public String getEmailField(){
		return emailField;
	}	
	public String getEmptyField1(){
		return emptyField1;
	}	
	public String getEmptyField2(){
		return emptyField2;
	}

	@Override
	public List<String> getText() {
		return textList;
	}

}
