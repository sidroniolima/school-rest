package br.com.tetrati.school.service;

import java.util.List;

import br.com.tetrati.school.model.Aluno;

public interface AlunoService 
{
	public Aluno save(Aluno aluno);
	public void delete(String id);
	public List<Aluno> listAll();
	public Aluno findById(String id);
}
