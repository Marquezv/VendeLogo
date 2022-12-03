package com.marquezv.dev.vendeLogo.service.exceptions;

public class EntityDuplicateException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityDuplicateException (String msg) {
		super(msg);
	}	
	
}
