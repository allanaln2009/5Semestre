package ex4;

import java.util.Scanner;

public class Main {
	static Scanner l;
	public static void main(String[] args) {
		l = new Scanner(System.in);
		Notas n = new Notas();	
		n.setN1(pegaNota(1));
		n.setN2(pegaNota(2));
		n.calcMedia();
		n.verificaMedia();
		
		n.setN3(pegaNota(3));
		n.calcMedia();
		n.verificaMedia();
	}
	private static float pegaNota(int i) {
		float a = 0;
		System.out.print("Digite a " + i + "ª nota: ");
		try{
			a = l.nextFloat();
		}catch(Exception e){
			System.out.println("Valor inválido. Nota zerada.");
			a = 0;
		}
		l.nextLine();
		if(a < 0 || a > 10){
			System.out.println("Valor inválido. Nota zerada.");
			return 0;
		}else
			return a;
	}
}
