package br.com.tetrati.school.model;

public enum Disciplina 
{
	PORTUGUES("Português"),
	MATEMATICA("Matemática"),
	GEOGRAFIA("Geografia"),
	HISTORIA("História");
	
	private String descricao;

	private Disciplina(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
}
