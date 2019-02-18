package com.sn.admin.security.exception;

import org.springframework.security.core.AuthenticationException;

public class MissingTokenException extends AuthenticationException {

	private static final long serialVersionUID = 1L;


	public MissingTokenException(String ex, Throwable t) {
		super(ex, t);
	}

	public MissingTokenException(String ex) {
		super(ex);
	}

}
