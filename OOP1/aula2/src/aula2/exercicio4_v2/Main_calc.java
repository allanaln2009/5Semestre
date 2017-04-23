package aula2.exercicio4_v2;

import java.util.Scanner;

public class Main_calc {
	public static void main(String[] args) {
		Processa calc = new Processa();
		Scanner ler = new Scanner(System.in);
		System.out.print("Digite o primeiro valor: ");
		calc.setV1(ler.nextInt());
		System.out.print("Digite a operação (+, -, *, /): ");
		calc.setOp(ler.next());
		System.out.print("Digite o segundo valor: ");
		calc.setV2(ler.nextInt());
		
		calc.calcula();
		
		System.out.print("O resultado de " + calc.getV1() + " " + calc.getOp() + " " + calc.getV2() + " é " + calc.getRes());
		ler.close();
	}
}