/**
 * Retrives the authentication token from UsernamePasswordAuthenticationToken and
 * validate it. UserDetails is constructed from token and returned
 * 
 * @author Sohail Nasim
 * 
 */
package com.sn.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sn.admin.security.util.AuthenticationHelper;

@Component
public class UserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	 @Autowired
	 private AuthenticationHelper authenticationHelper;
	
	@Override
	public boolean supports(Class<?> authentication) {
		return AuthenticationToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		AuthenticationToken authToken = (AuthenticationToken)authentication;
		return authenticationHelper.validateToken(authToken.getToken());
	}
}
