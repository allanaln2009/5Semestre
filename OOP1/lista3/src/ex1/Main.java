package ex1;

import java.util.Scanner;

public class Main {
	static Scanner l; 
	static float[] pontos;
	
	public static void main(String[] args) {
		l = new Scanner(System.in);
		pontos = new float[4];
		pegaDados();
		Calcula r = new Calcula(pontos[0], pontos[1], pontos[2], pontos[3]);
		System.out.println("O resultado é " + r.resDist() + ".");
	}
	
	private static void pegaDados() {
		float temp = -1;
		String text = "";
		
		for(int i = 0; i < pontos.length; i++){
			text = (i < 2) ? "X" : "Y"; // define se ponto é X ou Y
			text += (i == 0 || i == 2) ? "1" : "2"; // define ponto 1 ou 2 e concatena
			
			System.out.print("Digite o valor de " + text + ": ");
			while(temp < 0){
				try{
					temp =  l.nextFloat();
				}catch(Exception e){
					System.out.println("Digite um valor válido.");
					l.nextLine();
					continue;
				}
				l.nextLine();
			}
			pontos[i] = temp;
			temp = -1;
		}
	}
}
