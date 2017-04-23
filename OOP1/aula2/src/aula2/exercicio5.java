package aula2;

import java.util.Arrays;
import java.util.Random;

public class exercicio5{
	public static void main(String[] args){
		Random r = new Random();
		int[] inteiros = new int[10];
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = r.nextInt(1000);
		}
		ordenaVetor(inteiros); //ou
		Arrays.sort(inteiros);
		for (int i = 0; i < inteiros.length; i++) {
			System.out.print(inteiros[i]);
			if (i != (inteiros.length - 1)){
				System.out.print(", ");
			}
		}
	}
	private static void ordenaVetor(int[] inteiros){ //BubleSort
		for (int i = 0; i < (inteiros.length - 1); i++) {
			for (int j = i; j < inteiros.length; j++) {
				if (inteiros[i] > inteiros[j]){
					int aux = inteiros[i];
					inteiros[i] = inteiros[j];
					inteiros[j] = aux;
				}
			}
		}
	}
}
