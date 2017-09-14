package br.com.tetrati.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tetrati.school.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> 
{
	public User findByUsername(String username);
}
