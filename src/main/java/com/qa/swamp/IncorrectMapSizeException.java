package com.qa.swamp;

@SuppressWarnings("serial")
public class IncorrectMapSizeException extends RuntimeException{
	public String getMessage() {
		return "Unacceptable map size";
	}
}
