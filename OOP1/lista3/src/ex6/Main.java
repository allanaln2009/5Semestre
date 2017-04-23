package ex6;

import java.util.Scanner;

public class Main {
	static Scanner l;
	static Integer n1;
	static Integer n2;
	static Numeros n;
	public static void main(String[] args) {
		l = new Scanner(System.in);
		n1 = pegaNum(1);
		n2 = pegaNum(2);
		n = new Numeros(n1, n2);
		System.out.println("Resultado para numeros de " + (n.getN1() + 1) + " a " + (n.getN2() - 1) + ": ");
		System.out.println("Soma dos valores: " + n.somaInt());
		System.out.println("Número de inteiros: " + n.intsBetween());
		System.out.println("Número de inteiros impares: " + n.intsImpares());
		l.nextLine();
		System.out.println(n.descNums());
	}
	private static Integer pegaNum(int val) {
		Integer n = null;
		System.out.print("Digite o " + val + "º valor: ");
		while(n == null){
			try{
				n = l.nextInt();
			}catch(Exception e){
				l.nextLine();
				continue;
			}
			l.nextLine();
		}
		return n;
	}

}
