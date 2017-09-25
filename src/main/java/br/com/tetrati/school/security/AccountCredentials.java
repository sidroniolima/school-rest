package br.com.tetrati.school.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AccountCredentials 
{
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public AccountCredentials() {	}
	
	public AccountCredentials(String username, String password, Collection<? extends GrantedAuthority> authorities) 
	{
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
