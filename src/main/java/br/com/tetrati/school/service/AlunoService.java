package br.com.tetrati.school.service;

import java.util.List;

import br.com.tetrati.school.model.Aluno;

public interface AlunoService extends ServiceCrud<Aluno, String>
{
	public Aluno save(Aluno aluno);
	public void delete(String id);
	public List<Aluno> listAll();
	public Aluno findById(String id);
	public Aluno findByEmail(String email);
}
