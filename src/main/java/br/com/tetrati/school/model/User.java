package br.com.tetrati.school.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="users")
public class User {

	@Id
	private String username;
	
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	private Set<Role> roles;
	
	private boolean enabled;
	
	public User() 
	{
		this.roles = new HashSet<Role>();
		this.roles.add(Role.ROLE_USER);
		
		this.enabled = true;
	}
	
	public User(String username, String password) 
	{
		this();
		this.username = username;
		this.password = password;
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

	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
