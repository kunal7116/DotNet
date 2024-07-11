package com.app.exception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	public CustomException(String mssg) {
		super(mssg);
	}
}
