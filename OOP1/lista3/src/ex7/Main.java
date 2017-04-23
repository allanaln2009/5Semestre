package ex7;

import java.util.Scanner;

public class Main {
	static Scanner l;
	static Jogo j;

	public static void main(String[] args) {
		l = new Scanner(System.in);
		j = new Jogo();
		int again = 0;
		int num;
		while(again == 0){
			System.out.print("Digite um valor entre 0 e 100: ");
			j.setPass(getPass());
			System.out.print("Pressione enter e chame o jogador 2...");
			l.nextLine();
			clearScreen();
			while(j.getAttempts() < 5){
				System.out.println("Tente adivinhar a senha... Você tem " + (5 - j.getAttempts()) + " tentativa(s).");
				num = getPass();
				System.out.println(j.comparePass(num));
				if(j.comparePass(num).contains("acertou"))
					break;
				j.addAttempts();
			}
			System.out.print("Jogar novamente? Insira 0 ou 1 para não.");
			try{
				again = l.nextInt();
			}catch(Exception e){
				System.exit(0);
			}
			l.nextLine();
			clearScreen();
			j.restart();
		}
		System.out.println("Tchau!");
	}

	private static void clearScreen() {
		for(int i = 0; i < 450; i++){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			);
		}
	}

	private static int getPass() {
		int pass = -1;
		while(pass < 0){
			try{
				pass = l.nextInt();
			}catch(Exception e){
				System.out.println("Digite um valor ENTRE 0 e 100.");
				l.nextLine();
				continue;
			}
			l.nextLine();
			if(!(pass > 0 && pass < 100)){
				System.out.println("Digite um valor ENTRE 0 e 100.");
				pass = -1;
				continue;
			}
		}
		return pass;
	}
}
