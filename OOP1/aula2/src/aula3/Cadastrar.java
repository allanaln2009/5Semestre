package aula3;

import java.util.InputMismatchException;
import java.util.Scanner;

import aula2.Aluno;
import aula2.Professor;

public class Cadastrar {
	private static Scanner ler;
	private static int saida;
	private static int x;
	private static int num;
	private static String entidadeTxt;
	
	public static void main(int tipo) {
		ler = Tela.ler;
		saida = 0;
		x = 0;
		num = 0;
		entidadeTxt = "";

		if(tipo == 1){
			entidadeTxt = "alunos";
			insereAluno();
		}else if(tipo == 2){
			entidadeTxt = "professores";
			insereProfessor();
		}
		System.out.println("Inserção de " + entidadeTxt + " encerrada.");
		//Aluno[] lista = new Aluno[10];
		//ArrayList<Aluno> lista = new ArrayList<Aluno>();
	}
	
	private static void insereAluno(){
		while (saida == 0) {
			Aluno aluno = new Aluno();
			// os laços while são para obrigar usuário a digitar um dado válido
			System.out.print("Digite o nome do aluno: ");
			while(aluno.getNome() == null){
				aluno.setNome(ler.nextLine());
			}
			System.out.print("Digite a data de nascimento do aluno (DDMMYYYY): ");
			while(aluno.getDtNasc() == null){
				aluno.setDtNasc(CfgGeral.pegaDtStr(ler.nextLine())); //dtNasc aluno recebe data coletada do usuário
			}
			System.out.print("Digite o RA do aluno: ");
			while(aluno.getRa() == null){
				aluno.setRa(ler.nextLine());
			}
			System.out.print("Digite o id do curso do aluno: ");
			while(aluno.getIdCurso() == 0){
				try {
					aluno.setIdCurso(ler.nextInt());					
				} catch (InputMismatchException e) {
					aluno.setIdCurso(0);
				}
				ler.nextLine();
			}
			System.out.print("Digite o semestre do aluno: ");
			while(aluno.getSemestre() == 0){
				try {
					aluno.setSemestre(ler.nextInt());
				} catch (InputMismatchException e) {
					aluno.setSemestre(0);
				}
				ler.nextLine();
			}
			System.out.print("Digite as 4 notas do aluno separadas por ponto e virgula: ");
			while(x == 0){				
				aluno.setNotas(Notas.pegaNotas(ler.nextLine()));
				if(aluno.getNotas() != null){
					break;
				}
			}
			Tela.listaAlunos.add(aluno); // adiciona aluno na memória
			System.out.println("Deseja inserir mais outro aluno? Pressione 0 para sim, qualquer outro valor para não ");
			try{
				num = ler.nextInt();
			}catch(InputMismatchException e){
				num = 1;
			}
			ler.nextLine();
			if (num != 0){
				saida = 1; // encerra inserção
			}
		}
	}

	private static void insereProfessor(){
		while (saida == 0) {
			Professor professor = new Professor();

			System.out.print("Digite o nome do professor: ");
			while(professor.getNome() == null){
				professor.setNome(ler.nextLine());
			}
			System.out.print("Digite a matricula do professor: ");
			while(professor.getMatricula() <= 0){
				try {
					professor.setMatricula(ler.nextInt());					
				} catch (InputMismatchException e) {
					professor.setMatricula(0);
				}
				ler.nextLine();
			}
			System.out.print("Digite o id do curso do professor: ");
			while(professor.getIdCurso() <= 0){
				try {
					professor.setIdCurso(ler.nextInt());					
				} catch (InputMismatchException e) {
					professor.setIdCurso(0);
				}
				ler.nextLine();
			}
			while(professor.getDtAdmissao() == null){					
				professor.setDtAdmissao(CfgGeral.getDtSistema()); // pega data do sistema
			}
			Tela.listaProfessores.add(professor);
			System.out.println("Deseja inserir mais outro professor? Pressione 0 para sim, qualquer outro valor para não ");
			try{
				num = ler.nextInt();
			}catch(InputMismatchException e){
				num = 1;
			}
			ler.nextLine();
			if (num != 0){
				saida = 1;
			}
		}
	}
}