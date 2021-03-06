package se.chalmers.tda367.group25.resumate.utils;

/**
 * A SectionType decides what kind of information
 * the user should put in this Section,
 * and is used to generate appropriate tips, input prompts etc.
 */

public enum SectionType {
	INFO_TITLE,
	NAME_TITLE,
	ADDRESS_TITLE,
	CITYZIPCODE_TITLE,
	PHONE_TITLE,
	EMAIL_TITLE,
	EMPTY1_TITLE,
	EMPTY2_TITLE,
	
	PERSONAL_INFO,
	NAME_PERSONAL,
	ADDRESS_PERSONAL,
	CITYZIPCODE_PERSONAL,
	PHONE_PERSONAL,
	EMAIL_PERSONAL,
	EMPTY1_PERSONAL,
	EMPTY2_PERSONAL,
	
	WORK_EXPERIENCE,
	EDUCATION_EXPERIENCE,
	
	HEADER,
	WORK_HEADER,
	EDU_HEADER
}