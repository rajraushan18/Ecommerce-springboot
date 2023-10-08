package com.project.apigateway.util;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	//this is the same code in security service Jwt service, needed here to decode the token
	//as the secret key should be same using which the token is encrypted
	
	public static final String SECRET = "df0ph0Vuf4Qah7Qnvn3v4M08MLtiYkBVb5jweexXSijqWwce8tOrvDb2sjEiVvR2";
	
	
	//validate token
	public void validateToken(final String token){
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}
	
	
	
	
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	
	
}
