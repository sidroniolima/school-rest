package br.com.tetrati.school;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.model.Atividade;
import br.com.tetrati.school.model.Bimestre;
import br.com.tetrati.school.model.Diario;
import br.com.tetrati.school.model.Disciplina;
import br.com.tetrati.school.model.Serie;
import br.com.tetrati.school.model.Tipo;
import br.com.tetrati.school.repository.AlunoRepository;

@Component
public class DbSeeder implements CommandLineRunner
{
	private AlunoRepository alunoRepo;
	
	@Autowired
	public DbSeeder(AlunoRepository alunoRepo) 
	{
		this.alunoRepo = alunoRepo;
	}

	@Override
	public void run(String... arg0) throws Exception 
	{
		alunoRepo.deleteAll();
		
		List<Disciplina> disciplinasFundamental = 
				asList(Disciplina.PORTUGUES,
						Disciplina.MATEMATICA,
						Disciplina.GEOGRAFIA,
						Disciplina.HISTORIA);
		
		Aluno luiza = new Aluno("Luiza Heringer da Silva", Serie.NONO_ANO, "901");
		luiza.criaDiarios(disciplinasFundamental);
		
		Atividade provaMensalPortugues = new Atividade(Tipo.PROVA_MENSAL, 9.1d);
		
		Bimestre primeiroBim = luiza.getBimestres().get(0);
		Diario diarioPort = primeiroBim.getDiarios().get(0);
		
		luiza.insereAtividade(primeiroBim, diarioPort, provaMensalPortugues);
		
		this.alunoRepo.save(luiza);
	}
}
