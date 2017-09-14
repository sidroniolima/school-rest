package br.com.tetrati.school.model;

public enum Periodo 
{
	PRIMEIRO_BIMESTRE("1º bimestre"),
	SEGUNDO_BIMESTRE("2º bimestre"),
	TERCEIRO_BIMESTRE("3º bimestre"),
	QUARTO_BIMESTRE("4º bimestre");
	
	private String descricao;

	private Periodo(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
