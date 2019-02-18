/**
 * This class stores the data contains within the authentication token like username,
 * token expiry and token issue date. This class implements UserDetails and stores the
 * non-security user's information encapsulated into Authentication object used by spring
 * security.
 * 
 * @author Sohail Nasim
 */
package com.sn.admin.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthTokenData implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private Date expiration;
	private Date issuedAt;
	
	
	public AuthTokenData(String username, Date expiration, Date issuedAt) {
		this.username = username;
		this.expiration = expiration;
		this.issuedAt = issuedAt;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	

	public Date getExpiration() {
		return expiration;
	}
	public Date getIssuedAt() {
		return issuedAt;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
