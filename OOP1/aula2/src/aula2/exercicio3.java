package aula2;

import java.util.Scanner;

public class exercicio3 {
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		System.out.print("Digite o primeiro valor: ");
		int v1 = ler.nextInt();
		System.out.print("Digite o segundo valor: ");
		int v2 = ler.nextInt();
		System.out.print("A soma é: " + (v1+v2));
		ler.close();
	}
}
