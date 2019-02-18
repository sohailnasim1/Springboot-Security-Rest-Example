package com.sn.admin.security.exception;

import org.springframework.security.core.AuthenticationException;

public class SignatureException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public SignatureException(String msg, Throwable t) {
		super(msg, t);
	}

	public SignatureException(String msg) {
		super(msg);
	}

}
