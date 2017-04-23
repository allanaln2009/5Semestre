package lista2;

import java.util.InputMismatchException;
import java.util.Scanner;

//Exercício 4
public class TrocaNumero {

	static Scanner leitor;
	public static void main(String[] args) {
		leitor = new Scanner(System.in);
		int[] v = pegaNums();
		System.out.println("\nAntes:");
		exibeNums(v);
		int a = v[0];
		v[0] = v[1];
		v[1] = a;
		System.out.println("\nDepois:");
		exibeNums(v);
	}

	private static int[] pegaNums() {
		int[] v = new int[2];
		for (int i = 0; i < 2; i++) {
			while(true){
				System.out.print("Digite o valor " + (i+1) + ":");
				try{
					v[i] = leitor.nextInt();
				}catch(InputMismatchException e){
					leitor.nextLine();
					System.out.println("Digite um número.");
					continue;
				}
				leitor.nextLine();
				break;
			}
		}
		return v;
	}

	private static void exibeNums(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println("Num" + (i+1) + ": " + v[i]);
		}
	}

}
