package br.com.tetrati.school.model;

public enum Tipo 
{
	PROVA_QUINZENAL("Prova"),
	PROVA_MENSAL("Prova mensal"),
	PROVA_BIMESTRAL("Prova bimestra"),
	TRABALHO("Trabalho"),
	ATITUDINAL("Atitudinal");
	
	private String descricao;

	private Tipo(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
}
