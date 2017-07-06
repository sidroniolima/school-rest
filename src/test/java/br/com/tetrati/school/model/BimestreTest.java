package br.com.tetrati.school.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BimestreTest {

	private Bimestre bimestre;
	
	@Before
	public void init() 
	{
		bimestre = new Bimestre("1o Bimestre");
	}
	
	@Test
	public void deveInserirDiario()
	{
		Diario diarioPortugues = new Diario(Disciplina.PORTUGUES);
		Diario diarioGeografia = new Diario(Disciplina.GEOGRAFIA);
		
		bimestre.getDiarios().addAll(Arrays.asList(diarioPortugues, diarioGeografia));
		
		assertEquals("Bimestre tem 2 diários", 2, bimestre.getDiarios().size());
	}
}
