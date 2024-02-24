package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	
	private static final Logger Log = LoggerFactory.getLogger(JwtUtils.class);

	public boolean validateJwtToken(String auhToken) {
		
		try {
		Jwts.parser().setSigningKey("zxcv123asdasdasd55d45as4d5asd5a4sd4asd5d4sa5d4a4d5asadasdasdasdasdasdasdasdasdasdasdasdasdasdasdafewfasdasdasdaasdewfe").parseClaimsJws(auhToken);
		
		return true;
		
		}catch(Exception e){
			Log.error("",e);
		}
		return false;
	}
	
	public String getuseNameFromjwtToken (String token) {
		
		return Jwts.parser().setSigningKey("zxcv123asdasdasd55d45as4d5asd5a4sd4asd5d4sa5d4a4d5asadasdasdasdasdasdasdasdasdasdasdasdasdasdasdafewfasdasdasdaasdewfe").parseClaimsJws(token).getBody().getSubject();
		
	
	}
	
	
	
}
