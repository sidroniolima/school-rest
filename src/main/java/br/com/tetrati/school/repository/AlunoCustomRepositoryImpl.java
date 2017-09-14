package br.com.tetrati.school.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.model.Media;

public class AlunoCustomRepositoryImpl implements AlunoCustomRepository
{

	@Override
	public List<Media> listMediasByAlunoAndAnoLetivo(Aluno aluno, int anoLetivo) 
	{
		Query query = new Query();
		query.addCriteria(
				Criteria.where("_id").is(aluno.get_id())
				.and
				("medias.anoLetivo").is(anoLetivo));
		
		return (List<Media>) query.partialResults();
	}

}
