package br.com.tetrati.school.model;

public enum Periodo 
{
	PRIMEIRO_BIMESTRE(1, "1º bimestre"),
	SEGUNDO_BIMESTRE(2, "2º bimestre"),
	TERCEIRO_BIMESTRE(3, "3º bimestre"),
	QUARTO_BIMESTRE(4, "4º bimestre");
	
	private int ordem;
	private String descricao;

	private Periodo(int ordem, String descricao) 
	{
		this.ordem = ordem;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getOrdem() 
	{
		return ordem;
	}
}
