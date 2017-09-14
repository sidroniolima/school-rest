package br.com.tetrati.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tetrati.school.model.User;
import br.com.tetrati.school.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService 
{
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = this.findByUsername(username);
		
		if (null == user)
		{
			throw new UsernameNotFoundException("Não foi possível localizar o usuário");
		}
		
		return new UserDetailsImpl(user);
	}

	@Override
	public User findByUsername(String username) 
	{
		return this.userRepository.findByUsername(username);
	}

}
