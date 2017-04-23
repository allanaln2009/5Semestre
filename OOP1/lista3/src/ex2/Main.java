package ex2;

import java.util.Scanner;

public class Main {
	static Scanner l; 
	static float l1;
	static float l2;
	static float l3;
	
	public static void main(String[] args) {
		l = new Scanner(System.in);
		pegaMedidas();
		AnalisaTri t = new AnalisaTri();
		System.out.print("O triângulo é " + t.tipoTri(l1, l2, l3) + ".");
		l.close();
	}

	private static void pegaMedidas() {
		System.out.print("Digite a medida do lado 1: ");
		l1 =  l.nextFloat(); l.nextLine();
		System.out.print("Digite a medida do lado 2: ");
		l2 =  l.nextFloat(); l.nextLine();
		System.out.print("Digite a medida do lado 3: ");
		l3 =  l.nextFloat(); l.nextLine();
	}

}
