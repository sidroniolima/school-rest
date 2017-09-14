package br.com.tetrati.school.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.tetrati.school.model.User;

public class UserDetailsImpl implements UserDetails
{
	private static final long serialVersionUID = 8658343958698862890L;

	private User user;
	
	public UserDetailsImpl(User user) 
	{
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return user.getRoles()
				.stream()
				.map(r -> new SimpleGrantedAuthority(r.toString()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() 
	{
		return user.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return user.getUsername(); 
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return user.isEnabled();
	}
}
