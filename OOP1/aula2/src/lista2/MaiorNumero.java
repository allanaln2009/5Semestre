package lista2;

import java.util.InputMismatchException;
import java.util.Scanner;

// Exercício 1
public class MaiorNumero {
	static Scanner l = new Scanner(System.in);
	public static void main(String[] args) {
		int[] v = new int[2];
		pegaNums(v);
		pegaMaior(v);
	}
	private static void pegaMaior(int[] v) {
		if(v[0] > v[1]){
			System.out.print("Maior: " + v[0]);
		}else if(v[0] < v[1]){
			System.out.print("Maior: " + v[1]);
		}else{
			System.out.print("Os números são iguais.");
		}
	}
	private static void pegaNums(int[] v) {
		for (int i = 0; i < 2; i++) {
			System.out.print("Digite o valor " + (i+1) + ": ");
			try{
				v[i] = l.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Valor inválido, setando 0.");
				v[i] = 0;
			}
			l.nextLine();
		}
	}

}
