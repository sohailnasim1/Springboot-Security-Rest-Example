/**
 * Custom authentication failure handler to customize the exception and convert them
 * to JSON messages
 * 
 * @author Sohail Nasim
 */
package com.sn.admin.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sn.admin.security.exception.MissingTokenException;
import com.sn.admin.security.exception.SignatureException;
import com.sn.admin.security.exception.TokenExpiredException;
import com.sn.admin.security.util.ErrorCodes;
import com.sn.admin.security.util.ErrorResponse;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	private ObjectMapper mapper;
	public CustomAuthenticationFailureHandler() {
	}
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		if (exception instanceof MissingTokenException) {
			mapper.writeValue(response.getWriter(), ErrorResponse.getErrorResponse(exception.getMessage(), ErrorCodes.MISSING_TOKEN, HttpStatus.UNAUTHORIZED));
		} else if (exception instanceof SignatureException) {
			mapper.writeValue(response.getWriter(), ErrorResponse.getErrorResponse(exception.getMessage(), ErrorCodes.MISSING_TOKEN, HttpStatus.UNAUTHORIZED));
		} else if (exception instanceof TokenExpiredException) {
			mapper.writeValue(response.getWriter(), ErrorResponse.getErrorResponse("Token is expired", ErrorCodes.TOKEN_EXPIRED, HttpStatus.UNAUTHORIZED));
		} else {
			mapper.writeValue(response.getWriter(), ErrorResponse.getErrorResponse(exception.getMessage(), ErrorCodes.GENERAl, HttpStatus.UNAUTHORIZED));
		}

	}

}
