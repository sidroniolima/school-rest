package br.com.tetrati.school.model;

public enum Serie 
{
	SEXTO_ANO("Sexto ano - ensino fundamental"),
	SETIMO_ANO("Sétimio ano - ensino fundamental"),
	OITAVO_ANO("Oitavo ano - ensino fundamental"),
	NONO_ANO("Nono ano - ensino fundamental"),
	PRIMEIRO_ANO_SEGUNDO_GRAU("Primeiro ano - ensino médio"),
	SEGUNDO_ANO_SEGUNDO_GRAU("Segundo ano - ensino médio"),
	TERCEIRO_ANO_SEGUNDO_GRAU("Terceiro ano - ensino médio");
	
	private String descricao;
	
	private Serie(String descricao) 
	{
		this.descricao = descricao;
	}

	public String getDescricao() 
	{
		return descricao;
	}
}
