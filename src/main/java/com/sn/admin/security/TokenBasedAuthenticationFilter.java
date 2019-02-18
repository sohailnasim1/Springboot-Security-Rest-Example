/**
 * This class checks and retrieves the token from authorization header and pass the
 * authentication token to the authentication manager for authentication and retrieval
 * of user details object.
 * 
 * @author Sohail Nasim
 */
package com.sn.admin.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import com.sn.admin.security.exception.MissingTokenException;

public class TokenBasedAuthenticationFilter extends AbstractAuthenticationProcessingFilter { // OncePerRequestFilter {

	private static String AUTHORIZATION_HEADER = "Authorization";
	private static String BEARER = "Bearer ";
	private AuthenticationFailureHandler failureHandler;
	
	private static String TOKEN_MISSING_MESSAGE = "Authorization token is missing from header";

	public TokenBasedAuthenticationFilter(String API_URL, AuthenticationFailureHandler failureHandler) {
		super(API_URL);
		this.failureHandler = failureHandler;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

		if (authorizationHeader == null || !authorizationHeader.startsWith(BEARER)) {
			throw new MissingTokenException(TOKEN_MISSING_MESSAGE);
		}

		String authToken = authorizationHeader.substring(BEARER.length());

		AuthenticationToken authenticationToken = new AuthenticationToken(authToken);

		return getAuthenticationManager().authenticate(authenticationToken);

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authResult);
		SecurityContextHolder.setContext(context);
		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}

}
