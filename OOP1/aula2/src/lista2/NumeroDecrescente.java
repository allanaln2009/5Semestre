package lista2;

import java.util.InputMismatchException;
import java.util.Scanner;

// Exercício 2
public class NumeroDecrescente {
	static Scanner l;
	static int v;
	public static void main(String[] args) {
		l = new Scanner(System.in);
		getNumber();
		showNumbers();
	}
	private static void getNumber() {
		System.out.print("Digite um inteiro: ");
		while(true){	
			try{
				v = l.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Digite um valor válido.");
				l.nextLine();
				continue;
			}
			l.nextLine();
			break;
		}
	}
	private static void showNumbers() {
		for (int i = v; i >= 0; i--) {
			if(i == 0){
				System.out.print(i+ ".");
			}else{
				System.out.print(i+ ", ");
			}
		}
	}

}
