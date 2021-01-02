package com.vincentdevboard.app.auth;

import static com.vincentdevboard.app.auth.Constants.EXPIRATION_TIME;
import static com.vincentdevboard.app.auth.Constants.SECRET_TOKEN;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincentdevboard.app.entities.User;
import com.vincentdevboard.app.exceptions.SingleException;
import com.vincentdevboard.app.requests.LoginRequest;
import com.vincentdevboard.app.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTAuth {
	
	@Autowired
	UserService userService;
	
	SecretKey key = Keys.hmacShaKeyFor(SECRET_TOKEN.getBytes(StandardCharsets.UTF_8));

	public String generateToken(String id) {
		Date now = new Date(System.currentTimeMillis());
		Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
		return Jwts.builder().setSubject(id).setIssuedAt(now).setExpiration(expiryDate).signWith(key).compact();
	}
	
	public String register(String id) {
		return generateToken(id);
	}

	public String login(LoginRequest login) {
		User user = userService.findUserByEmail(login.getEmail());
		
		if (user == null || !BCrypt.checkpw(login.getPassword(), user.getPassword())) {
			throw new SingleException("Invalid Credentials");
		}
		
		return generateToken(user.getUserId());
	}
	
	public String authenticate(String token) {
		try {
			String id = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
			return id;
		} catch (Exception e) {
			throw new SingleException("Invalid token, authorization denied");
		}
	}
}
