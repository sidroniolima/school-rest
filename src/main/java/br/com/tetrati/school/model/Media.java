package br.com.tetrati.school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Media 
{
	private Materia materia;
	private Periodo periodo;
	private int numeroPeriodo;
	private double nota;
	private int anoLetivo;
	private String turmaNumero;
	private Serie serie;
	
	public Media(Materia materia, Periodo periodo, double nota, int anoLetivo, String turmaNumero, Serie serie) 
	{
		this.materia = materia;
		this.periodo = periodo;
		this.nota = nota;
		this.anoLetivo = anoLetivo;
		this.turmaNumero = turmaNumero;
		this.serie = serie;
		this.numeroPeriodo = periodo.getOrdem();
	}
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public int getNumeroPeriodo() {
		return numeroPeriodo;
	}
	public void setNumeroPeriodo(int numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	@JsonProperty("periodoDescricao")
	public String getPeriodoDescricao()
	{
		return this.periodo.getDescricao();
	}
	
	@JsonProperty("materiaDescricao")
	public String getDescricaoMateria()
	{
		return this.materia.getDescricao();
	}
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
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
	
}
