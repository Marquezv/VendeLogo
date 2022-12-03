package com.marquezv.dev.vendeLogo.commons.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Notification {
	
	private final List<String> errors = new ArrayList<>();
	
	public void addError(final String message) {
		errors.add(message);
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
	
	public String errorMessage() {
		return errors.toString();
	}
	
	public List<String> getErrors(){
		return this.errors;
	}
}
