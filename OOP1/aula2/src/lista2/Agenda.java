package lista2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Exercicío 7
public class Agenda {
	static Scanner scn;
	static ArrayList<Contato> contacts;
	static int opcao;
	static int cod;

	public static void main(String[] args) {
		scn = new Scanner(System.in);
		contacts = new ArrayList<Contato>();
		cod = 0;

		while(opcao != 4){
			opcao = menuPrincipal();
			if(opcao == 1){
				addCont();
			}else if(opcao == 2){
				try{
					opcao = searchCont().size(); // pega quantidade de dados encontrados
				}catch(NullPointerException e){
					continue; // trata caso nada seja encontrado
				}
				if(opcao > 1){
					System.out.println(opcao + " resultados encontrados");
				}else{
					System.out.println(opcao + " resultado encontrado");
				}
				scn.nextLine();
				opcao = 0;
			}else if(opcao == 3){
				deleteCont();
			}
		}
		System.out.println("Tchau!");
	}

	private static void deleteCont() {
		ArrayList<Integer> ids = searchCont(); // pega IDs encontrados de acordo com a busca realizada
		if(ids == null){
			return;
		}
		int codTemp = -1;
		System.out.print("Digite o código do contato para confirmar exclusão: ");
		try{
			codTemp = scn.nextInt();
		}catch(InputMismatchException e){
			scn.nextLine();
			System.out.println("Este não é um código numérico válido.");
			scn.nextLine();
			return;
		}
		scn.nextLine();
		for (int i = 0; i < ids.size(); i++) {
			// verifica se id informado está dentro do intervalo do resultado de busca
			if(codTemp == ids.get(i)){
				for (int j = 0; j < contacts.size(); j++) {
					// pega contato de acordo com código passado pelo usuário
					if(contacts.get(j).getId() == (codTemp - 1)){
						System.out.println("Contato de " + primeiroNome(contacts.get(j).getNome()) + " deletado!");
						contacts.remove(j); // remove contato setado pelo usuário
						scn.nextLine();
						return; // sai na primeira ocorrência
					}
				}
			}
		}
		System.out.println("Você só pode escolher um ID presente na lista exibida...");
		scn.nextLine();
	}

	private static ArrayList<Integer> searchCont() {
		if(!verifyExistingContacts()){ // não existe contato? retorna nulo
			return null;
		}
		String nome = "";
		System.out.print("Digite nomes para busca do contato: ");
		while(nome.isEmpty()){
			nome = scn.nextLine();
		}
		ArrayList<Integer> ids = new ArrayList<Integer>(); // conterá lista de contatos válidos na busca para deleção
		ArrayList<Contato> cTemp = searchByName(nome); // pega todos os resultados da busca
		if(cTemp == null || cTemp.size() == 0){
			System.out.println("Nenhum contato encontrado...");
			scn.nextLine();
			return null;
		}else{
			for (int i = 0; i < cTemp.size(); i++) {
				ids.add(cTemp.get(i).getId() + 1); // adiciona ID encontrado a lista de IDS válidos
				System.out.println(" ID: " + 
					(cTemp.get(i).getId() + 1) + " - " + // exibe código contato
					cTemp.get(i).getNome() + ": " + // nome
					cTemp.get(i).getEmail()); // email
			}
			return ids; // permite que a função verifique se a informação está dentro do intervalo das buscas
		}
	}

	private static boolean verifyExistingContacts() {
		if(contacts.isEmpty()){ // verifica se existem contatos
			System.out.println("Você ainda não cadastrou nenhum contato...");
			scn.nextLine();
			return false;
		}
		return true;
	}

	private static ArrayList<Contato> searchByName(String nome) {
		int n = 0;
		ArrayList<Contato> listaBusca = new ArrayList<Contato>();
		for (int i = 0; i < contacts.size(); i++) {
			// se nome da posicao do vetor for igual ao nome que o usuário quer (não é case sensitive)
			if(contacts.get(i).getNome().toLowerCase().contains(nome.toLowerCase())){
				listaBusca.add(contacts.get(i)); // salva contato em lista de busca
				n++;
			}
		}
		if(n == 0){ // nada foi encontrado? retorna nulo
			return null;
		}
		return listaBusca;
	}

	private static void addCont() {
		String nome = "";
		String email = "";
		System.out.print("Digite o nome do contato: ");
		while(nome.isEmpty()){
			nome = scn.nextLine();
		}
		System.out.print("Digite o email do contato: ");
		while(email.isEmpty()){
			email = scn.nextLine();
		}
		Contato c = new Contato(cod, nome, email);
		contacts.add(c);
		cod++;
		System.out.println("Contato salvo! ID: " + cod);
		scn.nextLine();
	}

	private static int menuPrincipal() {
		System.out.println("Escolha uma opção:\n 1.Cadastrar contato\n 2.Busca por nome\n 3.Deletar por nome\n 4.Sair");
		try{
			opcao = scn.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Digite uma opção válida.");
			scn.nextLine();
			return 0;
		}
		scn.nextLine();
		return opcao;
	}
	
	private static String primeiroNome(String nome){
		if (nome == null){ 
			return "";
		}
		String arrTemp[] = nome.trim().split(" ");
		return arrTemp[0];
	}
	
	public static String trataNome(String nome){
		String nomePronto = "";
		if (nome == null){
			return null;
		}
		String vetNomes[] = nome.toLowerCase().trim().split(" "); 
		for (int i = 0; i < vetNomes.length; i++) {
			vetNomes[i] = vetNomes[i].substring(0,1).toUpperCase().concat(vetNomes[i].substring(1)); 
			nomePronto += vetNomes[i] + " "; 
		}
		return nomePronto.trim();
	}
}
