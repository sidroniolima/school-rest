package br.com.tetrati.school.security;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.tetrati.school.service.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService 
{
	static final long EXPIRATION_TIME = 680_000_000;
	static final String SECRET = "MySecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
	
	static void addAuthentication(HttpServletResponse response, String username, Collection<? extends GrantedAuthority> collection)
	{
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", collection.stream().map(g -> g.getAuthority()).collect(Collectors.toList()));
		claims.put("subject", username);
		
		String JWT = Jwts.builder()
						.setClaims(claims)
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, SECRET)
						.compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}
	
	static Authentication getAthentication(HttpServletRequest request)
	{
		String token = request.getHeader(HEADER_STRING);

		if (null != token)
		{
			Map<String, Object> claims = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody();
			
			String user = (String) claims.get("subject");
			List<String> roles = (List<String>) claims.get("roles");
			
			Collection<? extends GrantedAuthority> grantedAuths = roles.stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
			
			AccountCredentials principal = new AccountCredentials(user, "", grantedAuths);
			
			if (null != user)
			{
				return new UsernamePasswordAuthenticationToken(principal.getUsername(), "", principal.getAuthorities());
			}
		}
		
		return null;
	}
}
