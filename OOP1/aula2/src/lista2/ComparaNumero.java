package lista2;

import java.util.InputMismatchException;
import java.util.Scanner;

// Exerc�cio 5
public class ComparaNumero {
	static Scanner l = new Scanner(System.in);
	static int[] nums = new int[2];
	public static void main(String[] args) {
		pegaNums();
		comparaNums();
	}
	private static void comparaNums() {
		if(nums[0] != nums[1]){
			System.out.print("Os n�meros s�o diferentes. ");
			if(nums[0] > nums[1]){
				System.out.print(nums[0] + " � maior que " + nums[1] + ".");
			}else{
				System.out.print(nums[0] + " � menor que " + nums[1] + ".");
			}
		}else{
			System.out.println("Os n�mero s�o iguais.");
		}
	}
	private static void pegaNums() {
		for (int i = 0; i < nums.length; i++) {
			while(true){
				System.out.print("Digite o " + (i+1) + "� valor: ");
				try {
					nums[i] = l.nextInt();
				} catch (InputMismatchException e) {
					l.nextLine();
					System.out.println("Digite um valor v�lido.");
					continue;
				}
				l.nextLine();
				break;
			}
		}
	}

}
