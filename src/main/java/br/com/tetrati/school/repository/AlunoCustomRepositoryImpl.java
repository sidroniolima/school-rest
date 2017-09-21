package br.com.tetrati.school.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.model.Media;

public class AlunoCustomRepositoryImpl implements AlunoCustomRepository
{

	@Override
	public List<Media> listMediasByAlunoAndAnoLetivo(Aluno aluno, int anoLetivo) 
	{
		/*
		Aggregation agg = new Aggregation(
			Aggregation.match(Criteria.where("_id").is(new ObjectId(aluno.get_id())))
		);
		
		
		return (List<Media>) query.partialResults();
		*/
		
		return null;
	}

}
