package com.sn.admin.security.exception;

import org.springframework.security.core.AuthenticationException;

public class GeneralException extends AuthenticationException {

	public GeneralException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public GeneralException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

}
