/**
 * Class for storing the token retrieved from authorization header
 * 
 * @author Sohail Nasim
 */
package com.sn.admin.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationToken extends UsernamePasswordAuthenticationToken  {

	private static final long serialVersionUID = 1L;
	
	private String token;
	
	public AuthenticationToken(String token) {
		super(null, null);
		setToken(token);
		
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}
