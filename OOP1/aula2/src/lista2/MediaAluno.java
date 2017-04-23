package lista2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Exercício 6
public class MediaAluno {
	static Scanner l;
	static ArrayList<Integer> notas;
	static int opcao;
	public static void main(String[] args) {
		l = new Scanner(System.in);
		notas = new ArrayList<Integer>();
		opcao = 0;
		while(opcao != 3){
			opcao = exibeMenu();
			if(opcao == 1){
				cadastrarNota();
			}else if(opcao == 2){
				calcularMedia();
			}else{
				System.out.print("Digite um valor válido.");
			}
		}
	}
	private static void calcularMedia() {
		float media = 0;
		for (int i = 0; i < notas.size(); i++) {
			media += notas.get(i);
		}
		media /= notas.size();
		System.out.println("A média é : " + media);
	}
	private static void cadastrarNota() {
		int nota = -1;
		System.out.print("Digite uma nota: ");
		try {
			nota = l.nextInt();
		} catch (InputMismatchException e) {
			l.nextLine();
			System.out.println("Valor não válido.");
			return;
		}
		l.nextLine();
		if (nota >= 0 && nota <= 100) {
			notas.add(nota);
		}else{
			System.out.println("A nota não pode ser menor que 0 nem maior que 100.");
		}
	}
	static int exibeMenu(){
		System.out.println("Escolha uma opcao:\n1-Adicionar nota\n2-Calcular média\n3-Sair");
		try {
			opcao = l.nextInt();
		} catch (InputMismatchException e) {
			l.nextLine();
			System.out.print("Valor inválido. ");
			return 0;
		}
		l.nextLine();
		return opcao;
	}
}
