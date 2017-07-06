package br.com.tetrati.school.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Diario 
{
	private Disciplina disciplina;
	private List<Atividade> atividades = new ArrayList<Atividade>();
	private double media;
	
	public Diario() 
	{
		media = 0d;
	}

	public Diario(Disciplina disciplina) 
	{
		this();
		this.disciplina = disciplina;
	}
}
