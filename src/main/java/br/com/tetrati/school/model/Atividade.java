package br.com.tetrati.school.model;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="atividades")
public class Atividade 
{
	private TipoAtividade tipo;
	private Materia materia;
	private Periodo periodo;
	private String alunoNumero;
	private String alunoNome;
	private String turmaNumero;
	private int anoLetivo;
	private LocalDate data;
	private double nota;

	public Atividade() {	}
	
	public Atividade(TipoAtividade tipo, String alunoNumero, String alunoNome, double nota) 
	{
		this.tipo = tipo;
		this.alunoNumero = alunoNumero;
		this.alunoNome = alunoNome;
		this.nota = nota;
	}
	
	public Atividade(
			TipoAtividade tipo, 
			Materia materia,
			Periodo periodo,
			String alunoNumero, 
			String alunoNome, 
			String turmaNumero, 
			int anoLetivo,
			LocalDate data, 
			double nota) 
	{
		this.tipo = tipo;
		this.materia = materia;
		this.periodo = periodo;
		this.alunoNumero = alunoNumero;
		this.alunoNome = alunoNome;
		this.turmaNumero = turmaNumero;
		this.anoLetivo = anoLetivo;
		this.data = data;
		this.nota = nota;
	}

	public TipoAtividade getTipo() {
		return tipo;
	}
	public void setTipo(TipoAtividade tipo) {
		this.tipo = tipo;
	}
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
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
	public String getAlunoNumero() {
		return alunoNumero;
	}
	public void setAlunoNumero(String alunoNumero) {
		this.alunoNumero = alunoNumero;
	}

	public String getAlunoNome() {
		return alunoNome;
	}
	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}

	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getTurmaNumero() {
		return turmaNumero;
	}
	public void setTurmaNumero(String turmaNumero) {
		this.turmaNumero = turmaNumero;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
}
