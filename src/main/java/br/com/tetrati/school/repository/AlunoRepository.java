package br.com.tetrati.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tetrati.school.model.Aluno;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String>
{

}
