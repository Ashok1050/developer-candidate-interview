package com.upperhand.spring.schedule.exception;

public class NotFoundException extends RuntimeException{
	
	public NotFoundException(String message){
		super(message);
	}
	
	public NotFoundException(String message, Throwable cause){
		super(message, cause);
		
	}
}