package br.com.tetrati.school.service;

import br.com.tetrati.school.model.User;

public interface UserService
{
	public User findByUsername(String username);
}
