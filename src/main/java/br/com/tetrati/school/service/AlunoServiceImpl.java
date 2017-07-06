package br.com.tetrati.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService
{
	private AlunoRepository repo;

	@Autowired
	public AlunoServiceImpl(AlunoRepository repo) 
	{
		this.repo = repo;
	}

	@Override
	public Aluno save(Aluno aluno) 
	{
		return this.repo.save(aluno);
	}

	@Override
	public void delete(String id) 
	{
		this.repo.delete(id);
	}

	@Override
	public List<Aluno> listAll() 
	{		
		return this.repo.findAll();
	}

	@Override
	public Aluno findById(String id) 
	{
		return this.repo.findOne(id);
	}
}
