package br.com.tetrati.school.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.service.AlunoService;

@RestController
public class AlunoRestController implements SimpleController<Aluno, String>
{
	private AlunoService srvc;

	@Autowired
	public AlunoRestController(AlunoService srvc) 
	{
		this.srvc = srvc;
	}
	
	@Override
	@PostMapping("/api/aluno")
	public Aluno create(Aluno aluno)
	{
		return this.srvc.save(aluno);
	}
	
	@Override
	@GetMapping("/api/aluno/{id}")
	public Aluno getById(@PathVariable("id") String id)
	{
		return this.srvc.findById(id);
	}
	
	@GetMapping("/api/aluno/profile")
	public Aluno getAlunoLogadoProfile(Principal principal)
	{
		return this.srvc.findByEmail(principal.getName());
	}
	
	@Override
	@GetMapping("/api/aluno")
	public List<Aluno> getAll()
	{
		return this.srvc.listAll();
	}
	
	@Override
	@DeleteMapping("/api/aluno/{id}")
	public void delete(@PathVariable("id") String id)
	{
		this.srvc.delete(id);
	}
}
