package br.com.tetrati.school.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	private Aluno luiza_8_ano;
	
	@Before
	public void init()
	{
		luiza_8_ano = new Aluno("Luiza Heringer", Serie.OITAVO_ANO, "801");
	}
	
	@Test
	public void deveTerOsBimestres() 
	{
		assertEquals("Tem os quatro bimetres.", 4, luiza_8_ano.getBimestres().size());
	}

	@Test
	public void deveCriarOsDiarios()
	{
		List<Disciplina> disciplinas = Arrays.asList(
				Disciplina.PORTUGUES, 
				Disciplina.MATEMATICA, 
				Disciplina.GEOGRAFIA, 
				Disciplina.HISTORIA);
		
		luiza_8_ano.criaDiarios(disciplinas);
		
		assertTrue("Aluno possui as disciplnas", 
				disciplinas.contains(Disciplina.PORTUGUES) && 
				disciplinas.contains(Disciplina.MATEMATICA) &&
				disciplinas.contains(Disciplina.GEOGRAFIA) &&
				disciplinas.contains(Disciplina.HISTORIA));
		
		assertEquals("Aluno possui as 4 disciplnas", 4, disciplinas.size());
		
		System.out.println(luiza_8_ano);
	}
	
	@Test
	public void deveInserirAtividades()
	{
		List<Disciplina> disciplinas = Arrays.asList(
				Disciplina.PORTUGUES, 
				Disciplina.MATEMATICA, 
				Disciplina.GEOGRAFIA, 
				Disciplina.HISTORIA);
		
		luiza_8_ano.criaDiarios(disciplinas);
		
		Atividade provaPortuguesMensal1Bimestre = new Atividade(Tipo.PROVA_MENSAL, 8.6d);
		
		Bimestre bimestre = luiza_8_ano.getBimestres().get(0);
		Diario diarioPort = bimestre.getDiarios().get(0);
		luiza_8_ano.insereAtividade(bimestre, diarioPort, provaPortuguesMensal1Bimestre);
		
		Diario diarioGeo = bimestre.getDiarios().get(2);
		Atividade provaGeografiaBimestral = new Atividade(Tipo.PROVA_BIMESTRAL, 5.1d);
		luiza_8_ano.insereAtividade(bimestre, diarioGeo, provaGeografiaBimestral);		
		
		assertEquals("Prova de português inserida.", 
				Tipo.PROVA_MENSAL, luiza_8_ano.getBimestres().get(0).getDiarios().get(0).getAtividades().get(0).getTipo());
		
		assertEquals("Prova de português inserida.", 
				Tipo.PROVA_BIMESTRAL, luiza_8_ano.getBimestres().get(0).getDiarios().get(2).getAtividades().get(0).getTipo());
		
		System.out.println(luiza_8_ano);
	}
}
