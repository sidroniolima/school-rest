package br.com.tetrati.school.model;

import org.junit.Before;

public class AlunoTest {

	private Aluno luiza_8_ano;
	
	@Before
	public void init()
	{
		luiza_8_ano = new Aluno(35, "Luiza Heringer");
	}
	
}
