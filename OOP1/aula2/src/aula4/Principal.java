package aula4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	static int opcao;
	static int posicao;
	static int qtd;
	static Scanner leitor;
	static String nome;
	static String telefone;
	static Pessoa[] pessoas;

	public static void main(String[] args) {
		posicao = 0; // posicao inicial vetor de armazenamento
		qtd = 50; // quantidade maxima de contatos
		pessoas = new Pessoa[qtd]; // vetor armazenamento
		leitor = new Scanner(System.in); // nome sugestivo
		while(opcao != 3){ // desenha tela até usuário solicitar saída 
			telaPrincipal();
		}
	}
	public static void telaPrincipal(){
		nome = "";
		telefone = "";
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::: Contatos :::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
		System.out.println("Selecione uma opção:\n 1 - Inserir\n 2 - Listar\n 3 - Sair");
		try{			
			opcao = leitor.nextInt();
		}catch(InputMismatchException e){
			opcao = 0;
		}
		leitor.nextLine();
		if(opcao == 1){ // inserção
			if(posicao >= qtd){
				System.out.println("Memória cheia, você não pode inserir mais contatos.\nPressione enter para continuar...");
				leitor.nextLine();
				return;
			}
			telaCadastro();
		}else if(opcao == 2){
			telaListagem();
		}else if(opcao == 3){
			System.exit(0);
		}else{
			System.out.println("Digite uma opção válida.");
		}
	}
	public static void telaCadastro(){
		while(nome.isEmpty()){
			System.out.println("Digite o nome do contato: ");
			nome = leitor.nextLine();
		}
		while(telefone.isEmpty()){
			System.out.println("Digite o telefone do contato: ");
			telefone = leitor.nextLine();
			telefone = telefone.replaceAll("[^0-9]", "");
		}
		Pessoa p = new Pessoa(nome, telefone); // cria objeto temporário
		try{
			pessoas[posicao] = p; // obj temporário é alocado no vetor de armazenamento
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Não há espaço na memória");
			return;
		}
		posicao++;
		System.out.println("Contato inserido com sucesso.");
	}
	public static void telaListagem(){
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::: Lista de  Contatos :::::::::");
		for (int i = 0; i < pessoas.length; i++) {
			try{
				System.out.println((i + 1) + " - " + pessoas[i].getNome() + "\t\t" + pessoas[i].getTelefone());
			}catch(NullPointerException e){
				break;
			}
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
	}
}
