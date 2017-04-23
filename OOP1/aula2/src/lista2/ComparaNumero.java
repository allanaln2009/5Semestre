package lista2;

import java.util.InputMismatchException;
import java.util.Scanner;

// Exercício 5
public class ComparaNumero {
	static Scanner l = new Scanner(System.in);
	static int[] nums = new int[2];
	public static void main(String[] args) {
		pegaNums();
		comparaNums();
	}
	private static void comparaNums() {
		if(nums[0] != nums[1]){
			System.out.print("Os números são diferentes. ");
			if(nums[0] > nums[1]){
				System.out.print(nums[0] + " é maior que " + nums[1] + ".");
			}else{
				System.out.print(nums[0] + " é menor que " + nums[1] + ".");
			}
		}else{
			System.out.println("Os número são iguais.");
		}
	}
	private static void pegaNums() {
		for (int i = 0; i < nums.length; i++) {
			while(true){
				System.out.print("Digite o " + (i+1) + "º valor: ");
				try {
					nums[i] = l.nextInt();
				} catch (InputMismatchException e) {
					l.nextLine();
					System.out.println("Digite um valor válido.");
					continue;
				}
				l.nextLine();
				break;
			}
		}
	}

}
