package com.sn.admin.security.util;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
	GENERAl(1), MISSING_TOKEN(2), TOKEN_EXPIRED(3), INVALID_TOKEN(4);
	
	private int errorCode;
	
	private ErrorCodes(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@JsonValue
	public int getErrorCode() {
		return errorCode;
	}

}
