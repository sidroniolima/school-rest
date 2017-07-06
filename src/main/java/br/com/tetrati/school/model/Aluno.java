package br.com.tetrati.school.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="alunos")
public class Aluno 
{
	@Id
	private String id;
	
	private String nome;	
	private Serie serie;
	private String turma;
	
	private List<Bimestre> bimestres = new ArrayList<Bimestre>();
	
	public Aluno() 
	{ 
		bimestres.addAll(Arrays.asList(
				new Bimestre("1o bimestre"), 
				new Bimestre("2o bimestre"), 
				new Bimestre("3o bimestre"), 
				new Bimestre("4o bimestre")));
	}

	public Aluno(String nome, Serie serie, String turma) 
	{
		this();
		
		this.nome = nome;
		this.serie = serie;
		this.turma = turma;
	}
	
	public void criaDiarios(List<Disciplina> disciplinas)
	{
		bimestres.stream().forEach(b -> {
			disciplinas.stream().forEach(d -> b.diarios.add(new Diario(d)));
		});
	}

	public void insereAtividade(Bimestre bimestre, Diario diario, Atividade atividade) 
	{
		int index = this.getBimestres().indexOf(bimestre);

		if (index > 0)
		{
			throw new IllegalArgumentException("Não foi possível localizar o bimestre.");
		}
		
		Bimestre bim = this.getBimestres().get(index);
		bim.insereAtividade(diario, atividade);
	}
}
