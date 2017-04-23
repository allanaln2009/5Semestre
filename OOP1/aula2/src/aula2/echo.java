package aula2;

import java.util.Scanner;
public class echo{
	public static void main(String[] args){
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite algo:");
		String texto = leia.nextLine();
		System.out.println("Você escreveu: " + texto);
		leia.close();
	}
}
