package br.com.tetrati.school.model;

public class Professor 
{
	private String nome;

	public Professor() {	}
	
	public Professor(String nome) 
	{
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
