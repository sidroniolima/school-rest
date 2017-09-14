package br.com.tetrati.school.repository;

import java.util.List;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.model.Media;

public interface AlunoCustomRepository 
{
	public List<Media> listMediasByAlunoAndAnoLetivo(Aluno aluno, int anoLetivo);
}
