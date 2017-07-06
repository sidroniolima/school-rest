package br.com.tetrati.school.model;

import lombok.Data;

@Data
public class Atividade 
{
	private Tipo tipo;
	private double nota;

	public Atividade() {	}
	
	public Atividade(Tipo tipo, double nota) 
	{
		this.tipo = tipo;
		this.nota = nota;
	}
}
