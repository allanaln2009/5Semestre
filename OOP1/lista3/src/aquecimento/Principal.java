package aquecimento;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		Agenda a = new Agenda();
		a.armazenaPessoa("Állan", 20, 1.64f);
		String nome = l.nextLine();
		a.armazenaPessoa("Danillo", 20, 1.64f);
		a.armazenaPessoa("Laryssa", 20, 1.64f);
		a.removePessoa(l.nextLine());
		a.buscaPessoa("Állan");
		a.imprimeAgenda();
		a.imprimePessoa(0);
		
		
	}

}
