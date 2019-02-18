package com.sn.admin.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sn.admin.security.AuthTokenData;
import com.sn.admin.security.exception.ExceptionMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class AuthenticationHelper {

	@Value("${secret.key}")
	private String secretKey;

	public AuthTokenData validateToken(String token) throws JwtException {
		try {
			Claims claims = Jwts.parser()
								.setSigningKey(secretKey)
								.parseClaimsJws(token)
								.getBody();
			return new AuthTokenData(claims.getSubject(), claims.getExpiration(), claims.getIssuedAt());
		} catch (JwtException jwtException) { 
			throw ExceptionMapper.getException(jwtException);
		}
	}
}
