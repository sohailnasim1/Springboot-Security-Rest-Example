/**
 * Maps the JwtException to the subclass of AuthenticationException so that
 * JSON messages can be handled uniformly by Custom Authentication Failure Handler
 * 
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.security.exception;
import org.springframework.security.core.AuthenticationException;

import io.jsonwebtoken.JwtException;

public class ExceptionMapper {
	
	public static AuthenticationException getException (JwtException  jwtException) {
		if (jwtException instanceof io.jsonwebtoken.security.SignatureException) {
			return new SignatureException(jwtException.getMessage(), jwtException.getCause());
		}
		
		if (jwtException instanceof io.jsonwebtoken.ExpiredJwtException) {
			return new TokenExpiredException(jwtException.getMessage(), jwtException.getCause());
		}
		
		return new GeneralException(jwtException.getMessage(), jwtException.getCause());
	}

}
