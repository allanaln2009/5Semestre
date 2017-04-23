package aula3;

import java.util.Scanner;

import aula2.Aluno;
import aula2.Curso;
import aula2.Professor;

public class Listar {
	private static Scanner ler;
	public static void main(int tipo) {
		ler = Tela.ler;
		if(tipo == 1){
			listarAlunos();
		}else if(tipo == 2){
			listarProfessores();
		}
		System.out.println("Pressione enter para continuar...");
		ler.nextLine();
	}
	
	private static void listarAlunos(){
		Aluno p = new Aluno();
		/*
		p.setNome("Allan Lima");
		p.setRa("9930011572");
		p.setIdCurso(2);
		p.setSemestre(5);
		p.setNotas(Notas.pegaNotas("10;8;10;9"));
		Tela.lista.add(p);
		*/
		int tam = Tela.listaAlunos.size();
		float media;
		System.out.println("LISTA DE ALUNOS INSERIDOS NA MEMÓRIA:");
		for (int i = 0; i < tam; i++){
			//System.out.println("item " + i + ": " + Tela.lista.get(i));
			p = Tela.listaAlunos.get(i); // obtem objeto do vetor e o aloca em p para facilitar detalhamento
			media = Notas.calculaMedia(p.getNotas()); // passa para média o valor retornado pela passagem de notas ao metodo de calculo
			System.out.println(p.getNome() + "\t\t\t\t " + CfgGeral.devolveDtStr(p.getDtNasc()) + "\t" + p.getRa() + "\t" + Curso.getCurso(p.getIdCurso()) + "\t\t" + p.getSemestre() + "º semestre\t" + media + " - " + Notas.situacaoAluno(media) + ".");
		}
	}
	
	private static void listarProfessores(){ // mesma aplicação do método de listagem de alunos 
		Professor p = new Professor();
		int tam = Tela.listaProfessores.size();
		System.out.println("LISTA DE PROFESSORES INSERIDOS NA MEMÓRIA:");
		for (int i = 0; i < tam; i++){
			p = Tela.listaProfessores.get(i);
			System.out.println(p.getNome() + "\t\t\t\tMatricula: " + p.getMatricula() + "\t" + Curso.getCurso(p.getIdCurso()) + "\t\t" + CfgGeral.devolveDtStr(p.getDtAdmissao()) + ".");
		}
	}
}
