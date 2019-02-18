package com.sn.admin.security.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenExpiredException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public TokenExpiredException(String msg) {
		super(msg);
	}

	public TokenExpiredException(String msg, Throwable t) {
		super(msg, t);
	}

}
