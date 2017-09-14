package br.com.tetrati.school.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="alunos")
public class Aluno 
{
	@Id
	private String _id;
	
	private String turmaNumero;
	private Serie serie;
	private int numeroChamada;
	
	private String nome;
	private String email;

	@DBRef
	private User user;
	
	List<Media> medias;
	
	public Aluno() 
	{	
		user = new User();
		medias = new ArrayList<Media>();
	}

	public Aluno(
			String _id, 
			String turmaNumero, 
			Serie serie, 
			int numeroChamada, 
			String nome, 
			String email) 
	{
		this();
		this._id = _id;
		this.turmaNumero = turmaNumero;
		this.serie = serie;
		this.numeroChamada = numeroChamada;
		this.nome = nome;
		this.email = email;
	}	
	
	public Aluno(String _id, int numeroChamada, String nome) 
	{
		this();
		this._id = _id;
		this.numeroChamada = numeroChamada;
		this.nome = nome;
	}
	
	public Aluno(int numeroChamada, String nome) 
	{
		this();
		this.numeroChamada = numeroChamada;
		this.nome = nome;
	}

	public void adicionarMedia(Media media)
	{
		this.medias.add(media);
	}
	
	@JsonProperty(value="serieDescricao")
	public String getSerieDescricao()
	{
		return this.serie.getDescricao();
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

	public int getNumeroChamada() {
		return numeroChamada;
	}
	public void setNumeroChamada(int numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurmaNumero() {
		return turmaNumero;
	}
	public void setTurmaNumero(String turmaNumero) {
		this.turmaNumero = turmaNumero;
	}

	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
}
