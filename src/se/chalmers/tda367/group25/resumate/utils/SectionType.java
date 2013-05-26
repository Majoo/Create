package se.chalmers.tda367.group25.resumate.utils;

/**
 * A SectionType decides what kind of information
 * the user should put in this Section,
 * and is used to generate appropriate tips, input prompts etc.
 */

public enum SectionType {
	NAME,
	ADDRESS,
	CITYZIPCODE,
	PHONE,
	EMAIL,
	EMPTY1,
	EMPTY2,
	
	WORK_EXPERIENCE,
	EDUCATION,
	
	WORK_HEADER,
	EDU_HEADER;
}