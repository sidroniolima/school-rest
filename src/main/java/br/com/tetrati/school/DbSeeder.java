package br.com.tetrati.school;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.model.Disciplina;
import br.com.tetrati.school.model.Materia;
import br.com.tetrati.school.model.Media;
import br.com.tetrati.school.model.Periodo;
import br.com.tetrati.school.model.Role;
import br.com.tetrati.school.model.Serie;
import br.com.tetrati.school.model.User;
import br.com.tetrati.school.repository.AlunoRepository;
import br.com.tetrati.school.repository.UserRepository;

@Component
public class DbSeeder implements CommandLineRunner
{
	private AlunoRepository alunoRepo;
	private UserRepository userRepo;
	
	@Autowired
	public DbSeeder(AlunoRepository alunoRepo, UserRepository userRepo) 
	{
		this.alunoRepo = alunoRepo;
		this.userRepo = userRepo;
	}

	@Override
	public void run(String... arg0) throws Exception 
	{
		alunoRepo.deleteAll();
		userRepo.deleteAll();
		
		List<Disciplina> disciplinasFundamental = 
				asList(Disciplina.PORTUGUES,
						Disciplina.MATEMATICA,
						Disciplina.GEOGRAFIA,
						Disciplina.HISTORIA);
		
		User userLuiza = new User("luiza@hotmail.com", "12345");
		userRepo.save(userLuiza);
		
		Aluno luiza = new Aluno("59a88b303ef7d90197a0eb71",
				"802",
				Serie.OITAVO_ANO,
				35, 
				"Luiza Heringer da Silva",
				"luiza@hotmail.com");
		luiza.setUser(userLuiza);

		luiza.adicionarMedia(new Media(Materia.MATEMATICA, Periodo.PRIMEIRO_BIMESTRE, 100, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.HISTORIA, Periodo.PRIMEIRO_BIMESTRE, 95, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.GEOGRAFIA, Periodo.PRIMEIRO_BIMESTRE, 85, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.PORTUGUES, Periodo.PRIMEIRO_BIMESTRE, 90, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.INGLES, Periodo.PRIMEIRO_BIMESTRE, 78, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.ESPANHOL, Periodo.PRIMEIRO_BIMESTRE, 70, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.GEOMETRIA, Periodo.PRIMEIRO_BIMESTRE, 85, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.CIENCIAS, Periodo.PRIMEIRO_BIMESTRE, 92, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.EDUCACAO_FISICA, Periodo.PRIMEIRO_BIMESTRE, 77, 2017, "802", Serie.OITAVO_ANO));
		
		luiza.adicionarMedia(new Media(Materia.MATEMATICA, Periodo.SEGUNDO_BIMESTRE, 90, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.HISTORIA, Periodo.SEGUNDO_BIMESTRE, 85, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.GEOGRAFIA, Periodo.SEGUNDO_BIMESTRE, 77, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.PORTUGUES, Periodo.SEGUNDO_BIMESTRE, 82, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.INGLES, Periodo.SEGUNDO_BIMESTRE, 88, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.ESPANHOL, Periodo.SEGUNDO_BIMESTRE, 97, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.GEOMETRIA, Periodo.SEGUNDO_BIMESTRE, 88, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.CIENCIAS, Periodo.SEGUNDO_BIMESTRE, 77, 2017, "802", Serie.OITAVO_ANO));
		luiza.adicionarMedia(new Media(Materia.EDUCACAO_FISICA, Periodo.SEGUNDO_BIMESTRE, 70, 2017, "802", Serie.OITAVO_ANO));
		
		this.alunoRepo.save(luiza);
		
		Aluno sidronio = new Aluno("59a88b303ef7d90197a0eb72",
				"802",
				Serie.OITAVO_ANO,
				35, 
				"Sidronio Lima da Silva",
				"sidronio@hotmail.com");
		
		sidronio.adicionarMedia(new Media(Materia.MATEMATICA, Periodo.PRIMEIRO_BIMESTRE, 80, 2017, "3003", Serie.TERCEIRO_ANO_SEGUNDO_GRAU));
		sidronio.adicionarMedia(new Media(Materia.HISTORIA, Periodo.PRIMEIRO_BIMESTRE, 78, 2017, "3003", Serie.TERCEIRO_ANO_SEGUNDO_GRAU));
		sidronio.adicionarMedia(new Media(Materia.GEOGRAFIA, Periodo.PRIMEIRO_BIMESTRE, 75, 2017, "3003", Serie.TERCEIRO_ANO_SEGUNDO_GRAU));
		sidronio.adicionarMedia(new Media(Materia.PORTUGUES, Periodo.PRIMEIRO_BIMESTRE, 82, 2017, "3003", Serie.TERCEIRO_ANO_SEGUNDO_GRAU));
		
		User userSidronio = new User("sidronio@hotmail.com", "12345");
		userSidronio.getRoles().add(Role.ROLE_ADMIN);
		userRepo.save(userSidronio);
		
		sidronio.setUser(userSidronio);
		
		this.alunoRepo.save(sidronio);		
	}
}
