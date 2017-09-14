package br.com.tetrati.school.model;

public enum Materia 
{
	PORTUGUES("Línguas","Portugues"),
	MATEMATICA("Exatas","Matemática"),
	HISTORIA("Humanas","História"),
	GEOGRAFIA("Humanas","Geografia"),
	CIENCIAS("Exatas", "Ciências"),
	INGLES("Línguas", "Inglês"),
	ESPANHOL("Línguas", "Espanhol"),
	EDUCACAO_FISICA("Humanas", "Ed. Física"),
	GEOMETRIA("Exatas", "Geometria");
	
	private String disciplina;
	private String descricao;
	
	private Materia(String disciplina, String descricao) 
	{
		this.disciplina = disciplina;
		this.descricao = descricao;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public String getDescricao() {
		return descricao;
	}
}
