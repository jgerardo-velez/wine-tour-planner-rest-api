package edu.cetys.springlabs.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cetys.springlabs.dto.JwtTokenDto;
import edu.cetys.springlabs.exception.UserNotFoundException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class AuthenticationController {

	@PostMapping("authenticate")
	public JwtTokenDto login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
		
		if (!username.endsWith("@winetourplanner.com")) {
			throw new UserNotFoundException();
		}
		
		String token = generateJWTToken(username);
		JwtTokenDto jwtToken = new JwtTokenDto();
		jwtToken.setToken(token);		
		return jwtToken;
		
	}

	private String generateJWTToken(String username) {
		String jwtSecretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = 
				AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("wineTourPlannerJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))  // 600 secs
				//.setExpiration(new Date(System.currentTimeMillis() + 30000))  // 30 secs
				.signWith(SignatureAlgorithm.HS512,
						jwtSecretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
}
