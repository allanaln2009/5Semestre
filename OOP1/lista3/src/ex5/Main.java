package ex5;

import java.util.Scanner;

public class Main {
	static Scanner l;
	static Planetas p;
	public static void main(String[] args) {
		l = new Scanner(System.in);
		p = new Planetas();
		tela();
	}
	
	static void tela(){
		float pesoTerra = 0;
		int plan;

		System.out.println("Escolha um planeta:");
		for(int i = 0; i < p.getPlanetas().length; i++){
			System.out.println(" " + (i+1) + "." + p.getPlanetas()[i]);
		}
		
		plan = pegaPlaneta();
		pesoTerra = pegaPeso();
		System.out.println("Seu peso em " + p.getPlanetas()[plan] + " será " + p.calcula(plan, pesoTerra) + ".");
	}
	
	private static float pegaPeso() {
		float pesoTerra = 0;
		System.out.print("Digite seu peso na terra (ex:74,8): ");
		while(pesoTerra <= 0){
			try{
				pesoTerra = l.nextFloat();
			}catch(Exception e){
				l.nextLine();
				continue;
			}
			l.nextLine();
		}
		return pesoTerra;
	}
	private static int pegaPlaneta() {
		int plan = -1;
		String nomeP;
		while(plan < 0){
			try{
				plan = l.nextInt();
			}catch(Exception e){
				l.nextLine();
				continue;
			}
			l.nextLine();
			plan--;
			try{
				nomeP = p.getPlanetas()[plan];
			}catch(Exception e){
				System.out.println("Valor inválido");
				continue;
			}
		}
		return plan;
	}

}
