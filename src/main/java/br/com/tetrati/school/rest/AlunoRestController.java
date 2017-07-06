package br.com.tetrati.school.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tetrati.school.model.Aluno;
import br.com.tetrati.school.service.AlunoService;

@RestController("/api/aluno")
public class AlunoRestController 
{
	private AlunoService srvc;

	@Autowired
	public AlunoRestController(AlunoService srvc) 
	{
		this.srvc = srvc;
	}
	
	@PostMapping("/api/aluno")
	public Aluno create(Aluno aluno)
	{
		return this.srvc.save(aluno);
	}
	
	@GetMapping("/api/aluno/{id}")
	public Aluno getById(@PathParam("id") String id)
	{
		return this.srvc.findById(id);
	}
	
	@GetMapping("/api/aluno/")
	public List<Aluno> getAll()
	{
		return this.srvc.listAll();
	}
	
	@PutMapping("/api/aluno/{id}")
	public Aluno update(@PathParam("id") String id, Aluno aluno)
	{
		return this.srvc.save(aluno);
	}
	
	@DeleteMapping("/api/aluno/{id}")
	public void update(@PathParam("id") String id)
	{
		this.srvc.delete(id);
	}
}
