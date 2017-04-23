package aula3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import aula2.Aluno;
import aula2.Professor;

public class Tela {
	static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	static ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args){
		/*
		Aluno p = new Aluno();
		p.setNome("Allan Lima da Cunha");
		p.setRa("9930011572");
		p.setIdCurso(2);
		p.setSemestre(5);
		lista.add(p);
		*/
		int tipo = 0;
		String entidade = "";
		int num = 0;
		int saida = 0;
		while (saida == 0){
			System.out.println("Escolha uma opção:\n 1 - Aluno\n 2 - Professor\n 3 - Sair");
			try{
				num = ler.nextInt();
			}catch(InputMismatchException e){
				num = 0;
			}
			ler.nextLine();
			
			if(num == 1){
				tipo = 1; // Aluno
				entidade = "aluno";
			}else if(num == 2){
				tipo = 2; // Professor
				entidade = "professor";
			}else if(num == 3){
				saida = 1;
				continue;
			}else{
				System.out.println("Digite uma opção válida.");
				continue;
			}

			System.out.println(":::" + entidade.toUpperCase() + ":::\nEscolha uma opção:\n 1 - cadastrar\n 2 - exibir\n 3 - voltar");
			try{
				num = ler.nextInt();
			}catch(InputMismatchException e){
				num = 0;
			}
			ler.nextLine();
			
			if (num == 1){
				Cadastrar.main(tipo);
			}else if(num == 2){
				Listar.main(tipo);
			}else if(num == 3){
				continue;
			}else{
				System.out.println("Digite uma opção válida.");
				continue;
			}
		}
		ler.close();
	}

}
