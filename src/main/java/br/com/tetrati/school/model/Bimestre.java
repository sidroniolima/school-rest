package br.com.tetrati.school.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Bimestre 
{
	private String descricao;
	List<Diario> diarios = new ArrayList<Diario>();
	
	public Bimestre() {	}

	public Bimestre(String descricao) 
	{
		this.descricao = descricao;
	}

	public void insereAtividade(Diario diario, Atividade atividade) 
	{
		int index = diarios.indexOf(diario);

		if (index < 0)
		{
			throw new IllegalArgumentException("Não foi possível achar o diário para esta atividade");
		}
		
		Diario di = this.getDiarios().get(index);
		di.getAtividades().add(atividade);
	}
}
