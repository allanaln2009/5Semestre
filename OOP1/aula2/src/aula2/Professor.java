package aula2; // Exercício 2

import java.util.Date;

import aula3.CfgGeral;

public class Professor {
	private int matricula;
	private String nome;
	private int idCurso;
	private Date dtAdmissao;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		if (matricula > 0){
			this.matricula = matricula;
		}
	}
	
	public String getNome() {
		//nome = CfgGeral.trataNome(nome);
		return nome;
	}
	public void setNome(String nome) {
		nome = CfgGeral.trataNome(nome);
		if (nome != null){
			this.nome = nome;
			System.out.println("O professor " + this.nome + " foi inserido com sucesso.");
		}
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = Curso.validaCurso(idCurso);
	}
	
	public Date getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(Date date) {
		this.dtAdmissao = date;
	}
}
